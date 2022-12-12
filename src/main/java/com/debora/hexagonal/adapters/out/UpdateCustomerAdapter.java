package com.debora.hexagonal.adapters.out;

import com.debora.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.debora.hexagonal.adapters.out.repository.CustomerRepository;
import com.debora.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.debora.hexagonal.application.core.domain.Customer;
import com.debora.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);

    }
}
