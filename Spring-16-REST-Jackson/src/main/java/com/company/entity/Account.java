package com.company.entity;
import com.company.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
 * · @JsonIgnore annotation to specify a method or field that should be ignored during serialization and deserialization processes
 * · @JsonIgnoreProperties(value = {"state", "postalCode"}, ignoreUnknown = true) : is used at class level to mark a property or list of properties to be ignored.
 * · ignoreUnknown = true : to ignore any unknown field.
 *    any property for which we don't have a corresponding field in the respective class will be ignored
 * · @JsonBackReference : is the back part of reference – it will be omitted from serialization.
 * · @JsonManagedReference : is the forward part of reference – the one that gets serialized normally.
 *
 */

@Entity
@Data
@NoArgsConstructor
@Table(name = "account_details ")
//@JsonIgnoreProperties(value = {"state", "postalCode"}, ignoreUnknown = true)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"},ignoreUnknown = true)
public class Account extends BaseEntity {

    private String name;
    @JsonIgnore
    private String address;
    private String country;
    private String state;
    private String city;
    private Integer age;
    @Column(name = "postal_code")
    private String postalCode;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    @OneToOne(mappedBy = "account")
    @JsonBackReference // user will be ignored
    private User user;


}
