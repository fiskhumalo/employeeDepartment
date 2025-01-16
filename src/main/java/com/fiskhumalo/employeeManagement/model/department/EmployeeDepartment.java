package com.fiskhumalo.employeeManagement.model.department;



import jakarta.persistence.*;
import lombok.*;



@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class EmployeeDepartment {


    @Id
    @SequenceGenerator(
            name = "department_name",
            sequenceName = "department_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "department_sequence"
    )


    @Column(
            name = "department_id",
            nullable = false
    )
    private Long departmentId;

    @Column(
            name = "department_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String departmentName;

    @Column(
            name = "is_experienced",
            nullable = false,
            columnDefinition = "boolean"
    )
    private boolean isExperienced;


}
