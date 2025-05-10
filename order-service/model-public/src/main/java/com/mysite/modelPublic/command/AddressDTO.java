package com.mysite.modelPublic.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddressDTO {
    private String country;
    private String province;
    private String city;
    private String zipcode;
    private String street;
    private String apartmentNumber;
}
