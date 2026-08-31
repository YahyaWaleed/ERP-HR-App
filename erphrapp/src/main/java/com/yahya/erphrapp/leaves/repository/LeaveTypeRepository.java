package com.yahya.erphrapp.leaves.repository;

import com.yahya.erphrapp.leaves.entity.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveTypeRepository extends JpaRepository<LeaveType, Long> {
}