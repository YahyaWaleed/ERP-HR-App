package com.yahya.erphrapp.organization.dto;

import com.yahya.erphrapp.organization.entity.JobTitle;
import jakarta.validation.constraints.NotBlank;

public class JobTitleResponse {

    private Long id;

    private String code;

    private String titleEn;

    private String titleAr;

    public enum JobGrade {G1, G2, G3, G4, G5, G6, G7};
    private JobTitle.JobGrade jobGrade;

    private double minSalary;

    private double maxSalary;

    private boolean isManagerial;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getTitleAr() {
        return titleAr;
    }

    public void setTitleAr(String titleAr) {
        this.titleAr = titleAr;
    }

    public JobTitle.JobGrade getJobGrade() {
        return jobGrade;
    }

    public void setJobGrade(JobTitle.JobGrade jobGrade) {
        this.jobGrade = jobGrade;
    }

    public double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public boolean isManagerial() {
        return isManagerial;
    }

    public void setManagerial(boolean managerial) {
        isManagerial = managerial;
    }
}
