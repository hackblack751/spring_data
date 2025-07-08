package org.huy.example.controller;

import lombok.RequiredArgsConstructor;
import org.huy.example.dto.*;
import org.huy.example.dto.order.OrderDto;
import org.huy.example.dto.profile.ProfileDto;
import org.huy.example.dto.user.UserDto;
import org.huy.example.dto.user.UserStatusDto;
import org.huy.example.entity.order.Order;
import org.huy.example.entity.profile.Profile;
import org.huy.example.entity.user.User;
import org.huy.example.repository.OrderRepository;
import org.huy.example.repository.UserRepository;
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
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final OrderRepository orderRepository;

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

        // Sử dung method cua JPA
        Page<User> result = this.userRepository.findAll(PageRequest.of(pageNum, pageSize));

        List<UserDto> userDtoList = new ArrayList<>();
        if(!result.isEmpty()) {
            // Tạo dto tu entity
            userDtoList = result.getContent().stream()
                    .map(this::createUserDto).toList();
        }

        System.out.println("End debug");
        return ResponseEntity.ok(userDtoList);
    }

    public UserDto createUserDto(User entity) {
        UserDto userDto = new UserDto();
        userDto.setUserId(entity.getUserId());
        userDto.setUsername(entity.getUsername());
        userDto.setProfile(new ProfileDto(entity.getProfile()));
        userDto.setUserStatus(new UserStatusDto(entity.getStatus()));

        List<Order> orders = this.orderRepository.findByUserId(entity.getUserId(), PageRequest.of(0, 10));
        userDto.setOrders(orders.stream().map(OrderDto::new).toList());
        userDto.setUserAddress(new UserAddressDto(entity.getAddress()));

        return userDto;
    }
}
