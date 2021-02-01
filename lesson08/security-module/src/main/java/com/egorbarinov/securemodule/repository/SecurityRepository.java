package com.egorbarinov.securemodule.repository;

import com.egorbarinov.securemodule.entities.ClientImpl;
import com.egorbarinov.securemodule.entities.ClientStatus;
import com.fasterxml.jackson.databind.util.EnumValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SecurityRepository extends JpaRepository<ClientImpl, Long> {
    ClientImpl findByName(String name);
    ClientImpl findByPassportId(String serial);
    boolean existsByPassportId(String serial);
    @Modifying
    @Query("update ClientImpl c set c.isCheckForDebts = ?1, c.checkNDFL = ?2, c.isNotCriminal= ?3, c.status = ?4 where c.passportId= ?5")
    void setClientImplInfoByPassportId(boolean isCheckForDebts, boolean isCheckNDFL, boolean isNotCriminal, ClientStatus status, String serial);


}
