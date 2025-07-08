package org.huy.example.controller;

import lombok.RequiredArgsConstructor;
import org.huy.example.entity.order.Order;
import org.huy.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getAllOrders(@PathVariable Integer userId) {
        List<Order> orders = this.orderRepository.findAllByUserId(userId);

        // trigger JPA query the status
//        for(Order order : orders) {
//            order.getStatus();
//        }

        System.out.println("end of debug");
        return ResponseEntity.ok(orders);
    }
}
