package com.example.customersvl;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    void update(int id, Customer customer);
    void remove(int id);
    Customer findbyID(int id);

}
