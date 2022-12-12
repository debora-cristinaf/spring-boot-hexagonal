package com.debora.hexagonal.application.ports.out;

import com.debora.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {
    void update(Customer customer);
}
