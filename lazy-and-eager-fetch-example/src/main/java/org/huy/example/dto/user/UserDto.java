package org.huy.example.dto.user;

import lombok.Getter;
import lombok.Setter;
import org.huy.example.dto.order.OrderDto;
import org.huy.example.dto.UserAddressDto;
import org.huy.example.dto.profile.ProfileDto;

import java.util.List;

@Getter
@Setter
public class UserDto {

    private Integer userId;
    private String username;
    private ProfileDto profile;
    private UserStatusDto userStatus;
    private List<OrderDto> orders;
    private UserAddressDto userAddress;

}
