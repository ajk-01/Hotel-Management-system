package com.example.hotel_manage.service;

import com.example.hotel_manage.dto.request.CreateUser;
import com.example.hotel_manage.dto.response.UserResult;

import java.util.List;

public interface UserService {
    List<UserResult> findAllUsers();

    List<UserResult> createUser(CreateUser createUser);


    List<UserResult> deleteUserById(Long id);

    List<UserResult> editUserById(Long id, CreateUser updatedUser);


    UserResult findById(Long id);


    List<UserResult> editUser(Long id, CreateUser updatedUser);
}
