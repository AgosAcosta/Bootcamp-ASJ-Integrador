package com.example.demo.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SupplierResponseDTO;
import com.example.demo.mapper.SupplierMapper;
import com.example.demo.models.Categories_Supplier_Model;
import com.example.demo.models.Conditions_Afip_Model;
import com.example.demo.models.Contacts_Model;
import com.example.demo.models.Directions_Model;
import com.example.demo.models.Provinces_Model;
import com.example.demo.models.Suppliers_Model;
import com.example.demo.repositories.CategoriesSupplierRespository;
import com.example.demo.repositories.ConditionsAfipRepository;
import com.example.demo.repositories.ContactRepository;
import com.example.demo.repositories.DirectionRepository;
import com.example.demo.repositories.ProvinceRepository;
import com.example.demo.repositories.SupplierRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SupplierService {

	@Autowired
	SupplierRepository supplierRepository;
	
	@Autowired
	ConditionsAfipRepository conditionsAfipRepository;
	
	@Autowired
	ContactRepository contactRepository;
	
	@Autowired
	DirectionRepository directionRepository;
	
	@Autowired
	CategoriesSupplierRespository categoriesSupplierRespository;

	@Autowired
	ProvinceRepository provinceRepository;
	
	// OBTENER TODOS LOS PROVEEDORES

	public List<SupplierResponseDTO> getAllSupplier() {
		List<Suppliers_Model> suppliers_Model = supplierRepository.findAll();
		List<SupplierResponseDTO> responseDTO = new ArrayList<SupplierResponseDTO>();
		
		for (Suppliers_Model supplier : suppliers_Model) {
			responseDTO.add(SupplierMapper.getSupplierResponse(supplier).get());
		}
		return responseDTO;
	}
	
	// OBTENER PROVEEDOR POR ID

	public Optional<SupplierResponseDTO> getSupplierById(int id) {
	    if (id <= 0) {
	        throw new IllegalArgumentException("El ID del proveedor debe ser mayor que 0");
	    }
	    Optional<Suppliers_Model> optionalSupplier = supplierRepository.findById(id);

	    if (optionalSupplier.isPresent()) {
	        return SupplierMapper.getSupplierResponse(optionalSupplier.get());
	        
	    } else {
	        throw new NoSuchElementException("No se encontró el proveedor con ID: " + id);
	    }
	}

	// POST PROVEEDOR
	
	public Suppliers_Model postSupplier(SupplierResponseDTO supplier) {
		Suppliers_Model suppliers_Model = convertToEntity(supplier);		 
		 suppliers_Model.setDeleteSupplier(false);
		 suppliers_Model.setCreated_at(new Timestamp(System.currentTimeMillis()));
		 suppliers_Model.setUpdate_at(new Timestamp(System.currentTimeMillis()));
		return supplierRepository.save(suppliers_Model);	
	}

	
    public Suppliers_Model convertToEntity(SupplierResponseDTO supplierRequestDTO) {
    	
        Suppliers_Model supplier = new Suppliers_Model();

        supplier.setUrl_supplier(supplierRequestDTO.getUrlLogo());
        supplier.setCode_supplier(supplierRequestDTO.getCodeSupplier());
        supplier.setNameSupplier(supplierRequestDTO.getNameSupplier());
        supplier.setCuit_supplier(supplierRequestDTO.getCuitSupplier());
        supplier.setWeb_supplier(supplierRequestDTO.getWebSupplier());
        supplier.setEmail_supplier(supplierRequestDTO.getEmailSupplier());
        supplier.setTel_supplier(supplierRequestDTO.getTelSupplier());
 
        //CONDICION 
       Optional<Conditions_Afip_Model> conditionAfip = conditionsAfipRepository.findByCondition(supplierRequestDTO.getCondicionAfipSupplier());
       if(conditionAfip.isEmpty()) {    	   
    	  throw new EntityNotFoundException("Condición AFIP no encontrada: " + supplierRequestDTO.getCondicionAfipSupplier());
       }                
        supplier.setCondition_afip(conditionAfip.get());      
      
        //RUBRO 
        Optional<Categories_Supplier_Model> categorySupplier = categoriesSupplierRespository.findByCategorySupplier(supplierRequestDTO.getCategorySupplier());
        if(categorySupplier.isEmpty()) {
        	throw new EntityNotFoundException("Categoría de proveedor no encontrada con ID: " + supplierRequestDTO.getCategorySupplier());
        }
        supplier.setCategory_supplier(categorySupplier.get());
        
        //DIRECCION 
        
        Directions_Model direction = new Directions_Model();
        direction.setStreet_supplier(supplierRequestDTO.getStreetSupplier());
        direction.setNum_supplier(supplierRequestDTO.getNumSupplier());
        direction.setCp_supplier(supplierRequestDTO.getCpSupplier());
        direction.setLocation(supplierRequestDTO.getLocationSupplier());
        
        Optional<Provinces_Model> provinceSupplier = provinceRepository.findByProvince(supplierRequestDTO.getProvinceSupplier());
        
        if (provinceSupplier == null) {
            throw new EntityNotFoundException("Provincia no encontrada: " + supplierRequestDTO.getProvinceSupplier());
        }
        direction.setProvince(provinceSupplier.get());
        
        supplier.setDirection(direction);
        
        //CONTACTO
        
        Contacts_Model contact = new Contacts_Model();
        contact.setName_contact(supplierRequestDTO.getNamecontactSupplier());
        contact.setLast_name_contact(supplierRequestDTO.getLastNamecontactSupplier());
        contact.setTel_contact(supplierRequestDTO.getTelcontactSupplier());
        contact.setEmail_contact(supplierRequestDTO.getEmailcontactSupplier());
        contact.setRol_contact(supplierRequestDTO.getRolcontactSupplier());

        supplier.setContact(contact);

        supplierRepository.save(supplier);

        return supplier;
    }
    
    
    public Suppliers_Model updateSupplier(int id, SupplierResponseDTO supplier) {
		
    	Optional<Suppliers_Model> existingSupplierOptional = supplierRepository.findById(id);
    	 if (existingSupplierOptional.isEmpty()) {
             throw new EntityNotFoundException("Proveedor no encontrado con ID: " + id);
         }
    	 
    	 Suppliers_Model existingSupplier = existingSupplierOptional.get();
         convertToEntityUpdate(supplier, existingSupplier);
         existingSupplier.setUpdate_at(new Timestamp(System.currentTimeMillis()));
         return supplierRepository.save(existingSupplier); 
	}
    
    public Suppliers_Model convertToEntityUpdate(SupplierResponseDTO supplierRequestDTO, Suppliers_Model suppliers_Model ) {
    	
        suppliers_Model.setUrl_supplier(supplierRequestDTO.getUrlLogo());
        suppliers_Model.setCode_supplier(supplierRequestDTO.getCodeSupplier());
        suppliers_Model.setNameSupplier(supplierRequestDTO.getNameSupplier());
        suppliers_Model.setCuit_supplier(supplierRequestDTO.getCuitSupplier());
        suppliers_Model.setWeb_supplier(supplierRequestDTO.getWebSupplier());
        suppliers_Model.setEmail_supplier(supplierRequestDTO.getEmailSupplier());
        suppliers_Model.setTel_supplier(supplierRequestDTO.getTelSupplier());
 
        //CONDICION 
       Optional<Conditions_Afip_Model> conditionAfip = conditionsAfipRepository.findByCondition(supplierRequestDTO.getCondicionAfipSupplier());
       if(conditionAfip.isEmpty()) {    	   
    	  throw new EntityNotFoundException("Condición AFIP no encontrada: " + supplierRequestDTO.getCondicionAfipSupplier());
       }                
       suppliers_Model.setCondition_afip(conditionAfip.get());      
      
        //RUBRO 
        Optional<Categories_Supplier_Model> categorySupplier = categoriesSupplierRespository.findByCategorySupplier(supplierRequestDTO.getCategorySupplier());
        if(categorySupplier.isEmpty()) {
        	throw new EntityNotFoundException("Categoría de proveedor no encontrada con ID: " + supplierRequestDTO.getCategorySupplier());
        }
        suppliers_Model.setCategory_supplier(categorySupplier.get());
        
        //DIRECCION 
        
        Directions_Model direction = new Directions_Model();
        direction.setStreet_supplier(supplierRequestDTO.getStreetSupplier());
        direction.setNum_supplier(supplierRequestDTO.getNumSupplier());
        direction.setCp_supplier(supplierRequestDTO.getCpSupplier());
        direction.setLocation(supplierRequestDTO.getLocationSupplier());
        
        Optional<Provinces_Model> provinceSupplier = provinceRepository.findByProvince(supplierRequestDTO.getProvinceSupplier());
        
        if (provinceSupplier == null) {
            throw new EntityNotFoundException("Provincia no encontrada: " + supplierRequestDTO.getProvinceSupplier());
        }
        direction.setProvince(provinceSupplier.get());
        
        suppliers_Model.setDirection(direction);
        
        //CONTACTO
        
        Contacts_Model contact = new Contacts_Model();
        contact.setName_contact(supplierRequestDTO.getNamecontactSupplier());
        contact.setLast_name_contact(supplierRequestDTO.getLastNamecontactSupplier());
        contact.setTel_contact(supplierRequestDTO.getTelcontactSupplier());
        contact.setEmail_contact(supplierRequestDTO.getEmailcontactSupplier());
        contact.setRol_contact(supplierRequestDTO.getRolcontactSupplier());

        suppliers_Model.setContact(contact);

        supplierRepository.save(suppliers_Model);

        return suppliers_Model;
    }
    
    public Optional<SupplierResponseDTO> findByDeleteSupplierFalse(int id) {
    	
        Optional<Suppliers_Model> optionalSupplier = supplierRepository.findById(id);

        if (optionalSupplier.isPresent()) {
            Suppliers_Model existingSupplier = optionalSupplier.get();

            if (!existingSupplier.isDeleteSupplier()) {
                existingSupplier.setDeleteSupplier(true);
                existingSupplier.setUpdate_at(new Timestamp(System.currentTimeMillis()));
                supplierRepository.save(existingSupplier);
                
                return SupplierMapper.getSupplierResponse(existingSupplier);
            }
        }

        return Optional.empty();
    }
}
