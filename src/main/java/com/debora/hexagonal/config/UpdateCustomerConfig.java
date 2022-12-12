package com.debora.hexagonal.config;

import com.debora.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.debora.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.debora.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.debora.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}
