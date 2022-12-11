package com.debora.hexagonal.application.ports.out;

import com.debora.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
