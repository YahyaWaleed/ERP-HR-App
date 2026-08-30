package com.yahya.erphrapp.loans.dto;

import com.yahya.erphrapp.loans.entity.Loan;
import com.yahya.erphrapp.payroll.entity.Payslip;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LoanInstallmentRequest {

    private long loanId;
    private long payslipId;
    private String periodCode;
    private BigDecimal amount;
    private LocalDateTime paidOn;

    public long getLoanId() {
        return loanId;
    }

    public void setLoanId(long loanId) {
        this.loanId = loanId;
    }

    public long getPayslipId() {
        return payslipId;
    }

    public void setPayslipId(long payslipId) {
        this.payslipId = payslipId;
    }

    public String getPeriodCode() {
        return periodCode;
    }

    public void setPeriodCode(String periodCode) {
        this.periodCode = periodCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaidOn() {
        return paidOn;
    }

    public void setPaidOn(LocalDateTime paidOn) {
        this.paidOn = paidOn;
    }
}
