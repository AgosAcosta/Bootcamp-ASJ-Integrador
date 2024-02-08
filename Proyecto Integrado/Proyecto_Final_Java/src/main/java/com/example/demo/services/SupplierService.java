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
    CategoriesSupplierRespository categoriesSupplierRespository;

    @Autowired
    ProvinceRepository provinceRepository;


    /**
     * getAllSupplier --- Busca y filtra los proveedores que no están eliminados
     */
    public List<SupplierResponseDTO> getAllSupplier() {
        List<SuppliersModel> suppliersModelList = supplierRepository.findAll();
        List<SupplierResponseDTO> responseDTO = new ArrayList<>();

        for (SuppliersModel supplier : suppliersModelList) {
            if (!supplier.isDeleteSupplier()) {
                SupplierMapper.getSupplierResponse(supplier).ifPresent(responseDTO::add);
            }
        }
        return responseDTO;
    }

    /**
     * getAllSupplierDelete --- Busca y filtra los proveedores que están eliminados
     */
    public List<SupplierResponseDTO> getAllSupplierDelete() {
        List<SuppliersModel> suppliersModelList = supplierRepository.findAll();
        List<SupplierResponseDTO> responseDTO = new ArrayList<>();

        for (SuppliersModel supplier : suppliersModelList) {
            if (supplier.isDeleteSupplier()) {
                SupplierMapper.getSupplierResponse(supplier).ifPresent(responseDTO::add);
            }
        }
        return responseDTO;
    }

    /**
     * getSupplierById --- Busca por ID el proveedor.
     */
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

    /**
     * postSupplier --- Realiza la creación de un nuevo proveedor.
     */
    public SuppliersModel postSupplier(SupplierResponseDTO supplier) {
        SuppliersModel suppliers_Model = convertToEntity(supplier);
        suppliers_Model.setDeleteSupplier(false);
        suppliers_Model.setCreated_at(new Timestamp(System.currentTimeMillis()));
        suppliers_Model.setUpdate_at(new Timestamp(System.currentTimeMillis()));
        return supplierRepository.save(suppliers_Model);
    }

    /**
     * convertToEntity --- Convierte un DTO de proveedor en una entidad/modelo.
     */
    public SuppliersModel convertToEntity(SupplierResponseDTO supplierRequestDTO) {

        SuppliersModel supplier = new SuppliersModel();

        supplier.setUrlSupplier(supplierRequestDTO.getUrlLogo());
        supplier.setCodeSupplier(supplierRequestDTO.getCodeSupplier());
        supplier.setNameSupplier(supplierRequestDTO.getNameSupplier());
        supplier.setCuitSupplier(supplierRequestDTO.getCuitSupplier());
        supplier.setWebSupplier(supplierRequestDTO.getWebSupplier());
        supplier.setEmailSupplier(supplierRequestDTO.getEmailSupplier());
        supplier.setTelSupplier(supplierRequestDTO.getTelSupplier());

        Optional<ConditionsAfipModel> conditionAfip = conditionsAfipRepository.findByCondition(supplierRequestDTO.getCondicionAfipSupplier());
        if (conditionAfip.isEmpty()) {
            throw new EntityNotFoundException("Condición AFIP no encontrada: " + supplierRequestDTO.getCondicionAfipSupplier());
        }
        supplier.setConditionAfip(conditionAfip.get());

        Optional<CategoriesSupplierModel> categorySupplier = categoriesSupplierRespository.findByCategorySupplier(supplierRequestDTO.getCategorySupplier());
        if (categorySupplier.isEmpty()) {
            throw new EntityNotFoundException("Categoría de proveedor no encontrada con ID: " + supplierRequestDTO.getCategorySupplier());
        }
        supplier.setCategorySupplier(categorySupplier.get());

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

    /**
     * updateSupplier --- Realiza la actualizacíón de un proveedor enviado por ID.
     */
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

    /**
     * convertToEntityUpdate --- Convierte un DTO de proveedor en una entidad/modelo.
     */
    public SuppliersModel convertToEntityUpdate(SupplierResponseDTO supplierRequestDTO, SuppliersModel suppliers_Model) {

        suppliers_Model.setUrlSupplier(supplierRequestDTO.getUrlLogo());
        suppliers_Model.setCodeSupplier(supplierRequestDTO.getCodeSupplier());
        suppliers_Model.setNameSupplier(supplierRequestDTO.getNameSupplier());
        suppliers_Model.setCuitSupplier(supplierRequestDTO.getCuitSupplier());
        suppliers_Model.setWebSupplier(supplierRequestDTO.getWebSupplier());
        suppliers_Model.setEmailSupplier(supplierRequestDTO.getEmailSupplier());
        suppliers_Model.setTelSupplier(supplierRequestDTO.getTelSupplier());

        Optional<ConditionsAfipModel> conditionAfip = conditionsAfipRepository.findByCondition(supplierRequestDTO.getCondicionAfipSupplier());
        if (conditionAfip.isEmpty()) {
            throw new EntityNotFoundException("Condición AFIP no encontrada: " + supplierRequestDTO.getCondicionAfipSupplier());
        }
        suppliers_Model.setConditionAfip(conditionAfip.get());

        Optional<CategoriesSupplierModel> categorySupplier = categoriesSupplierRespository.findByCategorySupplier(supplierRequestDTO.getCategorySupplier());
        if (categorySupplier.isEmpty()) {
            throw new EntityNotFoundException("Categoría de proveedor no encontrada con ID: " + supplierRequestDTO.getCategorySupplier());
        }
        suppliers_Model.setCategorySupplier(categorySupplier.get());

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

    /**
     * findByDeleteSupplierFalse --- Método para eliminar de manera lógica un proveedor enviado por ID.
     */
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

    /**
     * findByDeleteSupplierTrue --- Método para activar un un proveedor enviado por ID.
     */
    public Optional<SupplierResponseDTO> findByDeleteSupplierTrue(int id) {
        Optional<SuppliersModel> optionalSupplier = supplierRepository.findById(id);
        if (optionalSupplier.isPresent()) {
            SuppliersModel existingSupplier = optionalSupplier.get();
            if (existingSupplier.isDeleteSupplier()) {
                existingSupplier.setDeleteSupplier(false);
                existingSupplier.setUpdate_at(new Timestamp(System.currentTimeMillis()));
                supplierRepository.save(existingSupplier);
                return SupplierMapper.getSupplierResponse(existingSupplier);
            }
        }
        return Optional.empty();
    }

    /**
     * validateSupplierCuit --- Validación para verificar si el cuit del proveedor ya existe.
     */
    public boolean validateSupplierCuit(String cuit) {
        boolean existsByCuit = supplierRepository.existsByCuitSupplier(cuit);
        return existsByCuit;
    }

    /**
     * validateSupplierCode --- Validación para verificar si el código del proveedor ya existe.
     */
    public boolean validateSupplierCode(String code) {
        boolean existsByCode = supplierRepository.existsByCodeSupplierIgnoreCase(code);
        return existsByCode;
    }
    
    public long countActiveSuppliers() {
        return supplierRepository.countByDeleteSupplierFalse();
    }

    public long countDeletedSuppliers() {
        return supplierRepository.countByDeleteSupplierTrue();
    }
}
