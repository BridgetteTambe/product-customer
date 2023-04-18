package com.bree.com.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@MappedSuperclass
public abstract class Person {

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;


}
