package com.fiskhumalo.employeeManagement.model.schedule;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fiskhumalo.employeeManagement.model.employee.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder


    public class Schedule {
        @Id
        @SequenceGenerator(
                name = "schedule_sequence",
                sequenceName = "schedule_sequence",
                allocationSize = 1
        )

        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "schedule_sequence"
        )

        @Column(
                name = "scheduleId",
                nullable = false,
                updatable = false
        )
        private Long scheduleId;

    @Column(
            name = "startTime",
            nullable = false
    )
        private LocalDateTime startTime;

    @Column(
            name = "endTime",
            nullable = false
    )
        private LocalDateTime endTime;

        @OneToMany(
                cascade = CascadeType.ALL,
                fetch = FetchType.LAZY)

        @JoinColumn(name = "schedule_id",
                referencedColumnName = "scheduleId",
                foreignKey = @ForeignKey(name = "schedule_id_fk"))

        @JsonBackReference
        private List<Employee> employeeSchedule;



}
