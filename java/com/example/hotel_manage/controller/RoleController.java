package com.example.hotel_manage.controller;

import com.example.hotel_manage.dto.request.CreateRole;
import com.example.hotel_manage.dto.response.RoleResult;
import com.example.hotel_manage.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("/get-all-roles")
    public List<RoleResult>getallRoles(){
        return roleService.findAllRoles();
    }
    @GetMapping("/get-by-id/{id}")
    public RoleResult getById(@PathVariable("id") Long id)
    {
        return roleService.getById(id);
    }
    @PostMapping("/create-role")
    public List<RoleResult> createRole(@RequestBody CreateRole createRole)
    {
        return roleService.createRole(createRole);
    }
    @PutMapping("/edit-role")
    public List<RoleResult> editRole(@RequestParam("id") Long id ,@RequestParam("name") String name)
    {
        return roleService.editRole(id,name);
    }
    @DeleteMapping("/remove-role/{id}")
    public List<RoleResult> deleteRole(@PathVariable("id") Long id){
        return roleService.deleteRoleById(id);}
}
