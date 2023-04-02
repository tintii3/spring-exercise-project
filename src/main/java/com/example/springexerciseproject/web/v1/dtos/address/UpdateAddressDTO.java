package com.example.springexerciseproject.web.v1.dtos.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAddressDTO {

    private String street;
    private String city;
    private String country;
}
