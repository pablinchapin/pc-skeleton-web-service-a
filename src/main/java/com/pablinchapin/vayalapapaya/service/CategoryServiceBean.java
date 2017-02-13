/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.vayalapapaya.service;

import com.pablinchapin.vayalapapaya.model.Category;
import com.pablinchapin.vayalapapaya.repository.CategoryRepository;
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
public class CategoryServiceBean implements CategoryService {

    @Autowired CategoryRepository categoryRepository;
    
    @Override
    public Collection<Category> findAll() {
        Collection<Category> categories = categoryRepository.findAll();
        return categories;
    }

    @Override
    public Category findOne(Long id) {
        Category category = categoryRepository.findOne(id);
        return category;
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false
    )
    public Category create(Category category) {
        if(category.getId() != null){
            return null;
        }
        
        Category savedCategory = categoryRepository.save(category);
        
        return savedCategory;
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false
    )
    public Category update(Category category) {
        
        Category categoryToUpdate = categoryRepository.findOne(category.getId());
        
        if(categoryToUpdate == null){
            return null;
        }
        
        categoryToUpdate.setName(category.getName());
        categoryToUpdate.setDescription(category.getDescription());
        
        Category updatedCategory = categoryRepository.save(categoryToUpdate);
        
        return updatedCategory;
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false
    )public void delete(Long id) {
        categoryRepository.delete(id);
    }
    
}