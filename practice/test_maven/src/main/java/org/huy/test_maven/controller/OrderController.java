package org.huy.test_maven.controller;

import org.huy.test_maven.entity.Order;
import org.huy.test_maven.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getAllOrders(@PathVariable Integer userId) {
        List<Order> orders = this.orderRepository.findByUserId(userId);

        // trigger JPA query the status
//        for(Order order : orders) {
//            order.getStatus();
//        }

        System.out.println("end of debug");
        return ResponseEntity.ok(orders);
    }
}
