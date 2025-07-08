package org.huy.example.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "user_status")
@Getter
@Setter
@NoArgsConstructor
public class UserStatus {

    @Id
    @Column(name = "status_id")
    private Integer statusId;

    @Column(name = "status_name")
    private String statusName;

    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<User> users;
}
