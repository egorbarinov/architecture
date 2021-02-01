package com.egorbarinov.creditingmodule.repository;

import com.egorbarinov.creditingmodule.entities.ConsumerLoan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumerLoanRepository extends JpaRepository<ConsumerLoan, Long> {
}
