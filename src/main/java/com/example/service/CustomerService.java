package com.example.service;

import com.example.model.Customer;

import java.util.List;

/**
 * Created by ahhughes8 on 8/16/17.
 */
public interface CustomerService {

    void add(Customer customer);
    void add(List<Customer> customer);
    Customer getById(int id);
    List<Customer> get();
    void update(Customer customer);
    void delete(int id);

}
