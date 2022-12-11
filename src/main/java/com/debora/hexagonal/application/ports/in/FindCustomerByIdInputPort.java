package com.debora.hexagonal.application.ports.in;

import com.debora.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {
    Customer find(String id);
}
