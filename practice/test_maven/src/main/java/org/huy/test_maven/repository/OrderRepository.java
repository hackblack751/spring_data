package org.huy.test_maven.repository;

import org.huy.test_maven.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

//    @Query(value = """
//            SELECT o.*
//            FROM orders o
//            WHERE o.user_id = ?1""",
//            nativeQuery = true)
    @Query("SELECT o FROM Order o LEFT JOIN FETCH o.status INNER JOIN FETCH o.user u WHERE u.userId =:userId")
    List<Order> findByUserId(Integer userId);
}
