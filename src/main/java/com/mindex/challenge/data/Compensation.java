package com.mindex.challenge.data;

import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

public class Compensation {

    @DBRef(lazy = true)
    private Employee employee;
    private BigDecimal salary;
    private Instant effectiveDate;

    // Default constructor
    public Compensation() {
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        if (salary.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Salary must be non-negative");
        }
        this.salary = salary;
    }

    public Instant getEffectiveDate() {
        return this.effectiveDate;
    }

    public void setEffectiveDate(Instant effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Compensation employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public Compensation salary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public Compensation effectiveDate(Instant effectiveDate) {
        this.effectiveDate = effectiveDate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Compensation)) {
            return false;
        }
        Compensation compensation = (Compensation) o;
        return Objects.equals(employee, compensation.employee) &&
                Objects.equals(salary, compensation.salary) &&
                Objects.equals(effectiveDate, compensation.effectiveDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, salary, effectiveDate);
    }

    @Override
    public String toString() {
        return "{" +
                " employee='" + getEmployee() + "'" +
                ", salary='" + getSalary() + "'" +
                ", effectiveDate='" + getEffectiveDate() + "'" +
                "}";
    }

    // Builder pattern
    public static class Builder {
        private Compensation compensation = new Compensation();

        public Builder employee(Employee employee) {
            compensation.setEmployee(employee);
            return this;
        }

        public Builder salary(BigDecimal salary) {
            compensation.setSalary(salary);
            return this;
        }

        public Builder effectiveDate(Instant effectiveDate) {
            compensation.setEffectiveDate(effectiveDate);
            return this;
        }

        public Compensation build() {
            return compensation;
        }
    }
}
