package com.company.entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/*
 * 🦋 Bidirectional Relationship
 *
 * @OneToOne(mappedBy = "department")
 * · We would like to bring employee detail whenever we needed from the department object but Department Table is NOT
 *   owner in this relationship. Owner is Employee table. When we annotate the "private Employee employee;" field only
 *   with @OneToOne() annotation it will create employee field (column) in the department table which will be the foreign key.
 *   We don't want to create employee foreign key column in the Department Table. To prevent that we use the (mappedBy = "department"),
 *   with the @OneToOne() annotation.
 * · (mappedBy = "department") will map the employee field to the department reference that we have in the Employee class.
 *   In this way, the employee column will NOT be created on the department table, and we will still be able to reach the
 *   employee fields when we call it with employee.getDepartment.
 *
 *
 */
@Entity
@Table(name = "departments")
@NoArgsConstructor
@Data
public class Department extends BaseEntity {

    private String department;
    private String division;

    @OneToOne(mappedBy = "department") // department name should match exactly the Department field we provided in Employee class
    private Employee employee;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
