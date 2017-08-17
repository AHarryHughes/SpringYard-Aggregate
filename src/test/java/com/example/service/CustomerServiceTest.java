package com.example.service;

import com.example.model.Customer;
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
        customer1.setFirstName("two");
        customer1.setLastName("dos");
        customer1.setEmail("two@gmail.com");
        customer1.setPhone("2");
        Customer customer3 = new Customer();
        customer1.setFirstName("three");
        customer1.setLastName("trace");
        customer1.setEmail("three@gmail.com");
        customer1.setPhone("3");

        List<Customer> customers = new ArrayList<>();

        customers.add(customer1);
        customers.add(customer2);

        customerservice.add(customers);

        customerservice.add(customer3);

        customerservice.get();

        customerservice.getById(customer3.getId());

        Assert.assertEquals(3, customerservice.get().size());

        Assert.assertEquals(customer3.getId(), customerservice.getById(customer3.getId()).getId());
    }

    @Transactional
    @Test
    public void testUpdate() {
        Customer customer1 = new Customer();
        customer1.setFirstName("one");
        customer1.setLastName("uno");
        customer1.setEmail("one@gmail.com");
        customer1.setPhone("1");
        customerservice.add(customer1);
        customer1.setFirstName("four");
        customerservice.update(customer1);

        Assert.assertEquals(customer1.getFirstName(), customerservice.getById(customer1.getId()).getFirstName());
    }

    @Transactional
    @Test
    public void testDelete() {
        Customer customer1 = new Customer();
        customerservice.add(customer1);
        customerservice.delete(customer1.getId());

        Assert.assertNull(customerservice.getById(customer1.getId()));
    }

}
