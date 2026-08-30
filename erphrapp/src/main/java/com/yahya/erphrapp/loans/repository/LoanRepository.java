package com.yahya.erphrapp.loans.repository;

import com.yahya.erphrapp.loans.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan,Long> {
}
