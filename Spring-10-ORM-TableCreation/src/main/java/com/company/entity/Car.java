package com.company.entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
/*
 * · We don't create @AllArgsConstructor constructor because ID fields will be created by DB (Postgres)
 * · We will create Custom construct which ID will be excluded
 *
 */
@Entity
@Table(name = "cars")
@NoArgsConstructor
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String make;
    private String model;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }


}
