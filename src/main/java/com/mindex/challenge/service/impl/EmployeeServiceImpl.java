package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.exceptions.NotFoundException;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompensationRepository compensationRepository;

    @Override
    public Employee create(Employee employee) {
        LOG.debug("Creating employee [{}]", employee);
        employee.setEmployeeId(UUID.randomUUID().toString());
        employeeRepository.insert(employee);
        return employee;
    }

    @Override
    public Employee read(String id) {
        LOG.debug("Creating employee with id [{}]", id);
        Employee employee = employeeRepository.findByEmployeeId(id);
        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        LOG.debug("Updating employee [{}]", employee);
        return employeeRepository.save(employee);
    }



    @Override
    public ReportingStructure getReportingStructure(String id) {
        Employee employee = employeeRepository.findByEmployeeId(id);
        int countDirectReports = getDirectReportsCount(employee);
        return new ReportingStructure(employee, countDirectReports);
    }

    public int getDirectReportsCount(Employee employee) {
        if (employee.getDirectReports() == null) {
            return 0;
        }

        return employee.getDirectReports().size() +
                employee.getDirectReports().stream()
                        .mapToInt(this::getDirectReportsCount)
                        .sum();
    }

    @Override
    public Compensation createCompensation(Compensation compensation) {
        try {
            //Check if exists
            employeeRepository.findByEmployeeId(compensation.getEmployeeId());
        } catch(Exception e){
            LOG.error("Could not find employee in database [{}]", compensation.getEmployeeId());
            throw new ValidationException("Invalid employee id");
        }
        compensationRepository.insert(compensation);
        return compensation;
    }

    @Override
    public Compensation getCompensation(String employeeId){
        Compensation compensation =  compensationRepository.findByEmployeeId(employeeId);
        if(compensation == null){
            throw new NotFoundException("Could not find compensation for employee: " + employeeId);
        }
        return compensation;
    }




}
