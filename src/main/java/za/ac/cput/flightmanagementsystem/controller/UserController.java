package za.ac.cput.flightmanagementsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.flightmanagementsystem.domain.User;
import za.ac.cput.flightmanagementsystem.service.UserServiceImpl;


import java.util.List;


@RestController
@RequestMapping("/user")
@Slf4j
@CrossOrigin
public class UserController {
    public final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> user= userService.findAllUsers();
        return ResponseEntity.ok(user);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<User> getId(@PathVariable("id") Long id){
        User user= userService.findByUserId(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/findByUsername/{username}")
    public ResponseEntity<User> getByUsername(@PathVariable("username") String username){
        User user= userService.findUserByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User newUser= userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User updateUser= userService.updateUser(user);
        return new ResponseEntity<>(updateUser,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
