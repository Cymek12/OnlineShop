package com.mysite.modelPublic.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CustomerDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
