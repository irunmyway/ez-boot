package com.ezboot.system.role;

import com.ezboot.AdminApiApplicationTests;
import com.ezboot.system.admin.dto.AdminLoginDTO;
import com.ezboot.system.admin.service.AdminService;
import com.ezboot.system.role.entity.Role;
import com.ezboot.system.role.repository.RoleRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RoleRepositoryTest extends AdminApiApplicationTests {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AdminService adminService;

    @Before
    @Ignore
    public void login() {
        AdminLoginDTO adminLoginDTO = new AdminLoginDTO();
        adminLoginDTO.setUsername("admin");
        adminLoginDTO.setPassword("123456");
        adminService.login(adminLoginDTO);
    }

    @Test
    public void testSave() {
        Role role = new Role();
        role.setRoleName("开发");
        role.setDescription("developer");
        role.setEnabled(true);
        role.setCreateName("system");
        role.setUpdateName("system");

        roleRepository.save(role);
    }

    @Test
    public void testUpdate() {
        Optional<Role> byId = roleRepository.findById(2);
        Role role = byId.get();
        role.setEnabled(false);
        roleRepository.save(role);
    }

    @Test
    public void testGetRoleNameByAdminId() {
        List<String> roleNameListByAdminId = roleRepository.findRoleNameListByAdminId(2);
        Assert.assertNotNull(roleNameListByAdminId);
    }
}
