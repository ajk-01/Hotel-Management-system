package com.example.hotel_manage.service.serviceimpl;

import com.example.hotel_manage.dto.request.CreateRole;
import com.example.hotel_manage.dto.response.RoleResult;
import com.example.hotel_manage.entity.Role;
import com.example.hotel_manage.repository.RoleRepository;
import com.example.hotel_manage.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RoleServiceimpl implements RoleService {
     @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<RoleResult> findAllRoles() {
        return roleRepository.findAll().stream()
                .map(role -> new RoleResult(role.getId(),role.getRole_name()))
                .collect(Collectors.toList());
    }
    @Override
    public List<RoleResult> createRole(CreateRole createRole)
    {
        Role role=new Role();
        role.setRole_name(createRole.getRole_name());
        roleRepository.save(role);
        return  findAllRoles();
    }

    @Override
    public List<RoleResult> editRole(Long id, String role_name) {
        Optional<Role> existingRole=roleRepository.findById(id);
        if(existingRole.isPresent())
        {
            Role role = existingRole.get();
            role.setRole_name(role_name);
            roleRepository.save(role);
        }
        return findAllRoles();
    }

    @Override
    public List<RoleResult> deleteRoleById(Long id) {
        roleRepository.deleteById(id);
        return findAllRoles();
    }

    @Override
    public RoleResult getById(Long id) {
        Role role= roleRepository.findById(id).get();
        return new RoleResult(role.getId(),role.getRole_name());
    }
}
