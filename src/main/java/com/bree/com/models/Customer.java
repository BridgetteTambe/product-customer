package com.bree.com.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Getter
@Setter

@Entity
@Table(name = "customer")
public class Customer extends Person  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "password", unique = true)
    private String password;

    @OneToOne(cascade ={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    private Address address;

    @OneToMany
    private Set<Order> order;

//    what is the purpose of this
    @OneToOne(cascade ={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    private Cart cart;

}
