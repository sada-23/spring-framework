package com.company.service;

import com.company.repository.EmployeeRepository;
import com.company.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OvertimeSalaryService {


    HoursRepository hoursRepository;
    EmployeeRepository employeeRepository;


    public OvertimeSalaryService(@Qualifier("OH") HoursRepository hoursRepository, EmployeeRepository employeeRepository) {
        this.hoursRepository = hoursRepository;
        this.employeeRepository = employeeRepository;
    }

    public void calculateOvertimeSalary(){
        System.out.println(hoursRepository.getHours());
    }
}
