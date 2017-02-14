/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.vayalapapaya.service;

import com.pablinchapin.vayalapapaya.model.Customer;
import com.pablinchapin.vayalapapaya.repository.CustomerRepository;
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
public class CustomerServiceBean implements CustomerService {
    
    @Autowired CustomerRepository customerRepository;

    @Override
    public Collection<Customer> findAll() {
        Collection<Customer> customers = customerRepository.findAll();
        return customers;
    }

    @Override
    public Customer findOne(Long id) {
        Customer customer = customerRepository.findOne(id);
        return customer;
    }
    
    @Override
    public Customer findByEmailAndPassword(String email, String password){
        Customer customer = customerRepository.findByEmailAndPassword(email, password);
        return customer;
    }
    

    @Override
    public Customer create(Customer customer) {
        if(customer.getId() != null){
            return null;
        }
        
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false
    )
    public Customer update(Customer customer) {
        
        Customer customerToUpdate = customerRepository.findOne(customer.getId());
        
        if(customerToUpdate == null){
            return null;
        }
        
        customerToUpdate.setFirstName(customer.getFirstName());
        customerToUpdate.setLastName(customer.getLastName());
        
        Customer updatedCustomer = customerRepository.save(customerToUpdate);
        return updatedCustomer;
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false
    )
    public void delete(Long id) {
        customerRepository.delete(id);
    }
    
    
}