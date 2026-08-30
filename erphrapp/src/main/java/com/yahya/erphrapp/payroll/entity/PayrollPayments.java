package com.yahya.erphrapp.payroll.entity;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "payroll_payments")
public class PayrollPayments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    @Column(name = "payslip_id")
    private Long payslipId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payslip_id", nullable = false, unique = true)
    private Payslip payslip;

    public enum PaymentMethod {
        BANK, CASH, CHEQUE
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "method", nullable = false)
    private PaymentMethod method;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_account")
    private String bankAccount;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "paid_on", nullable = false)
    private LocalDateTime paidOn;

    @Column(name = "reference")
    private String reference;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPayslipId() {
        return payslipId;
    }

    public void setPayslipId(Long payslipId) {
        this.payslipId = payslipId;
    }

    public Payslip getPayslip() {
        return payslip;
    }

    public void setPayslip(Payslip payslip) {
        this.payslip = payslip;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
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
