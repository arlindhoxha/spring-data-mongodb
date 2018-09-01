package com.ah.customer.controller;

import com.ah.common.ApiPaths;
import com.ah.customer.entity.Customer;
import com.ah.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Arlind Hoxha on 8/13/2018.
 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @RequestMapping(value = ApiPaths.GET_CUSTOMERS, method = RequestMethod.GET)
    public ResponseEntity<Object> getAllCustomers() {
        return new ResponseEntity<>(service.getAllCustomers(), HttpStatus.OK);
    }

    @RequestMapping(value = ApiPaths.ADD_CUSTOMER, method = RequestMethod.POST)
    public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(service.addCustomer(customer), HttpStatus.OK);
    }

    @RequestMapping(value = ApiPaths.DELETE_CUSTOMER, method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCustomer(@RequestParam String firstName) {
        service.deleteCustomer(firstName);
        return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = ApiPaths.UPDATE_CUSTOMER, method = RequestMethod.POST)
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(service.updateCustomer(customer), HttpStatus.OK);
    }
}
