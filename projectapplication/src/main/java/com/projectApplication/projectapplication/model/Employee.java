package com.projectApplication.projectapplication.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "employees")
public class Employee {
    //@table annotation specifies the table in the database with which this entity is mapped.
    //Variables defined.
    //the @Column annotation is used to specify the various class id.
    //@Id annotation specifies the primary key of the entity.
    //@GeneratedValue annotation specifies the generation strategies for the values of the primary keys. it also sets a field to Auto Increment.
    //@GenerationType.Identity -used to set up an auto-increment
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "employee_first_name")
    private String employeeFirstName;

    @Column(name = "employee_last_name")
    private String employeeLastName;

    @Column(name = "employee_email_id")
    private String employeeEmailId;
}
