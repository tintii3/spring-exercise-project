package com.example.springexerciseproject.web.v1.dtos.actor;

import com.example.springexerciseproject.web.v1.dtos.address.CreateAddressDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateActorDTO {
    private String firstName;
    private String lastname;
    private Integer age;
    private CreateAddressDTO address;
    public boolean hasAddress(){
        return Objects.nonNull(address);
    }
}
