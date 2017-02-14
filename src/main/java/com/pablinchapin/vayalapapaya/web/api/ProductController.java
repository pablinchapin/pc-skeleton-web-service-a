/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.vayalapapaya.web.api;

import com.pablinchapin.vayalapapaya.model.Product;
import com.pablinchapin.vayalapapaya.service.ProductService;
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
public class ProductController {
    
    @Autowired
    ProductService productService;
    
    
    //CREATE
    @RequestMapping(
            path = "/products",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product savedProduct = productService.create(product);
        
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
    
    
    //READ
    @RequestMapping(
            path = "/products",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<Product>> getCategories(){
        Collection<Product> products = productService.findAll();
        
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    
    
    @RequestMapping(
            path = "/products/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){
        Product product = productService.findOne(id);
        if(product == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    
    
    @RequestMapping(
            path = "products/byCategory/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<Product>> getProductsByCategory(@PathVariable("id") Long id){
        Collection<Product> products = productService.findByCategoryId(id);
        if(products == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    
    //UPDATE
    @RequestMapping(
            path = "products/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product updatedProduct = productService.update(product);
        if(updatedProduct == null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }
    
    //DELETE
    @RequestMapping(
            path = "/products/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id, @RequestBody Product product){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
}