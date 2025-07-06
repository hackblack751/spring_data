package org.huy.test.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.huy.test.entity.Profile;
import org.huy.test.entity.ProfileStatus;

@Getter
@Setter
@NoArgsConstructor
public class ProfileDto {
    private String firstName;
    private String lastName;
    private ProfileStatusDto profileStatusDto;

    public ProfileDto(Profile entity) {
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        if(entity.getProfileStatus() != null) this.profileStatusDto = new ProfileStatusDto(entity.getProfileStatus());
    }
}
