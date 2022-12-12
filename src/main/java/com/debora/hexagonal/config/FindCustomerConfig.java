package com.debora.hexagonal.config;

import com.debora.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.debora.hexagonal.adapters.out.InsertCustomerAdapter;
import com.debora.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.debora.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase (
            FindCustomerByIdAdapter findCustomerByIdAdapter
    ) {
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }


}
