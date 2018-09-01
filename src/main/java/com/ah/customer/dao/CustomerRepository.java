package com.ah.customer.dao;

import com.ah.customer.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Arlind Hoxha on 8/13/2018.
 */
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    Customer findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
}
