package com.example.repository;

import com.example.model.Customer;

import java.util.List;

/**
 * Created by ahhughes8 on 8/16/17.
 */
public interface CustomerRepository {

    void add(Customer customer);
    Customer getById(int id);
    List<Customer> get();
    void update(Customer customer);
    void delete(int id);

}
