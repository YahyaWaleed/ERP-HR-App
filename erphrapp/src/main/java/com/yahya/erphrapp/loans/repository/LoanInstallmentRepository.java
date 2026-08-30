package com.yahya.erphrapp.loans.repository;

import com.yahya.erphrapp.loans.entity.LoanInstallment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanInstallmentRepository extends JpaRepository<LoanInstallment, Long> {
}
