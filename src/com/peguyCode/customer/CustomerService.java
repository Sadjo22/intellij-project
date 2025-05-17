package com.peguyCode.customer;

import java.util.List;

public class CustomerService {
    private final CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }


    public Customer findById(int id) {
        return customerRepo.findById(id);
    }


    public void saveCustomer(Customer customer) {
        if (customer == null || customer.name == null || customer.name.isEmpty()) {
            throw new IllegalArgumentException("Customer name must not be null or empty.");
        }

        // Generate a unique ID for the customer
        int generatedId;
        do {
            generatedId = (int) (Math.random() * 10000); // Generate a random ID
        } while (customerRepo.findById(generatedId) != null); // Ensure the ID is not already taken

        customer.id = generatedId; // Assign the generated ID to the customer
        customerRepo.saveCustomerByNameOrId(customer.name, customer.id);


    }

    public List<Customer> findAllCustomers() {
        return customerRepo.findAllCustomer();
    }
}
