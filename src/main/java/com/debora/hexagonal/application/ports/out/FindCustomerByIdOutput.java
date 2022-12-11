package com.debora.hexagonal.application.ports.out;

import com.debora.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutput {
    Optional<Customer> find(String id);
}