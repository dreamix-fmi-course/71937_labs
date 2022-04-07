package com.fmi.web.theaterticketsystem.rest;

import com.fmi.web.theaterticketsystem.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// localhost:8080/dummy/
@RestController
@RequestMapping("/dummy")
public class DummyController {
    private final List<User> users = new ArrayList<>();

    @GetMapping("/hello-world")
    public String dummyGet() {
        return "Dummy Get";
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        this.users.add(user);
        return user;
    }

    @DeleteMapping("/user")
    public User deleteUser(@RequestParam int id) {

    }

    @GetMapping("/user/")
    public User getUserByID(@RequestParam int id) {

    }

    @GetMapping("/user/")
    public User getUserByEmail(@RequestParam String email) {

    }

    public List<User> getUsers() {
        return this.users;
    }
}
