package com.example.controllers;

import com.example.model.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ahhughes8 on 8/17/17.
 */

@Controller
public class CustomerControllers {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/")
    public String getHome() {
        return "/Home";
    }

    @RequestMapping("/Customers")
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerService.get());
        return "/Customers";
    }

    @RequestMapping("/ViewCustomer/{id}")
    public String getViewCustomer(Model model, @PathVariable String id) {
        model.addAttribute("customer", customerService.getById(Integer.parseInt(id)));
        return "/ViewCustomer";
    }

    @RequestMapping(path = "/AddCustomer", method = RequestMethod.GET)
    public String getAddCustomers(){
        return "/AddCustomer";
    }

    @RequestMapping(path = "/AddCustomer", method = RequestMethod.POST)
    public String postAddCustomers(@RequestParam(value="firstName") String firstName,
                                  @RequestParam(value="lastName") String lastName,
                                  @RequestParam(value="email") String email,
                                  @RequestParam(value="phone") String phone) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setPhone(phone);
        customerService.add(customer);
        return "redirect:/Customers";
    }

}
