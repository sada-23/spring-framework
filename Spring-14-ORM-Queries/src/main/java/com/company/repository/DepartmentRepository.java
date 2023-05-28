package com.company.repository;

import com.company.entity.Department;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,String> {

    //Display all Departments in the furniture department
    List<Department> findByDepartment(String department);

    //Display all Departments in the Health Division
    List<Department> findByDivisionIs(String division);

    List<Department> findByDivisionEquals(String division);

    //Display top 3 departments with division name includes 'Hea', without duplicates
    List<Department> findDistinctTop3ByDivisionContains(String pattern);


    @Query("SELECT d FROM Department d WHERE d.division IN ?1")
    List<Department> getDepartmentDivision(List<String> division);



    List<Department> readDepartmentByDivision(String division); // query for this method is on the "jpa-named-queries.properties" file
    @Query(nativeQuery = true)
    List<Department> retrieveDepartmentByDivisionContain(String pattern);// query for this method is on the "jpa-named-queries.properties" file



}
