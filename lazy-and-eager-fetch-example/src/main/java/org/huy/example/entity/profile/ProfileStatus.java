package org.huy.example.entity.profile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "profile_status")
@Getter
@Setter
@NoArgsConstructor
public class ProfileStatus {

    @Id
    @Column(name = "profile_status_id")
    private Integer profileStatusId;

    @Column(name = "status_name")
    private String statusName;

    @OneToMany(mappedBy = "profileStatus", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Profile> profiles;


}
