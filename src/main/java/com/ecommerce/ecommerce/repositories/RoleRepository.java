package com.ecommerce.ecommerce.repositories;

import com.ecommerce.ecommerce.model.AppRole;
import com.ecommerce.ecommerce.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);
}
