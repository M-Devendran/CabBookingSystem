package com.example.cabify.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login {

    private int userId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


}
