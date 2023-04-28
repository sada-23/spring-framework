package com.company.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

/*
 *
 * · many-to-many relationship: we can pick which table will have the ownership
 * · @ManyToMany(mappedBy = "itemList") : here the ownership will belong to items table
 *
 *
 */

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;

    @ManyToMany(mappedBy = "itemList") // the ownership will belong to items table
    private List<Cart> cart;


    public Item(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
