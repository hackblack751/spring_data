package org.huy.test.repository;

import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SqlResultSetMapping;
import org.huy.test.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    @Query(value = """
            SELECT
                u.*
            FROM users u
                LEFT JOIN profile p
                    ON p.user_id = u.user_id
                LEFT JOIN user_status us
                    ON us.status_id = u.status_id
                LEFT JOIN order o
                    ON o.user_id = u.user_id
            WHERE u.user_id = ?1
            """
            , nativeQuery = true)
    User findByUserIdNative(Integer userId);

    @Query(value = """
            SELECT
                u.*
            FROM users u 
                LEFT JOIN profile p
                    ON p.user_id = u.user_id
                LEFT JOIN profile_status ps
                    ON p.profile_status_id = ps.profile_status_id
                LEFT JOIN user_status us
                    ON u.status_id = us.status_id
            ORDER BY u.user_id
            """,
            countQuery = """
            COUNT(*)
            FROM users u
            ORDER BY u.user_id
            """,nativeQuery = true)
    Page<User> findUsersNative(Pageable pageable);

    @Query(value = """
            SELECT u
            FROM User u
            ORDER BY u.userId
            """,
            countQuery = """
            SELECT COUNT(u)
            FROM User u
            """)
    Page<User> findUserss(Pageable pageable);

    @Query(value = """
            SELECT u
            FROM User u
                LEFT JOIN FETCH u.profile
                LEFT JOIN FETCH u.status
                LEFT JOIN FETCH u.orders
            WHERE u.userId = :userId
            """)
    User findByUserId(Integer userId);


    @Query(name = "User.findUserWithProfile")
    User findUserWithProfile(Integer userId);

    @Query(name = "User.findUsers", countName = "User.countUser")
    Page<User> findUsers(Pageable pageable);
}
