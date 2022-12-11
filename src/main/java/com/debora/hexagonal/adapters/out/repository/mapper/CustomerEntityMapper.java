package com.debora.hexagonal.adapters.out.repository.mapper;

import com.debora.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.debora.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    CustomerEntity toCustomerEntity(Customer customer);
}
