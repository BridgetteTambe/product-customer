package com.bree.com.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@Table(name = "status")
public class Status {
    //public static final String SEQUENCE_NAME = "status";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

}
