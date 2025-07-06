package org.huy.test_maven.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Integer userId;

    @Column(name = "username")
    private String username;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY) // working as intended
    @JsonIgnore
    private Set<Order> orders;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Profile profile;

//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private List<Profile> profile;

//    public Profile getProfile() {
//        return this.profile == null || this.profile.isEmpty() ? null : this.profile.get(0);
//    }
}
