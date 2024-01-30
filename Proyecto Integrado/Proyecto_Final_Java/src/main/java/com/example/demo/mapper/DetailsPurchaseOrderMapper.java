package com.example.demo.mapper;


import com.example.demo.dto.DetailsPurchaseOrderDTO;
import com.example.demo.models.DetailsPurchaseOrdersModel;


import java.util.Optional;

public class DetailsPurchaseOrderMapper {
    public static Optional<DetailsPurchaseOrderDTO> getDetailOrderResponse(DetailsPurchaseOrdersModel detail) {

        DetailsPurchaseOrderDTO detailsPurchaseOrderDTO = new DetailsPurchaseOrderDTO();
        detailsPurchaseOrderDTO.setIdDetailPurchase(detail.getIdDetailPurchase());
        detailsPurchaseOrderDTO.setIdProduct(detail.getProduct().getIdProduct());
        detailsPurchaseOrderDTO.setNameProduct(detail.getProduct().getNameProduct());
        //detailsPurchaseOrderDTO.setPriceProduct(detail.getPriceDetail());
        detailsPurchaseOrderDTO.setPriceProduct(detail.getProduct().getPriceProduct());

        detailsPurchaseOrderDTO.setUnitProduct(detail.getQuantityDetail());
        return Optional.of(detailsPurchaseOrderDTO);
    }
}
