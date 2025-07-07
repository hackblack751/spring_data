package org.huy.test.controller;

import org.huy.test.entity.Order;
import org.huy.test.entity.profile.Profile;
import org.huy.test.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getById(@PathVariable Integer userId) {

        Profile profile = this.profileRepository.findById(userId).orElse(null);

        if(profile != null) {
            for(Order order : profile.getUser().getOrders())  {
                order.getOrderId();
            }
        }


        System.out.println("Debug end");
        return ResponseEntity.ok().build();
    }
}
