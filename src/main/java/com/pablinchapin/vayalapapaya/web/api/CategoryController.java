/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.vayalapapaya.web.api;

import com.pablinchapin.vayalapapaya.model.Category;
import com.pablinchapin.vayalapapaya.service.CategoryService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pvargas
 */
@RestController
@RequestMapping("/api")
public class CategoryController {
    
    @Autowired 
    CategoryService categoryService;
    
    
    //CREATE
    @RequestMapping(
            path = "/categories",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        Category savedCategory = categoryService.create(category);
        
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }
    
    
    //READ
    @RequestMapping(
            path = "/categories",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<Category>> getCategories(){
        Collection<Category> categories = categoryService.findAll();
        
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    
    
    @RequestMapping(
            path = "/categories/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Category> getCategory(@PathVariable("id") Long id){
        Category category = categoryService.findOne(id);
        if(category == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    
    
    //UPDATE
    @RequestMapping(
            path = "categories/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Category> updateCategory(@RequestBody Category category){
        Category updatedCategory = categoryService.update(category);
        if(updatedCategory == null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }
    
    //DELETE
    @RequestMapping(
            path = "/categories/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") Long id, @RequestBody Category category){
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
    
    
    
}
