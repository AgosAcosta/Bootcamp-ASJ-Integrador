package com.example.demo.mapper;

import java.util.Optional;

import com.example.demo.dto.SupplierResponseDTO;
import com.example.demo.models.SuppliersModel;

public class SupplierMapper {

	public static Optional<SupplierResponseDTO> getSupplierResponse(SuppliersModel supplier) {

		SupplierResponseDTO supplierResponse = new SupplierResponseDTO();

		supplierResponse.setIdSupplier(supplier.getIdSupplier());
		supplierResponse.setUrlLogo(supplier.getUrlSupplier());
		supplierResponse.setCodeSupplier(supplier.getCodeSupplier());
		supplierResponse.setNameSupplier(supplier.getNameSupplier());
		supplierResponse.setCuitSupplier(supplier.getCuitSupplier());
		
		supplierResponse.setCondicionAfipSupplier(supplier.getConditionAfip().getCondition());
		supplierResponse.setCategorySupplier(supplier.getCategorySupplier().getCategory_supplier());
		supplierResponse.setStreetSupplier(supplier.getDirection().getStreetSupplier());
		supplierResponse.setNumSupplier(supplier.getDirection().getNumSupplier());
		supplierResponse.setCpSupplier(supplier.getDirection().getCpSupplier());
		supplierResponse.setLocationSupplier(supplier.getDirection().getLocation());
		supplierResponse.setProvinceSupplier(supplier.getDirection().getProvince().getProvince());
		supplierResponse.setCountrySupplier(supplier.getDirection().getProvince().getCountry().getCountry());
		
		supplierResponse.setWebSupplier(supplier.getWebSupplier());
		supplierResponse.setEmailSupplier(supplier.getEmailSupplier());
		supplierResponse.setTelSupplier(supplier.getTelSupplier());
		
		
		supplierResponse.setNamecontactSupplier(supplier.getContact().getNameContact());
		supplierResponse.setLastNamecontactSupplier(supplier.getContact().getLastNameContact());
		supplierResponse.setTelcontactSupplier(supplier.getContact().getTelContact());
		supplierResponse.setEmailcontactSupplier(supplier.getContact().getEmailContact());
		supplierResponse.setRolcontactSupplier(supplier.getContact().getRolContact());
		
		return Optional.of(supplierResponse);

	}
}


