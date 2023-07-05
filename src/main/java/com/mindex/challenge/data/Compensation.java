package com.mindex.challenge.data;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Compensation {
    private String employeeId;
    private BigDecimal salary;
    private LocalDate effectiveDate;


    public Compensation(String employeeId, BigDecimal salary, LocalDate effectiveDate) {
        this.employeeId = employeeId;
        this.salary = salary;
        this.effectiveDate = effectiveDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }



    public Compensation setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }



    public BigDecimal getSalary() {
        return salary;
    }



    public Compensation setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }



    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }



    public Compensation setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
        return this;
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Compensation{");
        sb.append("employeeId='").append(employeeId).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", effectiveDate=").append(effectiveDate);
        sb.append('}');
        return sb.toString();
    }
}
