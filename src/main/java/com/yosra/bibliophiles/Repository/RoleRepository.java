package com.yosra.bibliophiles.Repository;

import com.yosra.bibliophiles.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
