/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.vayalapapaya.repository;

import com.pablinchapin.vayalapapaya.model.Product;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author pvargas
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    public Collection<Product> findByCategoryId(Long id);
    
}
