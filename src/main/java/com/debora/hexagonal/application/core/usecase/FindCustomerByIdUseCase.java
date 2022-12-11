package com.debora.hexagonal.application.core.usecase;

import com.debora.hexagonal.application.core.domain.Customer;
import com.debora.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.debora.hexagonal.application.ports.out.FindCustomerByIdOutput;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    public final FindCustomerByIdOutput findCustomerByIdOutput;

    public FindCustomerByIdUseCase(FindCustomerByIdOutput findCustomerByIdOutput) {
        this.findCustomerByIdOutput = findCustomerByIdOutput;

    }

    @Override
    public Customer find(String id) {
        return findCustomerByIdOutput.find(id)
                .orElseThrow(() -> new RuntimeException("Customer not found") );
    }
}
