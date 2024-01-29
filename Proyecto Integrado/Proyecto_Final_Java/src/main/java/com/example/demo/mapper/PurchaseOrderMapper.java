package com.example.demo.mapper;

import com.example.demo.dto.DetailsPurchaseOrderDTO;
import com.example.demo.dto.PurchaseOrderDTO;
import com.example.demo.models.DetailsPurchaseOrdersModel;
import com.example.demo.models.PurchaseOrdersModel;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PurchaseOrderMapper {
    public static Optional<PurchaseOrderDTO> getPurchaseOrder(PurchaseOrdersModel purchaseOrdersModel) {

        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
        purchaseOrderDTO.setIdPurchaseOrder(purchaseOrdersModel.getIdPurchaseOrder());
        purchaseOrderDTO.setCodePurchaseOrder(purchaseOrdersModel.getCodePurchaseOrder());
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
        return detailsPurchaseList.stream()
                .map(DetailsPurchaseOrderMapper::getDetailOrderResponse)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
