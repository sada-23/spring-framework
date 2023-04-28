package com.company.entity;

import com.company.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/*
 * 🦋 Object Relationship (Mapping)
 * · One-To-One relationship means one Employee can belong to one Department
 * · @OneToOne annotated field: Hibernate will join two tables by creating a column for the annotated field on the table and defining it as a foreign key.
 *      · The example below, a department column will be created on employees' table and will be defined as a foreign key.
 *        @OneToOne
 *        private Department department;
 *
 *
 * · @JoinColumn(name = "") annotation modifies joined column field name.
 *
 * · Cascading -> @OneToOne(cascade = CascadeType.ALL) :
 *      · Entity relationships often depend on the existence of another entity.
 *      · When we perform some action on the target entity, the same action will be applied to the associated entity
 *      · Different JPA Cascade Types: ALL, PERSIST, MERGE, REMOVE, REFRESH, DETACH
 *
 */

@Entity
@Table(name = "employees")
@NoArgsConstructor
@Data
public class Employee extends BaseEntity{

    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int salary;

    @OneToOne(cascade = CascadeType.ALL)
//    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    private Region region;


    public Employee(String firstName, String lastName, String email, LocalDate hireDate, int salary, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
        this.salary = salary;
        this.gender = gender;
    }
}
