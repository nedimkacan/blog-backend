package com.ndmkcn.blog.controller;

import com.ndmkcn.blog.entity.User;
import com.ndmkcn.blog.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return this.userService.getUserById(id);
    }

    @PostMapping
    public User saveUser(@RequestBody User newUser){
        return this.userService.saveUser(newUser);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User newUser,@PathVariable Long id){
        return this.userService.updateUser(newUser,id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        this.userService.deleteUser(id);
    }
}
