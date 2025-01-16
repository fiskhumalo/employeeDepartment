package com.fiskhumalo.employeeManagement.model.employee;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fiskhumalo.employeeManagement.model.department.EmployeeDepartment;
import com.fiskhumalo.employeeManagement.model.employeeId.EmployeeIdCard;
import com.fiskhumalo.employeeManagement.model.manager.Manager;
import com.fiskhumalo.employeeManagement.model.schedule.Schedule;
import jakarta.persistence.*;


import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "Employee",
        uniqueConstraints = @UniqueConstraint(
                name = "employee_email_unique",
                columnNames = "email"
       ))
public class Employee {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "employee_sequence"
    )
    @Column(
            name = "id"
    )
    private Long Id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private  String name;
    @Column(
            name = "surname",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private  String surname;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private  String email;

    @Column(
            name = "isPermanent"
    )
    private  boolean isPermanent;

    @Column(
            name = "age"
    )
    private  int age;

    @Column(
            name = "occupation",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private  String occupation;
    @Column(
            name = "salary",
            nullable = false,
            columnDefinition = "TEXT"

    )
    private  BigDecimal salary;

    @OneToOne(
            mappedBy = "employee",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST,
                    CascadeType.REMOVE}
    )
    @JsonManagedReference
      private EmployeeIdCard employeeId;


    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "manager_id",
            referencedColumnName = "managerId",
            foreignKey = @ForeignKey(name = "manager_id_fk")
    )
    @JsonManagedReference
    private Manager manager;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)

    @JoinColumn(
            name = "schedule_id",
            referencedColumnName = "scheduleId",
            foreignKey = @ForeignKey(name = "schedule_id_fk")
    )
    @JsonManagedReference
    private Schedule schedules;

    public Employee(String name, String surname, String email, boolean isPermanent, int age, String occupation, BigDecimal salary, EmployeeIdCard employeeId, Manager manager, Schedule schedules) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.isPermanent = isPermanent;
        this.age = age;
        this.occupation = occupation;
        this.salary = salary;
        this.employeeId = employeeId;
        this.manager = manager;
        this.schedules = schedules;
    }

    public Employee(String name, String surname, String email, boolean isPermanent, int age, String occupation, BigDecimal salary, EmployeeIdCard employeeId, Manager manager) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.isPermanent = isPermanent;
        this.age = age;
        this.occupation = occupation;
        this.salary = salary;
        this.employeeId = employeeId;
        this.manager = manager;
    }

    public Employee(String name, String surname, String email, boolean isPermanent, int age, String occupation, BigDecimal salary, EmployeeIdCard employeeId) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.isPermanent = isPermanent;
        this.age = age;
        this.occupation = occupation;
        this.salary = salary;
        this.employeeId = employeeId;
    }

    public Employee(String name, String surname, String email, boolean isPermanent, int age, String occupation, BigDecimal salary) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.isPermanent = isPermanent;
        this.age = age;
        this.occupation = occupation;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", isPermanent=" + isPermanent +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                ", salary=" + salary +
                "\n, manager=" + manager +
                "\n}";
    }

    public BigDecimal getSalary() {
        return salary.add(new BigDecimal(1300));

    }

 
    }

