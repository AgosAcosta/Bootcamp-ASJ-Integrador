package com.example.demo.services;

import java.sql.Timestamp;
import java.util.*;

import com.example.demo.models.*;
import com.example.demo.repositories.CategoriesProductRepository;
import com.example.demo.repositories.SupplierRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductResponseDTO;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    CategoriesProductRepository categoriesProductRepository;

    /**
     * getAllProducts --- Busca y filtra los productos que no están eliminados
     */
    public List<ProductResponseDTO> getAllProducts() {
        List<ProductModel> product_Model = productRepository.findBySupplierDeleteSupplierIsFalse();
        List<ProductResponseDTO> responseDTOs = new ArrayList<>();
        for (ProductModel product : product_Model) {
            if (!product.isDeleteProduct()) {
                ProductMapper.getProductResponse(product).ifPresent(responseDTOs::add);
            }
        }
        return responseDTOs;
    }

    /**
     * getAllProductsDelete --- Busca y filtra los productos que están eliminados
     */
    public List<ProductResponseDTO> getAllProductsDelete() {
        List<ProductModel> product_Model = productRepository.findAll();
        List<ProductResponseDTO> responseDTOs = new ArrayList<ProductResponseDTO>();
        for (ProductModel product : product_Model) {
            if(product.isDeleteProduct()){
                ProductMapper.getProductResponse(product).ifPresent(responseDTOs::add);
            }
        }
        return responseDTOs;
    }

    /**
     * getroductById --- Busca por ID el producto.
     */
    public Optional<ProductResponseDTO> getProductById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID del producto debe ser mayor que 0");
        }
        Optional<ProductModel> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return ProductMapper.getProductResponse(optionalProduct.get());
        } else {
            throw new NoSuchElementException("No se encontró el producto con ID: " + id);
        }

    }

    /**
     * postProduct --- Realiza la creación de un nuevo producto.
     */
    public ProductModel postProduct(ProductResponseDTO product) {

        ProductModel productModel = convertToEntity(product);
        productModel.setDeleteProduct(false);
        productModel.setCreated_at(new Timestamp(System.currentTimeMillis()));
        productModel.setUpdate_at(new Timestamp(System.currentTimeMillis()));
        return productRepository.save(productModel);
    }

    /**
     * convertToEntity --- Convierte un DTO de producto en una entidad/modelo.
     */
    public ProductModel convertToEntity(ProductResponseDTO productResponseDTO) {

        ProductModel product = new ProductModel();

        product.setUrlProduct(productResponseDTO.getUrlLogo());
        product.setCodeProduct(productResponseDTO.getCodeProduct());
        product.setNameProduct(productResponseDTO.getNameProduct());
        product.setDescriptionProduct(productResponseDTO.getDescriptionProduct());
        product.setPriceProduct(productResponseDTO.getPriceProduct());

        Optional<CategoriesProductModel> categoryProduct = categoriesProductRepository.findByCategoryProduct(productResponseDTO.getCategoryProduct());
        if (categoryProduct.isEmpty()) {
            throw new EntityNotFoundException("Categoria productos no encontrada: " + productResponseDTO.getCategoryProduct());
        }
        product.setCategoryProduct(categoryProduct.get());
        Optional<SuppliersModel> supplier = supplierRepository.findByNameSupplier(productResponseDTO.getSupplierName());
        if (supplier.isEmpty()) {
            throw new EntityNotFoundException("Proveedor no encontrada: " + productResponseDTO.getSupplierName());
        }
        product.setSupplier(supplier.get());
        productRepository.save(product);
        return product;
    }

    /**
     * updateProduct --- Realiza la actualizacíón de un producto enviado por ID.
     */
    public ProductModel updateProduct(int id, ProductResponseDTO product) {
        Optional<ProductModel> existProduct = productRepository.findById(id);
        if (existProduct.isEmpty()) {
            throw new EntityNotFoundException("Producto no encontrado con ID: " + id);
        }
        ProductModel productModel = existProduct.get();
        convertToEntityUpdate(product, productModel);
        productModel.setUpdate_at(new Timestamp(System.currentTimeMillis()));
        return productRepository.save(productModel);
    }

    /**
     * convertToEntityUpdate --- Convierte un DTO de producto en una entidad/modelo.
     */
    public ProductModel convertToEntityUpdate(ProductResponseDTO productResponseDTO, ProductModel product) {

        product.setUrlProduct(productResponseDTO.getUrlLogo());
        product.setCodeProduct(productResponseDTO.getCodeProduct());
        product.setNameProduct(productResponseDTO.getNameProduct());
        product.setDescriptionProduct(productResponseDTO.getDescriptionProduct());
        product.setPriceProduct(productResponseDTO.getPriceProduct());

        Optional<CategoriesProductModel> categoryProduct = categoriesProductRepository.findByCategoryProduct(productResponseDTO.getCategoryProduct());
        if (categoryProduct.isEmpty()) {
            throw new EntityNotFoundException("Categoria productos no encontrada: " + productResponseDTO.getCategoryProduct());
        }
        product.setCategoryProduct(categoryProduct.get());
        Optional<SuppliersModel> supplier = supplierRepository.findByNameSupplier(productResponseDTO.getSupplierName());
        if (supplier.isEmpty()) {
            throw new EntityNotFoundException("Proveedor no encontrada: " + productResponseDTO.getSupplierName());
        }
        product.setSupplier(supplier.get());
        productRepository.save(product);
        return product;
    }

    /**
     * findByDeleteProductFalse --- Método para eliminar de manera lógica un producto enviado por ID.
     */
    public Optional<ProductResponseDTO> findByDeleteProductFalse(int id){
        Optional<ProductModel> optionalProductModel = productRepository.findById(id);
        if(optionalProductModel.isPresent()){
            ProductModel existProduct = optionalProductModel.get();
            if(!existProduct.isDeleteProduct()){
                existProduct.setDeleteProduct(true);
                existProduct.setUpdate_at(new Timestamp(System.currentTimeMillis()));
                productRepository.save(existProduct);

                return ProductMapper.getProductResponse(existProduct);
            }
        }
        return Optional.empty();
    }

    /**
     * findByDeleteProductTrue --- Método para activar un un producto enviado por ID.
     */
    public Optional<ProductResponseDTO> findByDeleteProductTrue(int id) {
        Optional<ProductModel> optionalProductModel = productRepository.findById(id);
        if (optionalProductModel.isPresent()) {
            ProductModel existProduct = optionalProductModel.get();
            if (existProduct.isDeleteProduct()) {
                existProduct.setDeleteProduct(false);
                existProduct.setUpdate_at(new Timestamp(System.currentTimeMillis()));
                productRepository.save(existProduct);
                return ProductMapper.getProductResponse(existProduct);
            }
        }
        return Optional.empty();
    }

    /**
     * getProductBySupplierId --- Método para buscar los productos del proveedor enviado por ID.
     */
    public List<ProductResponseDTO> getProductBySupplierId(int supplierId) {
        Optional<SuppliersModel> suppliersModel = supplierRepository.findById(supplierId);

        if (suppliersModel.isPresent()) {
            SuppliersModel supplier = suppliersModel.get();
            List<ProductModel> productModels = productRepository.findBySupplierIdSupplier(supplier.getIdSupplier());
            List<ProductResponseDTO> responseDTO = new ArrayList<>();
            for (ProductModel product : productModels) {
                responseDTO.add(ProductMapper.getProductResponse(product).get());
            }
            return responseDTO;
        } else {
            throw new EntityNotFoundException("PROVEEDOR no encontrado con ID: " + supplierId);
        }
    }

    /**
     * getProductBySupplierName --- Método para buscar los productos del proveedor enviado por parametro.
     */
    public List<ProductResponseDTO> getProductBySupplierName(String supplierName) {
        Optional<SuppliersModel> suppliersModel = supplierRepository.findByNameSupplier(supplierName);
        if (suppliersModel.isPresent()) {
            SuppliersModel supplier = suppliersModel.get();
            if (!supplier.isDeleteSupplier()) {
                List<ProductModel> productModels = productRepository.findBySupplierIdSupplier(supplier.getIdSupplier());
                List<ProductResponseDTO> responseDTO = new ArrayList<>();
                for (ProductModel product : productModels) {
                     if (!product.isDeleteProduct()) {
                        responseDTO.add(ProductMapper.getProductResponse(product).get());
                    }
                }
                return responseDTO;
            } else {
                return Collections.emptyList();
            }
        } else {
            throw new EntityNotFoundException("PROVEEDOR no encontrado con nombre: " + supplierName + "PRODUCTOS NO BORRADOS");
        }
    }

    /**
     * validateProductCode --- Validación para verificar si el código de producto ya existe.
     */
    public boolean validateProductCode(String code) {
        boolean existsByCode = productRepository.existsByCodeProductIgnoreCase(code);
        return existsByCode;
    }
    public long countActiveProducts() {
        return productRepository.countByDeleteProductFalse();
    }

    public long countDeletedProducts() {
        return productRepository.countByDeleteProductTrue();
    }
}
