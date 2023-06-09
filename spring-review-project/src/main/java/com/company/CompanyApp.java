package com.company;

import com.company.config.EmployeeConfig;
import com.company.repository.HoursRepository;
import com.company.service.OvertimeSalaryService;
import com.company.service.SalaryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CompanyApp {
    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);

        SalaryService salaryService = context.getBean(SalaryService.class);
        salaryService.calculateRegularSalary();

        OvertimeSalaryService overtimeSalaryService = context.getBean(OvertimeSalaryService.class);
        overtimeSalaryService.calculateOvertimeSalary();






    }
}