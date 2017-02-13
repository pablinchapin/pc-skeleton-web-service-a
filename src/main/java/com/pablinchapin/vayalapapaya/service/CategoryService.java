/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.vayalapapaya.service;

import com.pablinchapin.vayalapapaya.model.Category;
import java.util.Collection;

/**
 *
 * @author pvargas
 */
public interface CategoryService {
    
    Collection<Category> findAll();
    
    Category findOne(Long id);
    
    Category create(Category category);
    
    Category update(Category category);
    
    void delete(Long id);
    
}
