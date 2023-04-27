package com.company.entity;
import com.company.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

/*
 * · ORM(Object Relational Mapping). Converting class to the table.
 *
 * · Table Creation: @Entity
 *    · Entities in JPA are nothing but POJOs representing data that can be persisted to the databaseEntities in JPA are
 *      nothing but POJOs representing data that can be persisted to the database
 *    · An entity represents a table stored in a database
 *    · Every instance of an entity represents a row in the table
 *    · Entity classes must not be declared final (It should be able to extended)
 *
 * · @Entity : Spring will create a table
 * · @Id : Define the field as a primary key
 * · @GeneratedValue(strategy = GenerationType.IDENTITY) : Postgres will generate ID automatically and assign it to primary key
 * · @Table(name = "") : Modifies the table name
 * · @Column(name = "") : Modifies the column name
 * · @Transient : annotated field will be excluded from the table
 * · @Column(columnDefinition = "DATE")
 * · @Column(columnDefinition = "TIME")
 * · @Column(columnDefinition = "TIMESTAMP")
 * · @Enumerated(EnumType.STRING) : It will modify the Enum field and convert it to varchar. (Default enum field will be integer 0,1...)
 *
 * · @MappedSuperclass : Table will NOT be created from this class, it will be inherited by other classes
 *
 *
 *
 *
 *
 * · Class Name == Table Name  · Fields Name == Column Name  · Object == Row
 *
 *
 */
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studentFirstName")
    private String firstName;
    @Column(name = "studentLastName")
    private String lastName;
    private String email;

    @Transient
    private String city;


    @Column(columnDefinition = "DATE")
    private LocalDate birthDate;
    @Column(columnDefinition = "TIME")
    private LocalTime birthTime;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate birthDateTime;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
