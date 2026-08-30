package com.yahya.erphrapp.loans.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LoanInstallmentResponse {

    private long id;
    private long loanId;
    private long payslipId;
    private String periodCode;
    private BigDecimal amount;
    private LocalDateTime paidOn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
