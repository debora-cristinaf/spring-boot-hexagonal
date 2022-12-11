package com.debora.hexagonal.adapters.out.client.mapper;

import com.debora.hexagonal.adapters.out.response.AddressResponse;
import com.debora.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
