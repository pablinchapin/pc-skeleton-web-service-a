/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.vayalapapaya.repository;

import com.pablinchapin.vayalapapaya.model.Customer;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author pvargas
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
    //add any method here!
    public Customer findByEmailAndPassword(String email, String password);
    
}