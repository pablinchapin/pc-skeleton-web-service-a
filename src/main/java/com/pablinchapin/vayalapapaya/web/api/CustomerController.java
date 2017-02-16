/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.vayalapapaya.web.api;

import com.pablinchapin.vayalapapaya.model.Customer;
import com.pablinchapin.vayalapapaya.service.CustomerService;
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
public class CustomerController {
    
    @Autowired
    CustomerService customerService;
    
    
    //CREATE
    @RequestMapping(
            path = "/customers",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer savedCustomer = customerService.create(customer);
        
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }
    
    
    //READ
    @RequestMapping(
            path = "/customers",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<Customer>> getCustomers(){
        Collection<Customer> customers = customerService.findAll();
        
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    
    
    
    @RequestMapping(
            path = "/customers/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id){
        Customer customer = customerService.findOne(id);
        if(customer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    

    @RequestMapping(
            path = "customers/findByEmailAndPassword/{email}/{password}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Customer> getCustomerByEmailAndPassword(@PathVariable("email") String email, @PathVariable("password") String password){
        Customer customer = customerService.findByEmailAndPassword(email, password);
        if(customer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    
    
    //UPDATE
    @RequestMapping(
            path = "/customers/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        Customer updatedCustomer = customerService.update(customer);
        if(updatedCustomer == null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }
    
    
    //DELETE
    @RequestMapping(
            path = "/customers/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id, @RequestBody Customer customer){
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
}