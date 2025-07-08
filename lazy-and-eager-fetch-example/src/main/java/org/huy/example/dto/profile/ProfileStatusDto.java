package org.huy.example.dto.profile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.huy.example.entity.profile.ProfileStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileStatusDto {

    private Integer profileStatusId;
    private String statusName;

    public ProfileStatusDto(ProfileStatus profileStatus) {
        this.profileStatusId = profileStatus.getProfileStatusId();
        this.statusName = profileStatus.getStatusName();
    }
}
