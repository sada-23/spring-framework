package com.company.model;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/*
 *
 *
 * @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY) :
 *    "fetch = FetchType.LAZY" will prevent hibernate bring all the info from the respective table, It will only bring the ID
 *    "fetch = FetchType.EAGER" is default, and it will bring all the info from the respective table. This might cause performance issue
 *
 */

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String name;
    private String surName;
    private String email;
    private String address;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Payment> paymentList;

    public Customer(String userName, String name, String surName, String email, String address) {
        this.userName = userName;
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.address = address;
    }
}
