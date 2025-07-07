package org.huy.test.entity.profile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.huy.test.entity.user.User;

@Entity
@Table(name = "profile")
@NoArgsConstructor
@Getter
@Setter
public class Profile {

    @Id
    @Column(name = "user_id", unique = true, nullable = false)
    private Integer userId;

    @MapsId // Mapping using shared PK
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_status_id")
    private ProfileStatus profileStatus;

    @Override
    public String toString() {
        return "profile[" + "userId = " + userId
                + ", firstName = " + firstName
                + ", lastName = " + lastName + "]";
    }
}
