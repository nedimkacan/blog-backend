package com.ndmkcn.blog.service;

import com.ndmkcn.blog.entity.User;
import com.ndmkcn.blog.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public User getUserById(Long id){
        return this.userRepository.findById(id).orElse(null);
    }

    public User saveUser(User newUser){
        return this.userRepository.save(newUser);
    }

    public User updateUser(User newUser,Long id){
        Optional<User> user=this.userRepository.findById(id);
        if (user.isPresent()) {
            User userFound=user.get();
            userFound.setUserName(newUser.getUserName());
            userFound.setPassword(newUser.getPassword());
            this.userRepository.save(userFound);
            return userFound;
        } else {
            return null;
        }
    }

    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }
}
