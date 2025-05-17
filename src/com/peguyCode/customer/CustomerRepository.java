package com.peguyCode.customer;

import java.util.List;

public interface CustomerRepository {
    Customer findById(int id);

    List<Customer> findAllCustomer();

    void saveCustomerByNameOrId(String name, int id);
}
