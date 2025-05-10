package com.mysite.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Address {
    private Long id;
    private String country;
    private String province;
    private String city;
    private String zipCode;
    private String street;
    private String apartmentNumber;
}


