package com.debora.hexagonal.adapters.in.controller.response;

import com.debora.hexagonal.adapters.out.response.AddressResponse;
import lombok.Data;
@Data
public class CustomerResponse {
    private String name;
    private AddressResponse address;
    private String cpf;
    private Boolean isValidCpf;
}

