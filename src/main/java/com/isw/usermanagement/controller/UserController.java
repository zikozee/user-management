package com.isw.usermanagement.controller;

import com.isw.usermanagement.dto.UserDto;
import com.isw.usermanagement.model.User;
import com.isw.usermanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @created : 06 April 2022
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> saveNewUser(@RequestBody User user){

        Object o = userService.saveUser(user);
        if(o instanceof String)  return new ResponseEntity<>(o, HttpStatus.OK);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping(path = "edit")
    public ResponseEntity<User> editUserProfile(@RequestBody User user){
        return new ResponseEntity<>(userService.editUser(user), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<User> fetchUserByName(@RequestParam("firstName") String firstName){
        return new ResponseEntity<>(userService.fetchByFirstName(firstName), HttpStatus.OK);
    }

    @GetMapping(path = "all")
    public ResponseEntity<List<UserDto>> fetchUserByName(){
        return new ResponseEntity<>(userService.fetchAllUsers(), HttpStatus.OK);
    }
}


// model(domain)(entity) -> repo -> service -> controller
