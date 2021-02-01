package com.egorbarinov.creditingmodule.repository;

import com.egorbarinov.creditingmodule.entities.ClientImpl;
import com.egorbarinov.creditingmodule.entities.ClientStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ClientImplRepository extends JpaRepository<ClientImpl, Long> {

    boolean existsByPassportId(String passportId);
    @Modifying
    @Query("update ClientImpl c set c.isCheckForDebts = ?1, c.isCheckNDFL = ?2, c.isNotCriminal= ?3, c.status = ?4 where c.passportId= ?5")
    void setClientImplInfoByPassportId(boolean isCheckForDebts, boolean isCheckNDFL, boolean isNotCriminal, ClientStatus status, String serial);
}
