package com.learning.dynamodb.controller;

import java.util.Arrays;

import com.learning.dynamodb.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.learning.dynamodb.repo.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping("/save")
    public String save() {
        // save a single Customer
        customerRepository.save(new Customer("JSA-1", "Jack", "Smith"));

        // save a list of Customers
        customerRepository.save(Arrays.asList(new Customer("JSA-2", "Adam", "Johnson"), new Customer("JSA-3", "Kim", "Smith"),
                new Customer("JSA-4", "David", "Williams"), new Customer("JSA-5", "Peter", "Davis")));

        return "Done";
    }

    @RequestMapping(value = "/findall", method= RequestMethod.GET)
    public Iterable<Customer> findAll() {
        String result = "";
        Iterable<Customer> customers = customerRepository.findAll();

        for (Customer cust : customers) {
            result += cust.toString() + "<br>";
        }

        System.out.println(result);

        return customers;
    }
}