package org.huy.example.repository;

import org.huy.example.entity.order.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>, PagingAndSortingRepository<Order, Integer> {

//    @Query(value = """
//            SELECT o.*
//            FROM orders o
//            WHERE o.user_id = ?1""",
//            nativeQuery = true)
    @Query("SELECT o FROM Order o LEFT JOIN FETCH o.status INNER JOIN FETCH o.user u WHERE u.userId =:userId")
    List<Order> findByUserId(Integer userId);

    @Query(value = """ 
    SELECT o
    FROM Order o
        LEFT JOIN FETCH o.status
    WHERE o.user.userId = :userId
    ORDER BY o.createdAt
    """)
    List<Order> findByUserId(Integer userId, Pageable pageable);

    @Query(value = """
            SELECT o
            FROM Order o
            WHERE o.user.userId = :userId
            """)
    List<Order> findAllByUserId(Integer userId);
}
