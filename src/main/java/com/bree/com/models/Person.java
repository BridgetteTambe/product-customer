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

    @Column(name = "id_number")
    private Long idNumber;
    @Column(name = "first_name")
    String firstName;



    @Column(name = "last_name")
    private String lastName;


    @Column(name = "email",unique = true)
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;


}
