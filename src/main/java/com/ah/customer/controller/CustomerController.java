package com.ah.customer.controller;

import com.ah.common.ApiPaths;
import com.ah.customer.entity.Customer;
import com.ah.customer.entity.CustomerResponse;
import com.ah.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Arlind Hoxha on 8/13/2018.
 */
@RestController
public class CustomerController {

    private CustomerService service;

    @Autowired
    public void setService(CustomerService service) {
        this.service = service;
    }

    @RequestMapping(value = ApiPaths.GET_CUSTOMERS, method = RequestMethod.GET)
    public CustomerResponse getAllCustomers() {
        List<Customer> customerList = service.getAllCustomers();
        Customer[] customers = new Customer[customerList.size()];
        customers = customerList.toArray(customers);

        return new CustomerResponse(true, "success", customers);
    }

    @RequestMapping(value = ApiPaths.ADD_CUSTOMER, method = RequestMethod.POST)
    public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(service.addCustomer(customer), HttpStatus.OK);
    }

    @RequestMapping(value = ApiPaths.REMOVE_CUSTOMER, method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") String id) {
        service.deleteCustomer(id);
        return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = ApiPaths.UPDATE_CUSTOMER, method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(service.updateCustomer(customer), HttpStatus.OK);
    }
}
