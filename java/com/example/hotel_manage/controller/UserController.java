package com.example.hotel_manage.controller;

import com.example.hotel_manage.dto.request.CreateUser;
import com.example.hotel_manage.dto.response.UserResult;
import com.example.hotel_manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/get-all-Users")
    public List<UserResult> getAllUser()
    {
        return userService.findAllUsers();
    }
    @GetMapping("/get-by-id/user/{id}")
    public List<UserResult> getById(@PathVariable("id") Long id)
    {
        return (List<UserResult>) userService.findById(id);
    }
    @PostMapping("/create-users")
    public List<UserResult> createUser(@RequestBody CreateUser createUser)
    {
        return userService.createUser(createUser);
    }
    @PutMapping("/edit-user/{id}")
    public List<UserResult> editUser(@PathVariable("id") Long id,@RequestBody CreateUser updatedUser)
    {
        return userService.editUser(id, updatedUser);
    }
    @DeleteMapping("/remove-user/{id}")
    public List<UserResult> deleteUser(@PathVariable("id") Long id){
        return userService.deleteUserById(id);}
}
