package com.debora.hexagonal.application.ports.in;

import com.debora.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {
    void update(Customer customer, String zipCode);
}
