package com.company.service;

import com.company.repository.EmployeeRepository;
import com.company.repository.HoursRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SalaryService {

    HoursRepository hoursRepository;
    EmployeeRepository employeeRepository;


    public SalaryService(@Qualifier("OH") HoursRepository hoursRepository, EmployeeRepository employeeRepository) {
        this.hoursRepository = hoursRepository;
        this.employeeRepository = employeeRepository;
    }

    public void calculateRegularSalary(){
        System.out.println((employeeRepository.getHourlyRate() * hoursRepository.getHours()));
    }
}
