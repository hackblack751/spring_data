package org.huy.test.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.huy.test.entity.user.UserStatus;

@Getter
@Setter
@NoArgsConstructor
public class UserStatusDto {

    private Integer statusId;
    private String statusName;

    public UserStatusDto(UserStatus entity) {
        this.statusId = entity.getStatusId();
        this.statusName = entity.getStatusName();
    }
}
