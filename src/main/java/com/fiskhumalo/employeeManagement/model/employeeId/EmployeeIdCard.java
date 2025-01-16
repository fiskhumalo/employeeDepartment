package com.fiskhumalo.employeeManagement.model.employeeId;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiskhumalo.employeeManagement.model.employee.Employee;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@ToString(exclude = "employee")


public class EmployeeIdCard {


    @Id
    @SequenceGenerator(
            name = "employeeId_sequence",
            sequenceName = "employeeId_sequence",
            allocationSize = 1
    )

    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                   generator = "employeeId_sequence")

    @Column(
            name = "employeeId"
    )
    private Long employeeId;

    @Column(
            name = "expiryDate",
            nullable = false
    )
    private LocalDate expiryDate;


    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER

    )

    @JoinColumn(name = "employee_id",
                referencedColumnName = "employeeId",
            foreignKey = @ForeignKey(name = "employee_id_fk")
    )
    @JsonBackReference
    private Employee employee;



    }

