package com.company.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/*
 * · Join Table : Table that will be created is a result of many-to-many relationships.
 * · @JoinTable(name = "cart_item_rel") : Change the join tale name
 *
 *
 */

@Entity
@Table(name = "carts")
@Data
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "cart_item_rel",
    joinColumns = @JoinColumn(name = "c_id"),
    inverseJoinColumns = @JoinColumn(name = "i_id"))
    private List<Item> itemList;



}
