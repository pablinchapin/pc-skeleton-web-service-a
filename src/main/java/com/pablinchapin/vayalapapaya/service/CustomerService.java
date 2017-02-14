/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.vayalapapaya.service;

import com.pablinchapin.vayalapapaya.model.Customer;
import java.util.Collection;

/**
 *
 * @author pvargas
 */
public interface CustomerService {
    
    Collection<Customer> findAll();
    
    Customer findOne(Long id);
    
    Customer findByEmailAndPassword(String email, String password);
    
    Customer create(Customer customer);
    
    Customer update(Customer customer);
    
    void delete(Long id);
    
}