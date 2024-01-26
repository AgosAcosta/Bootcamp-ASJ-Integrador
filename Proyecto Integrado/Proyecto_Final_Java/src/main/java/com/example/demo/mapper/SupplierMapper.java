package com.example.demo.mapper;

import java.util.Optional;

import com.example.demo.dto.SupplierResponseDTO;
import com.example.demo.models.Suppliers_Model;

public class SupplierMapper {

	public static Optional<SupplierResponseDTO> getSupplierResponse(Suppliers_Model supplier) {

		SupplierResponseDTO supplierResponse = new SupplierResponseDTO();

		supplierResponse.setIdSupplier(supplier.getId_supplier());
		supplierResponse.setUrlLogo(supplier.getUrl_supplier());
		supplierResponse.setCodeSupplier(supplier.getCode_supplier());
		supplierResponse.setNameSupplier(supplier.getNameSupplier());
		supplierResponse.setCuitSupplier(supplier.getCuit_supplier());
		
		supplierResponse.setCondicionAfipSupplier(supplier.getCondition_afip().getCondition());
		supplierResponse.setCategorySupplier(supplier.getCategory_supplier().getCategory_supplier());
		supplierResponse.setStreetSupplier(supplier.getDirection().getStreet_supplier());
		supplierResponse.setNumSupplier(supplier.getDirection().getNum_supplier());
		supplierResponse.setCpSupplier(supplier.getDirection().getCp_supplier());
		supplierResponse.setLocationSupplier(supplier.getDirection().getLocation());
		supplierResponse.setProvinceSupplier(supplier.getDirection().getProvince().getProvince());
		supplierResponse.setCountrySupplier(supplier.getDirection().getProvince().getCountry().getCountry());
		
		supplierResponse.setWebSupplier(supplier.getWeb_supplier());
		supplierResponse.setEmailSupplier(supplier.getEmail_supplier());
		supplierResponse.setTelSupplier(supplier.getTel_supplier());
		
		
		supplierResponse.setNamecontactSupplier(supplier.getContact().getName_contact());
		supplierResponse.setLastNamecontactSupplier(supplier.getContact().getLast_name_contact());
		supplierResponse.setTelcontactSupplier(supplier.getContact().getTel_contact());
		supplierResponse.setEmailcontactSupplier(supplier.getContact().getEmail_contact());
		supplierResponse.setRolcontactSupplier(supplier.getContact().getRol_contact());
		
		return Optional.of(supplierResponse);

	}
}


