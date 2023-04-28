package com.company.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@Data
public class Department extends BaseEntity {

    private String department;
    private String division;

    /*
     * · Bidirectional Relationship
     * · When we say employee.getDepartment, Hibernate will go to the table and, based on the foreign key, it will bring
     *   the corresponding department for us.
     *
     * · When we annotate the "private Employee employee;" field with @OneToOne() annotation it will create employee
     *   field (column) in the department table which is the foreign key.
     *
     * · We would like to bring employee detail whenever we needed from the department object but Department Table is not
     *   owner in this relationship. Owner is Employee table. So we have to use mappedBy = "department".
     *  · We don't want to create foreign key column in the Department Table. If we don't provide mappedBy = "department",
     *    it will create Employee ID column
     *
     * · @OneToOne(mappedBy = "department") :
     *     · (mappedBy = "department") will map the employee field to the department field we have on Employee class.
     *
     */

    @OneToOne(mappedBy = "department") // department name should match exactly the Department field we provided in Employee class
    private Employee employee;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
