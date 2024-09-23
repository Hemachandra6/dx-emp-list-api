package com.hms.dx_emp_list_api.repository;

import com.hms.dx_emp_list_api.entity.Role;
import com.hms.dx_emp_list_api.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
