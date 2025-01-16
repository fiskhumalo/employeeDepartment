package com.fiskhumalo.employeeManagement.model.manager;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fiskhumalo.employeeManagement.model.employee.Employee;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Manager {

    @Id
    @SequenceGenerator(
            name = "manager_sequence",
            sequenceName = "manager_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "manager_sequence"
    )


    @Column(
            name = "managerId",
            nullable = false,
            updatable = false
    )
    private Long managerId;


    @Column(
            name = "firstName",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "department",
            nullable = false
    )
    private String department;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )

    @JoinColumn(
            name = "manager_id",
            referencedColumnName = "managerId",
            foreignKey = @ForeignKey(name = "manager_id_fk")
    )
    @JsonBackReference
    private List<Employee> employees;

    public Manager(String firstName, String department, List<Employee> employees) {
        this.firstName = firstName;
        this.department = department;
        this.employees = employees;
    }

    public Manager(Long managerId, String firstName, String department) {
        this.managerId = managerId;
        this.firstName = firstName;
        this.department = department;
    }
}
