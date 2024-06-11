package com.example.managementSystem.Controller;

import com.example.managementSystem.Dtos.UserDto;
import com.example.managementSystem.Entity.User;
import com.example.managementSystem.Repository.CustomUserResponseDTO;
import com.example.managementSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("user")
public class UserController {
    UserService userService ;
    @Autowired
    public UserController(UserService userService) {
        this.userService=userService;
    }
@PostMapping("create")
    public ResponseEntity<String>CreateUser(@RequestBody UserDto userdto){
        userService.createUser(userdto);
        return ResponseEntity.ok("successfully created");
    }
    @GetMapping("{id}")
    public ResponseEntity<User>GetuserById(@PathVariable  int id){
        User finduser=userService.findUserById(id);
        return ResponseEntity.ok(finduser);
    }
    @GetMapping("")
    public ResponseEntity<List<User>> FindAll(){
        return ResponseEntity.ok(userService.findall());
    }
    @DeleteMapping("{id}")
    public String deleteUserById(@PathVariable int id){
        userService.deleteuser(id);
        return "User deleted";
    }
    @PutMapping("update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody UserDto userdto) {
      User upadteUser=userService.updateUser(id,userdto);
      return ResponseEntity.ok(upadteUser);
    }

    @GetMapping("custom-findall")
    public ResponseEntity<Set<CustomUserResponseDTO>> FindAllCustomUser(){
       return ResponseEntity.ok(userService.findAllUsers());

    }
    @GetMapping("/async")
    public String callAsyncMethod() {
        return userService.asyncMethod();
    }

}
