package com.example.demo.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.demo.dto.DetailsPurchaseOrderDTO;
import com.example.demo.dto.PurchaseOrderDTO;
import com.example.demo.mapper.PurchaseOrderMapper;
import com.example.demo.models.*;
import com.example.demo.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderService {

    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    DetailPurchaseOrderRepository detailPurchaseOrderRepository;

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    StatusPurchaseOrderRepository statusPurchaseOrderRepository;

    @Autowired
    ProductRepository productRepository;


    public List<PurchaseOrderDTO> getAllPurchaseOrder() {
        List<PurchaseOrdersModel> purchaseOrdersModels = purchaseOrderRepository.findAll();
        List<PurchaseOrderDTO> responseDto = new ArrayList<>();

        for (PurchaseOrdersModel order : purchaseOrdersModels) {
            if (!order.isDeleteOrder()) {
                PurchaseOrderMapper.getPurchaseOrder(order).ifPresent(responseDto::add);
            }
        }
        return responseDto;
    }

    public List<PurchaseOrderDTO> getAllPurchaseOrderDelete() {
        List<PurchaseOrdersModel> purchaseOrdersModels = purchaseOrderRepository.findAll();
        List<PurchaseOrderDTO> responseDto = new ArrayList<>();

        for (PurchaseOrdersModel order : purchaseOrdersModels) {
            if (order.isDeleteOrder()) {
                PurchaseOrderMapper.getPurchaseOrder(order).ifPresent(responseDto::add);
            }
        }
        return responseDto;
    }

    public Optional<PurchaseOrderDTO> getPurchaseOrderrById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID de la orden de compra debe ser mayor que 0");
        }
        Optional<PurchaseOrdersModel> optionalPurchaseOrdersModel = purchaseOrderRepository.findById(id);
        if (optionalPurchaseOrdersModel.isPresent()) {
            return PurchaseOrderMapper.getPurchaseOrder(optionalPurchaseOrdersModel.get());
        } else {
            throw new NoSuchElementException("No se encontró la orden de compra con ID: " + id);
        }
    }

    public PurchaseOrdersModel postPurchaseOrder(PurchaseOrderDTO purchaseOrder) {
        PurchaseOrdersModel purchaseOrdersModel = convertToEntity(purchaseOrder);
        purchaseOrdersModel.setDeleteOrder(false);
        purchaseOrdersModel.setCreated_at(new Timestamp(System.currentTimeMillis()));
        purchaseOrdersModel.setUpdate_at(new Timestamp(System.currentTimeMillis()));
        return purchaseOrderRepository.save(purchaseOrdersModel);
    }

    public PurchaseOrdersModel convertToEntity(PurchaseOrderDTO purchaseOrderDTO) {

        PurchaseOrdersModel purchaseOrdersModel = new PurchaseOrdersModel();

        purchaseOrdersModel.setDateIssuePurchaseOrder(purchaseOrderDTO.getDateIssue());
        purchaseOrdersModel.setDateDeliveryPurchaseOrder(purchaseOrderDTO.getDateDelivery());
        purchaseOrdersModel.setReceptionPurchaseOrder(purchaseOrderDTO.getRecepcion());
        purchaseOrdersModel.setTotalPurchaseOrder(purchaseOrderDTO.getTotal());

        Optional<SuppliersModel> supplier = supplierRepository.findByNameSupplier(purchaseOrderDTO.getSupplier());
        if (supplier.isEmpty()) {
            throw new EntityNotFoundException("Proveedor no encontrada: " + purchaseOrderDTO.getSupplier());
        } else {
            purchaseOrdersModel.setSupplier(supplier.get());
        }

        Optional<StatusPurchaseOrdersModel> statusOrder = statusPurchaseOrderRepository.findByStatus(purchaseOrderDTO.getStatus());
        if (statusOrder.isEmpty()) {
            throw new EntityNotFoundException("ESTADO ORDEN DE COMPRA no encontrada: " + purchaseOrderDTO.getStatus());
        } else {
            purchaseOrdersModel.setStatusOrder(statusOrder.get());
        }

        List<DetailsPurchaseOrdersModel> detailsList = new ArrayList<>();
        purchaseOrdersModel.setDetailsPurchaseList(detailsList);
        PurchaseOrdersModel purchaseOrders = purchaseOrderRepository.save(purchaseOrdersModel);

        purchaseOrdersModel.setId(purchaseOrders.getId());

        for (DetailsPurchaseOrderDTO detailsDTO : purchaseOrderDTO.getProducts()) {
            DetailsPurchaseOrdersModel detailsModel = convertToEntityDetail(detailsDTO);

            detailsModel.setPurchaseOrder(purchaseOrdersModel);
            detailPurchaseOrderRepository.save(detailsModel);

            detailsList.add(detailsModel);
        }

        purchaseOrdersModel.setDetailsPurchaseList(detailsList);

        return purchaseOrderRepository.save(purchaseOrdersModel);
    }

    public DetailsPurchaseOrdersModel convertToEntityDetail(DetailsPurchaseOrderDTO detailsPurchaseOrderDTO) {
        DetailsPurchaseOrdersModel detailsPurchaseOrdersModel = new DetailsPurchaseOrdersModel();

        detailsPurchaseOrdersModel.setQuantityDetail(detailsPurchaseOrderDTO.getUnitProduct());

        Optional<ProductModel> product = productRepository.findByNameProduct(detailsPurchaseOrderDTO.getNameProduct());
        if (product.isEmpty()) {
            throw new EntityNotFoundException("PRODUCTO no encontrada: " + detailsPurchaseOrderDTO.getNameProduct());
        }

        double price = product.get().getPriceProduct();
        detailsPurchaseOrdersModel.setPriceDetail(price);

        detailsPurchaseOrdersModel.setProduct(product.get());
        return detailsPurchaseOrdersModel;
    }

    public PurchaseOrdersModel updatePurchaseOrder(int orderId, Timestamp newDateDelivery, String newReception) {
        Optional<PurchaseOrdersModel> existingOrderOptional = purchaseOrderRepository.findById(orderId);
        PurchaseOrdersModel existingOrder = existingOrderOptional.orElseThrow(() -> new EntityNotFoundException("Orden de compra no encontrada con ID: " + orderId));

        if (newDateDelivery != null) {
            existingOrder.setDateDeliveryPurchaseOrder(newDateDelivery);
        }
        if (newReception != null) {
            existingOrder.setReceptionPurchaseOrder(newReception);
        }
        return purchaseOrderRepository.save(existingOrder);
    }

    public Optional<PurchaseOrderDTO> findByDeletePurchaseOrderFalse(int id) {
        Optional<PurchaseOrdersModel> optional = purchaseOrderRepository.findById(id);
        if (optional.isPresent()) {
            PurchaseOrdersModel existingPurchaseOrder = optional.get();
            if (!existingPurchaseOrder.isDeleteOrder()) {
                Optional<StatusPurchaseOrdersModel> canceledStatus = statusPurchaseOrderRepository.findByStatus("Cancelado");
                if (canceledStatus.isPresent()) {
                    existingPurchaseOrder.setDeleteOrder(true);
                    existingPurchaseOrder.setStatusOrder(canceledStatus.get());
                    existingPurchaseOrder.setUpdate_at(new Timestamp(System.currentTimeMillis()));
                    purchaseOrderRepository.save(existingPurchaseOrder);
                    return PurchaseOrderMapper.getPurchaseOrder(existingPurchaseOrder);
                } else {
                    throw new EntityNotFoundException("ERROR EN CANCELADO");
                }
            }
        }
        return Optional.empty();
    }

    public long countActivePurchaseOrder() {
        return purchaseOrderRepository.countByDeleteOrderFalse();
    }

    public long countDeletedPurchaseOrder() {
        return purchaseOrderRepository.countByDeleteOrderTrue();
    }

}
