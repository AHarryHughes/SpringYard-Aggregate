package com.example.service;

import com.example.model.Customer;
import com.example.service.CustomerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahhughes8 on 8/16/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    CustomerService customerservice;

    @Transactional
    @Test
    public void testAddGet() {
        Customer customer1 = new Customer();
        customer1.setFirstName("one");
        customer1.setLastName("uno");
        customer1.setEmail("one@gmail.com");
        customer1.setPhone("1");
        Customer customer2 = new Customer();
        customer2.setFirstName("two");
        customer2.setLastName("dos");
        customer2.setEmail("two@gmail.com");
        customer2.setPhone("2");
        Customer customer3 = new Customer();
        customer3.setFirstName("three");
        customer3.setLastName("trace");
        customer3.setEmail("three@gmail.com");
        customer3.setPhone("3");

        customerservice.add(customer1);
        customerservice.add(customer2);
        customerservice.add(customer3);

        List<Customer> customers = customerservice.get();

        Boolean isCustomers = customers.isEmpty();
        Assert.assertFalse(isCustomers);
    }

}
