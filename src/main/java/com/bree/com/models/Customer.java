package com.bree.com.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Data
@Getter
@Setter

@Entity
@Table(name = "customer")
public class Customer extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "position")
    private String position;
    @Column(name = "password")
    private String password;

    @OneToOne
    private Address address;

    @OneToMany
    private Set<Order> order;

}
