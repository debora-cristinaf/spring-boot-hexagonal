package com.debora.hexagonal.adapters.out;

import com.debora.hexagonal.adapters.out.repository.CustomerRepository;
import com.debora.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.debora.hexagonal.application.core.domain.Customer;
import com.debora.hexagonal.application.ports.out.FindCustomerByIdOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutput {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCostumer(entity));
    }
}
