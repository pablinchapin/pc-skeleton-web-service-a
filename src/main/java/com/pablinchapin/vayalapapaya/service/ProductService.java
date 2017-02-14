/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.vayalapapaya.service;

import com.pablinchapin.vayalapapaya.model.Product;
import java.util.Collection;

/**
 *
 * @author pvargas
 */
public interface ProductService {
    
    Collection<Product> findAll();
    
    Product findOne(Long id);
    
    Collection<Product> findByCategoryId(Long id);
    
    Product create(Product product);
    
    Product update(Product product);
    
    void delete(Long id);
    
}