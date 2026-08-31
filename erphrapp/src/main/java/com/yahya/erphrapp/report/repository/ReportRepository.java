package com.yahya.erphrapp.report.repository;

import java.util.List;

public interface ReportRepository {

    List<Object[]> getEmployeeDirectory();

    List<Object[]> getHeadcountByDept();

    List<Object[]> getPayrollRegister(String periodCode);

    List<Object[]> getPayrollCostByDept(String periodCode);

    List<Object[]> getPayrollTrend();

    List<Object[]> getTaxInsuranceLiability();

    List<Object[]> getBankTransfer(String periodCode);

    List<Object[]> getLeaveBalances(int fiscalYear);

    List<Object[]> getLeaveRequestLog(String status);

    List<Object[]> getOvertimeTop10();

    List<Object[]> getAbsenceWatchlist();

    List<Object[]> getActiveLoans();

    List<Object[]> getContractsExpiring(int months);
}