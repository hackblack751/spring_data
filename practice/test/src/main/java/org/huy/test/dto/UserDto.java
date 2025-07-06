package org.huy.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {

    private Integer userId;
    private String username;
    private ProfileDto profile;
    private UserStatusDto userStatus;
    private List<OrderDto> orders;


}
