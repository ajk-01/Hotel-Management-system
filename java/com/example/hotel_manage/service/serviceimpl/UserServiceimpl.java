package com.example.hotel_manage.service.serviceimpl;

import com.example.hotel_manage.dto.response.RoleResult;
import com.example.hotel_manage.dto.response.UserResult;
import com.example.hotel_manage.entity.Role;
import com.example.hotel_manage.entity.User;
import com.example.hotel_manage.repository.RoleRepository;
import com.example.hotel_manage.repository.UserRepository;
import com.example.hotel_manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hotel_manage.dto.request.CreateUser;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<UserResult> findAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserResult(user.getId(),user.getUser_name(),user.getGender(),user.getContact(),
                        new RoleResult( user.getRole().getId(),user.getRole().getRole_name())))
                .collect(Collectors.toList());
    }
    @Override
    public UserResult findById(Long id)
    {
        Optional<User> existingUSer=userRepository.findById(id);
        if(existingUSer.isPresent())
        {
            User user =existingUSer.get();
            return  new UserResult(user.getId(),user.getUser_name(),user.getGender(),user.getContact(),
                    new RoleResult( user.getRole().getId(),
                            user.getRole().getRole_name()));
        }
        return null;
    }

    @Override
    public List<UserResult> editUser(Long id, CreateUser updatedUser) {
        return null;
    }


    @Override
    public List<UserResult> createUser(CreateUser createUser) {
        Role role=roleRepository.findById(createUser.getRoleId()).get();
        User user=new User(createUser.getName(), createUser.getGender(), createUser.getContact(),role   );
        userRepository.save(user);
        return  findAllUsers();
    }

    @Override
    public List<UserResult> deleteUserById(Long id) {
         userRepository.deleteById(id);
        return null;
    }

    @Override
    public List<UserResult> editUserById(Long id, CreateUser updatedUser) {
        Optional<User> existingUser=userRepository.findById(id);
        if(existingUser.isPresent())
        {
            User user = existingUser.get();
            user.setUser_name(updatedUser.getName());
            user.setGender(updatedUser.getGender());
            user.setContact(updatedUser.getContact());
            Optional<Role> existingRole=roleRepository.findById(id);
            if(existingRole.isPresent())
            { user.setRole(existingRole.get());}

            userRepository.save(user);
        }
        return findAllUsers();
    }



}
