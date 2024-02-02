package com.example.demo.mapper;

import com.example.demo.dto.DetailsPurchaseOrderDTO;
import com.example.demo.dto.PurchaseOrderDTO;
import com.example.demo.models.DetailsPurchaseOrdersModel;
import com.example.demo.models.PurchaseOrdersModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PurchaseOrderMapper {
    public static Optional<PurchaseOrderDTO> getPurchaseOrder(PurchaseOrdersModel purchaseOrdersModel) {

        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
        purchaseOrderDTO.setIdPurchaseOrder(purchaseOrdersModel.getId());
        purchaseOrderDTO.setDateIssue(purchaseOrdersModel.getDateIssuePurchaseOrder());
        purchaseOrderDTO.setDateDelivery(purchaseOrdersModel.getDateDeliveryPurchaseOrder());
        purchaseOrderDTO.setRecepcion(purchaseOrdersModel.getReceptionPurchaseOrder());
        purchaseOrderDTO.setSupplier(purchaseOrdersModel.getSupplier().getNameSupplier());
        purchaseOrderDTO.setTotal(purchaseOrdersModel.getTotalPurchaseOrder());
        purchaseOrderDTO.setStatus(purchaseOrdersModel.getStatusOrder().getStatus());

        List<DetailsPurchaseOrderDTO> detailsDTOList = mapDetailsList(purchaseOrdersModel.getDetailsPurchaseList());
        purchaseOrderDTO.setProducts(detailsDTOList);
        return Optional.of(purchaseOrderDTO);
    }
    public static List<DetailsPurchaseOrderDTO> mapDetailsList(List<DetailsPurchaseOrdersModel> detailsPurchaseList) {

        List<DetailsPurchaseOrderDTO> dtoList = new ArrayList<>();
        for (DetailsPurchaseOrdersModel details : detailsPurchaseList){
            DetailsPurchaseOrderDTO purchaseOrderDTO = new DetailsPurchaseOrderDTO();
            purchaseOrderDTO.setIdDetailPurchase(details.getIdDetailPurchase());
            purchaseOrderDTO.setIdProduct(details.getProduct().getIdProduct());
            purchaseOrderDTO.setNameProduct(details.getProduct().getNameProduct());
            purchaseOrderDTO.setUnitProduct(details.getQuantityDetail());
           purchaseOrderDTO.setPriceProduct(details.getProduct().getPriceProduct());
            dtoList.add(purchaseOrderDTO);
        }
        return dtoList;
    }
}
