package org.huy.test.dto.user;

import lombok.Getter;
import lombok.Setter;
import org.huy.test.dto.order.OrderDto;
import org.huy.test.dto.UserAddressDto;
import org.huy.test.dto.profile.ProfileDto;

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
