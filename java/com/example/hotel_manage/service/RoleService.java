package com.example.hotel_manage.service;

import com.example.hotel_manage.dto.request.CreateRole;
import com.example.hotel_manage.dto.response.RoleResult;

import java.util.List;

public interface RoleService {
    List<RoleResult> findAllRoles();

    List<RoleResult> createRole(CreateRole createRole);

    List<RoleResult> editRole(Long id, String role_name);

    List<RoleResult> deleteRoleById(Long id);

    RoleResult getById(Long id);
}
