package com.company.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
 * · When we have (fetch = FetchType.LAZY) in the class, json will create one empty field in the class, To prevent that
 *   we use @JsonIgnoreProperties(value = "{hibernateLazyInitializer}", ignoreUnknown = true) annotation with the class.
 * · @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) : NOT show the data when retrieve it, show the data when post it
 *
 *
 *
 */

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_account")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"},ignoreUnknown = true)
public class User extends BaseEntity{

    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String username;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_details_id")
    @JsonManagedReference // is the forward part of reference – the one that gets serialized normally.
    private Account account;




}