package com.example.demo.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.demo.models.Categories_Product_Model;
import com.example.demo.models.Suppliers_Model;
import com.example.demo.repositories.CategoriesProductRepository;
import com.example.demo.repositories.SupplierRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductResponseDTO;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.models.Product_Model;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    CategoriesProductRepository categoriesProductRepository;

    // OBTENER TODOS LOS PRODUCTOS
    public List<ProductResponseDTO> getAllProducts() {
        List<Product_Model> product_Model = productRepository.findAll();
        List<ProductResponseDTO> responseDTOs = new ArrayList<ProductResponseDTO>();
        for (Product_Model product : product_Model) {
            responseDTOs.add(ProductMapper.getProductResponse(product).get());
        }
        return responseDTOs;
    }

    // OBTENER PRODUCTOS POR ID

    public Optional<ProductResponseDTO> getroductById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID del producto debe ser mayor que 0");
        }
        Optional<Product_Model> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return ProductMapper.getProductResponse(optionalProduct.get());
        } else {
            throw new NoSuchElementException("No se encontró el producto con ID: " + id);
        }

    }

    // POST PRODUCTOS
    public Product_Model postProduct(ProductResponseDTO product) {

        Product_Model productModel = convertToEntity(product);
        productModel.setDeleteProduct(false);
        productModel.setCreated_at(new Timestamp(System.currentTimeMillis()));
        productModel.setUpdate_at(new Timestamp(System.currentTimeMillis()));
        return productRepository.save(productModel);

    }

    public Product_Model convertToEntity(ProductResponseDTO productResponseDTO) {

        Product_Model product = new Product_Model();

        product.setUrl_product(productResponseDTO.getUrlLogo());
        product.setCode_product(productResponseDTO.getCodeProduct());
        product.setName_product(productResponseDTO.getNameProduct());
        product.setDescription_product(productResponseDTO.getDescriptionProduct());
        product.setPrice_product(productResponseDTO.getPriceProduct());

        Optional<Categories_Product_Model> categoryProduct = categoriesProductRepository.findByCategoryProduct(productResponseDTO.getCategoryProduct());
        if (categoryProduct.isEmpty()) {
            throw new EntityNotFoundException("Categoria productos no encontrada: " + productResponseDTO.getCategoryProduct());
        }
        product.setCategory_product(categoryProduct.get());
        Optional<Suppliers_Model> supplier = supplierRepository.findByNameSupplier(productResponseDTO.getSupplierName());
        if (supplier.isEmpty()) {
            throw new EntityNotFoundException("Proveedor no encontrada: " + productResponseDTO.getSupplierName());
        }
        product.setSupplier(supplier.get());
        productRepository.save(product);
        return product;
    }

    public Product_Model updateProduct(int id, ProductResponseDTO product) {
        Optional<Product_Model> existProduct = productRepository.findById(id);
        if (existProduct.isEmpty()) {
            throw new EntityNotFoundException("Producto no encontrado con ID: " + id);
        }
        Product_Model productModel = existProduct.get();
        convertToEntityUpdate(product, productModel);
        productModel.setUpdate_at(new Timestamp(System.currentTimeMillis()));
        return productRepository.save(productModel);

    }

    public Product_Model convertToEntityUpdate(ProductResponseDTO productResponseDTO, Product_Model product) {

        product.setUrl_product(productResponseDTO.getUrlLogo());
        product.setCode_product(productResponseDTO.getCodeProduct());
        product.setName_product(productResponseDTO.getNameProduct());
        product.setDescription_product(productResponseDTO.getDescriptionProduct());
        product.setPrice_product(productResponseDTO.getPriceProduct());

        Optional<Categories_Product_Model> categoryProduct = categoriesProductRepository.findByCategoryProduct(productResponseDTO.getCategoryProduct());
        if (categoryProduct.isEmpty()) {
            throw new EntityNotFoundException("Categoria productos no encontrada: " + productResponseDTO.getCategoryProduct());
        }
        product.setCategory_product(categoryProduct.get());
        Optional<Suppliers_Model> supplier = supplierRepository.findByNameSupplier(productResponseDTO.getSupplierName());
        if (supplier.isEmpty()) {
            throw new EntityNotFoundException("Proveedor no encontrada: " + productResponseDTO.getSupplierName());
        }
        product.setSupplier(supplier.get());
        productRepository.save(product);
        return product;
    }

    public Optional<ProductResponseDTO> finByDeleteProductFalse(int id){
        Optional<Product_Model> optionalProductModel = productRepository.findById(id);
        if(optionalProductModel.isPresent()){
            Product_Model existProduct = optionalProductModel.get();
            if(!existProduct.isDeleteProduct()){
                existProduct.setDeleteProduct(true);
                existProduct.setUpdate_at(new Timestamp(System.currentTimeMillis()));
                productRepository.save(existProduct);

                return ProductMapper.getProductResponse(existProduct);
            }
        }
        return Optional.empty();
    }

}
