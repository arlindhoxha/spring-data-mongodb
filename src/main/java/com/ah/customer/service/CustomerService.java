package com.ah.customer.service;

import com.ah.customer.dao.CustomerRepository;
import com.ah.customer.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Arlind Hoxha on 8/13/2018.
 */
@Service
public class CustomerService {

    private CustomerRepository repository;

    @Autowired
    public void setRepository(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer addCustomer(Customer customer) {
        return repository.insert(customer);
    }

    public void deleteCustomer(String id) {
        repository.deleteById(id);
    }

    public Customer updateCustomer(Customer customer) {
        return repository.save(customer);
    }
}
