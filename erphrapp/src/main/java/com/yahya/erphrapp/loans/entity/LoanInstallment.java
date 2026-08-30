package com.yahya.erphrapp.loans.entity;

import com.yahya.erphrapp.employee.entity.Employee;
import com.yahya.erphrapp.payroll.entity.Payslip;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "loan_installments")
public class LoanInstallment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inst_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loan_id", nullable = false)
    private Loan loan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payslip_id", nullable = false)
    private Payslip payslip;

    @Column(name = "period_code")
    private String periodCode;

    @Column(name = "amount")
    private double amount;

    @Column(name = "paid_on")
    private LocalDateTime paidOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Payslip getPayslip() {
        return payslip;
    }

    public void setPayslip(Payslip payslip) {
        this.payslip = payslip;
    }

    public String getPeriodCode() {
        return periodCode;
    }

    public void setPeriodCode(String periodCode) {
        this.periodCode = periodCode;
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
}
