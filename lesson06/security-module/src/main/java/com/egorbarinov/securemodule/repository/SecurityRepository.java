package com.egorbarinov.securemodule.repository;

import com.egorbarinov.securemodule.entities.ClientImpl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityRepository extends JpaRepository<ClientImpl, Long> {
    ClientImpl findByName(String name);
}
