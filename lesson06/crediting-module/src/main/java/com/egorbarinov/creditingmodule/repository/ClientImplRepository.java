package com.egorbarinov.creditingmodule.repository;

import com.egorbarinov.creditingmodule.entities.ClientImpl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientImplRepository extends JpaRepository<ClientImpl, Long> {

}
