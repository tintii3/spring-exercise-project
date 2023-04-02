package com.example.springexerciseproject.web.v1.dtos.actor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateActorDTO {

    private String firstName;
    private String lastName;
}
