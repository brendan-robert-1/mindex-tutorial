package com.mindex.challenge.data;

public class ReportingStructure {
    private Employee employee;
    private int numberOfReports;


    public ReportingStructure(Employee employee, int numberOfReports) {
        this.employee = employee;
        this.numberOfReports = numberOfReports;
    }

    public Employee getEmployee() {
        return employee;
    }



    public ReportingStructure setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }



    public int getNumberOfReports() {
        return numberOfReports;
    }



    public ReportingStructure setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
        return this;
    }
}
