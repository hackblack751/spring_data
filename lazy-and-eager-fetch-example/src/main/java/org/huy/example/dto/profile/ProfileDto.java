package org.huy.example.dto.profile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.huy.example.entity.profile.Profile;

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
