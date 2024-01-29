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
import com.example.demo.models.CategoriesSupplierModel;
import com.example.demo.models.ConditionsAfipModel;
import com.example.demo.models.ContactsModel;
import com.example.demo.models.DirectionsModel;
import com.example.demo.models.ProvincesModel;
import com.example.demo.models.SuppliersModel;
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

    public List<SupplierResponseDTO> getAllSupplier() {
        List<SuppliersModel> suppliers_Model = supplierRepository.findAll();
        List<SupplierResponseDTO> responseDTO = new ArrayList<SupplierResponseDTO>();

        for (SuppliersModel supplier : suppliers_Model) {
            responseDTO.add(SupplierMapper.getSupplierResponse(supplier).get());
        }
        return responseDTO;
    }

    public Optional<SupplierResponseDTO> getSupplierById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID del proveedor debe ser mayor que 0");
        }
        Optional<SuppliersModel> optionalSupplier = supplierRepository.findById(id);

        if (optionalSupplier.isPresent()) {
            return SupplierMapper.getSupplierResponse(optionalSupplier.get());

        } else {
            throw new NoSuchElementException("No se encontró el proveedor con ID: " + id);
        }
    }

    public SuppliersModel postSupplier(SupplierResponseDTO supplier) {
        SuppliersModel suppliers_Model = convertToEntity(supplier);
        suppliers_Model.setDeleteSupplier(false);
        suppliers_Model.setCreated_at(new Timestamp(System.currentTimeMillis()));
        suppliers_Model.setUpdate_at(new Timestamp(System.currentTimeMillis()));
        return supplierRepository.save(suppliers_Model);
    }

    public SuppliersModel convertToEntity(SupplierResponseDTO supplierRequestDTO) {

        SuppliersModel supplier = new SuppliersModel();

        supplier.setUrlSupplier(supplierRequestDTO.getUrlLogo());
        supplier.setCodeSupplier(supplierRequestDTO.getCodeSupplier());
        supplier.setNameSupplier(supplierRequestDTO.getNameSupplier());
        supplier.setCuitSupplier(supplierRequestDTO.getCuitSupplier());
        supplier.setWebSupplier(supplierRequestDTO.getWebSupplier());
        supplier.setEmailSupplier(supplierRequestDTO.getEmailSupplier());
        supplier.setTelSupplier(supplierRequestDTO.getTelSupplier());

        //CONDICION 
        Optional<ConditionsAfipModel> conditionAfip = conditionsAfipRepository.findByCondition(supplierRequestDTO.getCondicionAfipSupplier());
        if (conditionAfip.isEmpty()) {
            throw new EntityNotFoundException("Condición AFIP no encontrada: " + supplierRequestDTO.getCondicionAfipSupplier());
        }
        supplier.setConditionAfip(conditionAfip.get());

        //RUBRO 
        Optional<CategoriesSupplierModel> categorySupplier = categoriesSupplierRespository.findByCategorySupplier(supplierRequestDTO.getCategorySupplier());
        if (categorySupplier.isEmpty()) {
            throw new EntityNotFoundException("Categoría de proveedor no encontrada con ID: " + supplierRequestDTO.getCategorySupplier());
        }
        supplier.setCategorySupplier(categorySupplier.get());

        //DIRECCION 

        DirectionsModel direction = new DirectionsModel();
        direction.setStreetSupplier(supplierRequestDTO.getStreetSupplier());
        direction.setNumSupplier(supplierRequestDTO.getNumSupplier());
        direction.setCpSupplier(supplierRequestDTO.getCpSupplier());
        direction.setLocation(supplierRequestDTO.getLocationSupplier());

        Optional<ProvincesModel> provinceSupplier = provinceRepository.findByProvince(supplierRequestDTO.getProvinceSupplier());

        if (provinceSupplier == null) {
            throw new EntityNotFoundException("Provincia no encontrada: " + supplierRequestDTO.getProvinceSupplier());
        }
        direction.setProvince(provinceSupplier.get());

        supplier.setDirection(direction);

        //CONTACTO

        ContactsModel contact = new ContactsModel();
        contact.setNameContact(supplierRequestDTO.getNamecontactSupplier());
        contact.setLastNameContact(supplierRequestDTO.getLastNamecontactSupplier());
        contact.setTelContact(supplierRequestDTO.getTelcontactSupplier());
        contact.setEmailContact(supplierRequestDTO.getEmailcontactSupplier());
        contact.setRolContact(supplierRequestDTO.getRolcontactSupplier());

        supplier.setContact(contact);

        supplierRepository.save(supplier);

        return supplier;
    }

    public SuppliersModel updateSupplier(int id, SupplierResponseDTO supplier) {

        Optional<SuppliersModel> existingSupplierOptional = supplierRepository.findById(id);
        if (existingSupplierOptional.isEmpty()) {
            throw new EntityNotFoundException("Proveedor no encontrado con ID: " + id);
        }

        SuppliersModel existingSupplier = existingSupplierOptional.get();
        convertToEntityUpdate(supplier, existingSupplier);
        existingSupplier.setUpdate_at(new Timestamp(System.currentTimeMillis()));
        return supplierRepository.save(existingSupplier);
    }

    public SuppliersModel convertToEntityUpdate(SupplierResponseDTO supplierRequestDTO, SuppliersModel suppliers_Model) {

        suppliers_Model.setUrlSupplier(supplierRequestDTO.getUrlLogo());
        suppliers_Model.setCodeSupplier(supplierRequestDTO.getCodeSupplier());
        suppliers_Model.setNameSupplier(supplierRequestDTO.getNameSupplier());
        suppliers_Model.setCuitSupplier(supplierRequestDTO.getCuitSupplier());
        suppliers_Model.setWebSupplier(supplierRequestDTO.getWebSupplier());
        suppliers_Model.setEmailSupplier(supplierRequestDTO.getEmailSupplier());
        suppliers_Model.setTelSupplier(supplierRequestDTO.getTelSupplier());

        //CONDICION 
        Optional<ConditionsAfipModel> conditionAfip = conditionsAfipRepository.findByCondition(supplierRequestDTO.getCondicionAfipSupplier());
        if (conditionAfip.isEmpty()) {
            throw new EntityNotFoundException("Condición AFIP no encontrada: " + supplierRequestDTO.getCondicionAfipSupplier());
        }
        suppliers_Model.setConditionAfip(conditionAfip.get());

        //RUBRO 
        Optional<CategoriesSupplierModel> categorySupplier = categoriesSupplierRespository.findByCategorySupplier(supplierRequestDTO.getCategorySupplier());
        if (categorySupplier.isEmpty()) {
            throw new EntityNotFoundException("Categoría de proveedor no encontrada con ID: " + supplierRequestDTO.getCategorySupplier());
        }
        suppliers_Model.setCategorySupplier(categorySupplier.get());

        //DIRECCION 

        DirectionsModel direction = new DirectionsModel();
        direction.setStreetSupplier(supplierRequestDTO.getStreetSupplier());
        direction.setNumSupplier(supplierRequestDTO.getNumSupplier());
        direction.setCpSupplier(supplierRequestDTO.getCpSupplier());
        direction.setLocation(supplierRequestDTO.getLocationSupplier());

        Optional<ProvincesModel> provinceSupplier = provinceRepository.findByProvince(supplierRequestDTO.getProvinceSupplier());

        if (provinceSupplier == null) {
            throw new EntityNotFoundException("Provincia no encontrada: " + supplierRequestDTO.getProvinceSupplier());
        }
        direction.setProvince(provinceSupplier.get());

        suppliers_Model.setDirection(direction);

        //CONTACTO

        ContactsModel contact = new ContactsModel();
        contact.setNameContact(supplierRequestDTO.getNamecontactSupplier());
        contact.setLastNameContact(supplierRequestDTO.getLastNamecontactSupplier());
        contact.setTelContact(supplierRequestDTO.getTelcontactSupplier());
        contact.setEmailContact(supplierRequestDTO.getEmailcontactSupplier());
        contact.setRolContact(supplierRequestDTO.getRolcontactSupplier());

        suppliers_Model.setContact(contact);

        supplierRepository.save(suppliers_Model);

        return suppliers_Model;
    }

    public Optional<SupplierResponseDTO> findByDeleteSupplierFalse(int id) {

        Optional<SuppliersModel> optionalSupplier = supplierRepository.findById(id);

        if (optionalSupplier.isPresent()) {
            SuppliersModel existingSupplier = optionalSupplier.get();

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
