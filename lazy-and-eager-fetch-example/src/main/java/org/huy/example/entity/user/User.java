package org.huy.example.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.huy.example.entity.Address;
import org.huy.example.entity.order.Order;
import org.huy.example.entity.profile.Profile;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SqlResultSetMapping(
        name = "userWithProfileMapping",
        entities = {
                @EntityResult(entityClass = User.class,
                    fields = {
                        @FieldResult(name = "userId", column = "u.user_id"),
                        @FieldResult(name = "username", column = "u.username"),
                        @FieldResult(name = "status", column = "u.status_id")
                    }
                ),
                @EntityResult(entityClass = Profile.class
                    , fields = {
                        @FieldResult(name = "userId", column = "p.user_id")
                        , @FieldResult(name = "firstName", column = "p.first_name")
                        , @FieldResult(name = "lastName", column = "p.last_name")

                    }
                )
        }
)
// TODO: confirm this named queries.
@NamedNativeQueries(
        {
            @NamedNativeQuery(
                name = "User.findUserWithProfile",
                query = """
            SELECT
                u.user_id AS "u.user_id", u.username AS "u.username"
                , u.status_id AS "u.status_id"
                , p.user_id AS "p.user_id", p.first_name AS "p.first_name"
                , p.last_name AS "p.last_name"
            FROM users u
                LEFT JOIN profile p
                    ON p.user_id = u.user_id
            WHERE u.user_id = ?1
            ORDER BY u.user_id
                """,
                        resultSetMapping = "userWithProfileMapping"
            ),
            @NamedNativeQuery(
                    name = "User.findUsers",
                    query = """
                SELECT
                u.user_id AS "u.user_id", u.username AS "u.username"
                , u.status_id AS "u.status_id"
                , p.user_id AS "p.user_id", p.first_name AS "p.first_name"
                , p.last_name AS "p.last_name"
            FROM users u
                LEFT JOIN profile p
                    ON p.user_id = u.user_id
            ORDER BY u.user_id
                            """,
                    resultSetMapping = "userWithProfileMapping"
            ),
            @NamedNativeQuery(
                        name = "User.countUser",
                        query = """
            SELECT COUNT(*)
            FROM users u
                """,
                    resultClass = Long.class
            )
        }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "username")
    private String username;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY) // working as intended
    @JsonIgnore
    private Set<Order> orders = new HashSet<>();

    /** using shared PK, JPA respect LAZY fetch type.*/
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, optional = false)
    private Profile profile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private UserStatus status;

    /** JPA ignore LAZY fetch of non-owner side except "shared PK".*/
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, optional = false)
    private Address address;

    public void setAddress(Address address) {
        if(address == null) {
            if(this.address != null) this.address = null;
        } else {
            this.address = address;
            address.setUser(this);
        }
    }
}
