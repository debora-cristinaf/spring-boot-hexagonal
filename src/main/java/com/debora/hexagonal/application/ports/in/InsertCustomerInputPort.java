package com.debora.hexagonal.application.ports.in;

import com.debora.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {
    void insert(Customer customer, String zipCode);
}
