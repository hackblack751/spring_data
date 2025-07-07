package org.huy.test.controller;

import org.huy.test.dto.*;
import org.huy.test.dto.profile.ProfileDto;
import org.huy.test.dto.user.UserDto;
import org.huy.test.dto.user.UserStatusDto;
import org.huy.test.entity.Order;
import org.huy.test.entity.profile.Profile;
import org.huy.test.entity.user.User;
import org.huy.test.repository.OrderRepository;
import org.huy.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getById(@PathVariable Integer userId) {

        User user = this.userRepository.findById(userId).orElse(null);

//        User user = userRepository.findByUserIdNative(userId);

//        User user = userRepository.findByUserId(userId);

//        User user = this.userRepository.findUserWithProfile(userId);

        // lazy init profile
        Profile profile = user.getProfile();
        System.out.println(profile);

        // lazy init orders
        Set<Order> orders = user.getOrders();
        orders.stream().forEach(System.out::println);


        System.out.println("End debug");
        return ResponseEntity.ok("ok");
    }


    @GetMapping
    public ResponseEntity<?> getUsersPagination(@RequestParam(defaultValue = "0") Integer pageNum,
                                                @RequestParam(defaultValue = "10") Integer pageSize) {

//        Page<User> result = this.userRepository.findUsers(PageRequest.of(pageNum, pageSize));

//        Page<User> result = this.userRepository.findUsersNative(PageRequest.of(pageNum, pageSize));

//        Page<User> result = this.userRepository.findUserss(PageRequest.of(pageNum, pageSize));

        // Let the
        Page<User> result = this.userRepository.findAll(PageRequest.of(pageNum, pageSize));

        List<UserDto> userDtos = new ArrayList<>();
        if(!result.isEmpty()) {
//            boolean isUser = result.getContent().get(0) instanceof User;

            for(User user : result.getContent()) {
                UserDto userDto = new UserDto();
                userDto.setUserId(user.getUserId());
                userDto.setUsername(user.getUsername());
                userDto.setProfile(new ProfileDto(user.getProfile()));
                userDto.setUserStatus(new UserStatusDto(user.getStatus()));

                List<Order> orders = this.orderRepository.findByUserId(user.getUserId(), PageRequest.of(0, 10));
                userDto.setOrders(orders.stream().map(OrderDto::new).toList());
                userDto.setUserAddress(new UserAddressDto(user.getAddress()));

//                ProfileStatus ps =  user.getProfile().getProfileStatus();
//                if(ps == null) user.getProfile().setProfileStatus(null);
//                // GET n + 1 problem with native query
//                Set<Order> orders = user.getOrders();
//                System.out.println(orders);
                userDtos.add(userDto);
            }
        }

        System.out.println("End debug");
        return ResponseEntity.ok(userDtos);
//        return ResponseEntity.ok(result.getContent());
    }
}
