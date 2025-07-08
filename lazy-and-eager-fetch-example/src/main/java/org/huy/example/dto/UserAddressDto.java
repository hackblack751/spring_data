package org.huy.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.huy.example.entity.Address;

@Getter
@Setter
@NoArgsConstructor
public class UserAddressDto {

    private Integer addressId;
    private String street;

    public UserAddressDto(Address address) {
        if(address == null) return;
        this.addressId = address.getAddressId();
        this.street = address.getStreet();
    }
}
