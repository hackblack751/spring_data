package org.huy.example.controller;

import lombok.RequiredArgsConstructor;
import org.huy.example.entity.order.Order;
import org.huy.example.entity.profile.Profile;
import org.huy.example.entity.user.User;
import org.huy.example.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileRepository profileRepository;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getById(@PathVariable Integer userId) {

        Profile profile = this.profileRepository.findById(userId).orElse(null);

        List<Integer> userOrderIds = new LinkedList<>();
        if(profile != null) {
            User user = profile.getUser();
            for(Order order : user.getOrders())  {
                userOrderIds.add(order.getOrderId());
            }
            System.out.println("order id list of user with id " + user.getUserId() +
                    ": " + Arrays.toString(userOrderIds.toArray(Integer[]::new)));
        }

        System.out.println("Debug end");
        return ResponseEntity.ok().build();
    }
}
