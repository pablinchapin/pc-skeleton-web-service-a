/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.vayalapapaya.service;

import com.pablinchapin.vayalapapaya.model.Product;
import com.pablinchapin.vayalapapaya.repository.ProductRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pvargas
 */
@Service
@Transactional(
        propagation = Propagation.SUPPORTS,
        readOnly = true
)
public class ProductServiceBean implements ProductService {

    @Autowired ProductRepository productRepository;
    
    
    @Override
    public Collection<Product> findAll() {
        Collection<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Product findOne(Long id) {
        Product product = productRepository.findOne(id);
        return product;
    }

    @Override
    public Collection<Product> findByCategoryId(Long id) {
        Collection<Product> products = productRepository.findByCategoryId(id);
        return products;
    }

    @Override
    public Product create(Product product) {
        if(product.getId() != null){
            return null;
        }
        
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false
    )
    public Product update(Product product) {
        
        Product productToUpdate = productRepository.findOne(product.getId());
        
        if(productToUpdate == null){
            return null;
        }
        
        productToUpdate.setName(product.getName());
        productToUpdate.setDescription(product.getDescription());
        
        Product updatedProduct = productRepository.save(productToUpdate);
        return updatedProduct;
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false
    )
    public void delete(Long id) {
        productRepository.delete(id);
    }
    
}