package org.huy.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "profile")
@NoArgsConstructor
@Getter
@Setter
public class Profile {

    @Id
    @Column(name = "user_id", unique = true, nullable = false)
    private Integer userId;

    @MapsId
//    @ManyToOne(fetch = FetchType.LAZY)
    @OneToOne(fetch = FetchType.LAZY)
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
