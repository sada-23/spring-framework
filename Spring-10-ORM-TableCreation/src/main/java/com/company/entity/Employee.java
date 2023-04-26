package com.company.entity;
import javax.persistence.Entity;
import javax.persistence.Id;

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
 * · @Id annotated field will be a primary key
 *
 * · When we add @Entity annotation to the class, Spring will create a table and @Id annotated field will be primary key
 *
 */
@Entity
public class Employee {

    @Id
    private int id;
    private String name;



}
