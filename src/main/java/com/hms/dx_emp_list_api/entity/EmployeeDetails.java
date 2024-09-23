package com.hms.dx_emp_list_api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dx_employee")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class EmployeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long empId;

    @Column(name = "first_name")
    private String  firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "department")
    private String department;

    @Column(name = "phone_number")
    private Long phoneNumber;
}
