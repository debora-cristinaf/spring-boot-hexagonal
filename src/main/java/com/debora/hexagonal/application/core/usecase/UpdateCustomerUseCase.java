package com.debora.hexagonal.application.core.usecase;

import com.debora.hexagonal.application.core.domain.Customer;
import com.debora.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.debora.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.debora.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.debora.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    public final FindCustomerByIdInputPort findCustomerByIdInputPort;

    public final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    public final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                 FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdInputPort.find(customer.getId());

        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);

        updateCustomerOutputPort.update(customer);

    }
}
