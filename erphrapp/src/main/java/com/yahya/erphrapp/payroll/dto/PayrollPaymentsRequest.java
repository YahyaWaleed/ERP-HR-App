package com.yahya.erphrapp.payroll.dto;

import com.yahya.erphrapp.payroll.entity.PayrollPayments;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public class PayrollPaymentsRequest {

    @NotNull
    private long payslipId;

    @NotNull
    private String  method;

   @NotBlank
    private String bankName;

   @NotBlank
    private String bankAccount;

    @NotNull
    @Positive
    private double amount;

    @NotNull
    private LocalDateTime paidOn;

    @NotBlank
    private String reference;

    public long getPayslipId() {
        return payslipId;
    }

    public void setPayslipId(long payslipId) {
        this.payslipId = payslipId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaidOn() {
        return paidOn;
    }

    public void setPaidOn(LocalDateTime paidOn) {
        this.paidOn = paidOn;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
