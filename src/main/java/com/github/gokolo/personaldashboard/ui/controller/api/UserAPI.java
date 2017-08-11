package com.github.gokolo.personaldashboard.ui.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.gokolo.personaldashboard.service.models.UserVO;
import com.github.gokolo.personaldashboard.service.services.UserService;
import com.github.gokolo.personaldashboard.ui.response.ApiResponse;
import com.github.gokolo.personaldashboard.ui.response.ErrorResponse;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserAPI {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<ApiResponse> getUsers() {
        return ResponseEntity.ok(ApiResponse.builder().payload(userService.findAll()).build());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<ApiResponse> getUser(@PathVariable("id") final int id) {
        UserVO user = userService.findByID(id);

        if (user == null) {
            return ResponseEntity.badRequest().body(
                    ApiResponse.builder().payload(ErrorResponse.builder().message("Invalid user ID!").build()).build());
        }

        return ResponseEntity.ok(ApiResponse.builder().payload(user).build());
    }
}
