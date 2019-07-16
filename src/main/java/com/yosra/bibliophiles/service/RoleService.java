package com.yosra.bibliophiles.service;

import com.yosra.bibliophiles.Repository.RoleRepository;
import com.yosra.bibliophiles.domain.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
