package com.fiskhumalo.employeeManagement;

import com.fiskhumalo.employeeManagement.model.employee.Employee;
import com.fiskhumalo.employeeManagement.model.employeeId.EmployeeIdCard;
import com.fiskhumalo.employeeManagement.model.manager.Manager;
import com.fiskhumalo.employeeManagement.model.schedule.Schedule;
import com.fiskhumalo.employeeManagement.repository.employeeIdCardRepo.EmployeeIdCardRepository;
import com.fiskhumalo.employeeManagement.repository.employeeRepository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static java.time.LocalDate.*;

@SpringBootApplication


public class EmployeeManagementApplication {

    private static final Logger log = LoggerFactory.getLogger(EmployeeManagementApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);

        log.info("Application started successfully");



    }

    @Bean
    CommandLineRunner lineRunner(EmployeeRepository employeeRepository, EmployeeIdCardRepository employeeIdCardRepository) {
        return args -> {
            EmployeeIdCard employeeIdCard1 = EmployeeIdCard.builder()
                    .employeeId(1L)
                    .expiryDate(LocalDate.of(2027, Month.JUNE, 5)).build();


            EmployeeIdCard employeeIdCard2 = EmployeeIdCard.builder()
                    .employeeId(2L)
                    .expiryDate(of(2025, Month.JULY, 20))
                    .build();

            EmployeeIdCard employeeIdCard3 = EmployeeIdCard.builder()
                    .employeeId(3L)
                    .expiryDate(of(2026, Month.JUNE, 10))
                    .build();

            EmployeeIdCard employeeIdCard4 = EmployeeIdCard.builder()
                    .employeeId(4L)
                    .expiryDate(of(2026, Month.FEBRUARY, 10))
                    .build();


            Employee thoko = new Employee(1L,
                    "Thoko",
                    "Sibanda",
                    "thok@fiskhumalo.com",
                    true,
                    34,
                    "Deli",
                    new BigDecimal(7500),

                    employeeIdCard1,
                    Manager.builder()
                            .managerId(7L)
                            .firstName("Tina")
                            .department("Deli Manager").build(),
                    Schedule.builder()
                            .scheduleId(1L)
                            .startTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 8, 0))
                            .endTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 16, 30)).build());


            Employee Lungi = new Employee(2L,
                    "Lungi",
                    "Shabalala",
                    "lungi@fiskhumalo.com",
                    true,
                    36,
                    "Deli",
                    new BigDecimal(6500),

                    employeeIdCard2,
                    Manager.builder()
                            .managerId(7L)
                            .firstName("Tina")
                            .department("Deli Manager").build(),

                    Schedule.builder()
                            .scheduleId(2L)
                            .startTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 8, 0))
                            .endTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 16, 30)).build());


            Employee Ayanda = new Employee(3L,
                    "Ayanda", "Sibanda", "ayanda@fiskhumalo.com", false, 22, "Deli", new BigDecimal(5500),
                    employeeIdCard3,
                    Manager.builder()
                            .managerId(7L)
                            .firstName("Tina")
                            .department("Deli Manager").build(), Schedule.builder()
                    .scheduleId(3L)
                    .startTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 8, 0))
                    .endTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 16, 30)).build());


            Employee Magret = new Employee(4L,
                    "Magret", "Nyoni", "mag@fiskhumalo.com", true, 44, "Waiters", new BigDecimal(2500),
                    employeeIdCard4,
                    Manager.builder()
                            .managerId(4L)
                            .firstName("Shepherd")
                            .department("Waiters Manager").build(), Schedule.builder()
                    .scheduleId(4L)
                    .startTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 8, 0))
                    .endTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 16, 30)).build());

            Employee Thabani = new Employee(5L,
                    "Thabani", "Dube", "thaban@fiskhumalo.com", true, 42, "Waiters", new BigDecimal(2500),
                    EmployeeIdCard.builder()
                            .employeeId(5L)
                            .expiryDate(of(2028, Month.JULY, 5))
                            .build(),
                    Manager.builder()
                            .managerId(4L)
                            .firstName("Shepherd")
                            .department("Waiters Manager").build(), Schedule.builder()
                    .scheduleId(5L)
                    .startTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 8, 0))
                    .endTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 16, 30)).build());

            Employee Phili = new Employee(6L,
                    "Phili", "Ndebele", "phili@fiskhumalo.com", false, 30, "Greek-section", new BigDecimal(6400),
                    EmployeeIdCard.builder()
                            .employeeId(6L)
                            .expiryDate(of(2027, Month.MARCH, 30))
                            .build(),
                    Manager.builder()
                            .managerId(8L)
                            .firstName("Netty")
                            .department("GreekSection Manager").build(), Schedule.builder()
                    .scheduleId(6L)
                    .startTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 8, 0))
                    .endTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 16, 30)).build());

            Employee Netty = new Employee(7L,
                    "Netty", "Ndlovu", "netty@fiskhumalo.com", true, 33, "Greek-section", new BigDecimal(6800),
                    EmployeeIdCard.builder()
                            .employeeId(7L)
                            .expiryDate(of(2027, Month.MAY, 31))
                            .build(),
                    Manager.builder()
                            .managerId(8L)
                            .firstName("Netty")
                            .department("GreekSection Manager").build(), Schedule.builder()
                    .scheduleId(7L)
                    .startTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 8, 0))
                    .endTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 16, 30)).build());

            Employee Lucky = new Employee(8L,
                    "Lucky", "Ncube", "lucky@fiskhumalo.com", true, 32, "Chef", new BigDecimal(7100),
                    EmployeeIdCard.builder()
                            .employeeId(8L)
                            .expiryDate(of(2025, Month.AUGUST, 10))
                            .build(),
                    Manager.builder()
                            .managerId(10L)
                            .firstName("David")
                            .department("Chef Manager").build(), Schedule.builder()
                    .scheduleId(8L)
                    .startTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 8, 0))
                    .endTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 16, 30)).build());

            Employee Crisman = new Employee(9L,
                    "Crisman", "Ncube", "cris@fiskhumalo.com", false, 35, "Chef", new BigDecimal(6900),
                    EmployeeIdCard.builder()
                            .employeeId(9L)
                            .expiryDate(of(2028, Month.DECEMBER, 20))
                            .build(),
                    Manager.builder()
                            .managerId(10L)
                            .firstName("David")
                            .department("Chef Manager").build(), Schedule.builder()
                    .scheduleId(9L)
                    .startTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 8, 0))
                    .endTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 16, 30)).build());

            Employee Maria = new Employee(10L,
                    "Maria", "Sibanda", "maria@fiskhumalo.com", true, 54, "Greek-Food", new BigDecimal(8500),
                    EmployeeIdCard.builder()
                            .employeeId(10L)
                            .expiryDate(of(2028, Month.JANUARY, 10)).build(),
                    Manager.builder()
                            .managerId(10L)
                            .firstName("David")
                            .department("Chef Manager").build(), Schedule.builder()
                    .scheduleId(10L)
                    .startTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 8, 0))
                    .endTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 16, 30)).build());

            Employee Toni = new Employee(11L,
                    "Toni", "Bestakos", "toni@fiskhumalo.com", true, 49, "Manager", new BigDecimal(13500),
                    EmployeeIdCard.builder().employeeId(11L)
                            .expiryDate(of(2029, Month.APRIL, 15))
                            .build(), Manager.builder()
                    .managerId(11L)
                    .firstName("Goerge")
                    .department("Oversee Manager")
                    .build(), Schedule.builder()
                    .scheduleId(11L)
                    .startTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 8, 0))
                    .endTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 16, 30)).build());


            Employee Shepherd = new Employee(12L,
                    "Shepherd", "Ndlovu", "shepered@fiskhumalo.com", false, 37, "Manager", new BigDecimal(9800),
                    EmployeeIdCard.builder()
                            .employeeId(12L)
                            .expiryDate(of(2026, Month.MAY, 10))
                            .build(),
                    Manager.builder()
                            .managerId(11L)
                            .firstName("Goerge")
                            .department("Oversee Manager")
                            .build(), Schedule.builder()
                    .scheduleId(12L)
                    .startTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 8, 0))
                    .endTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 16, 30)).build());


            Employee Sicelo = new Employee(13L,
                    "Sicelo", "Tshuma", "sicelo@fiskhumalo.com", false, 30, "Salads", new BigDecimal(6800),
                    EmployeeIdCard.builder()
                            .employeeId(13L)
                            .expiryDate(of(2029, Month.JUNE, 17))
                            .build(),
                    Manager.builder()
                            .managerId(13L)
                            .firstName("Virginia")
                            .department("Kitchen Manager")
                            .build(), Schedule.builder()
                    .scheduleId(13L)
                    .startTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 8, 0))
                    .endTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 16, 30)).build());

            Employee Virginia = new Employee(14L,
                    "Virginia", "Makadzi", "vig@fiskhumalo.com", true, 48, "Manager", new BigDecimal(10800),
                    EmployeeIdCard.builder()
                            .employeeId(14L)
                            .expiryDate(of(2030, Month.MARCH, 13))
                            .build(),
                    Manager.builder()
                            .managerId(11L)
                            .firstName("Toni")
                            .department("GeneralManager")
                            .build(), Schedule.builder()
                    .scheduleId(14L)
                    .startTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 8, 0))
                    .endTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 16, 30)).build());

            Employee Nkosi = new Employee(15L,
                    "Nkosi", "Ndlovu", "nkosi@fiskhumalo.com", true, 27, "Scallary", new BigDecimal(5800),
                    EmployeeIdCard.builder()
                            .employeeId(15L)
                            .expiryDate(of(2026, Month.JULY, 18))
                            .build(),
                    Manager.builder()
                            .managerId(15L)
                            .firstName("Edd")
                            .department("Kitchen Manager")
                            .build(), Schedule.builder()
                    .scheduleId(15L)
                    .startTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 8, 0))
                    .endTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 16, 30)).build());


            Employee Bongi = new Employee(16L,
                    "Bongi", "Sibanda", "bongi@fiskhumalo.com", true, 39, "Bakery", new BigDecimal(8800),
                    EmployeeIdCard.builder()
                            .employeeId(16L)
                            .expiryDate(of(2027, Month.DECEMBER, 28))
                            .build()
                    , Manager.builder()
                    .managerId(15L)
                    .firstName("Edd")
                    .department("Kitchen Manager")
                    .build(),
                    Schedule.builder()
                            .scheduleId(15L)
                            .startTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 8, 0))
                            .endTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 16, 30)).build());


            Employee Ciphers = new Employee(17L,
                    "Ciphers", "Sibanda", "ciphers@fiskhumalo.com", false, 57, "Bakery", new BigDecimal(9800),

                    EmployeeIdCard.builder()
                            .employeeId(17L)
                            .expiryDate(of(2026, Month.JUNE, 5))
                            .build()
                    , Manager.builder()
                    .managerId(15L)
                    .firstName("Edd")
                    .department("Kitchen Manager")
                    .build(),
                    Schedule.builder()
                    .scheduleId(16L)
                    .startTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 8, 0))
                    .endTime(LocalDateTime.of(2024, Month.DECEMBER, 4, 16, 30)).build());


//            System.out.println(List.of(thoko, Lungi, Ayanda, Magret, Thabani,
//                    Phili, Netty, Lucky, Crisman, Maria,
//                    Toni, Shepherd, Sicelo, Virginia, Nkosi,
//                    Bongi, Ciphers));


            List<Employee> employees = List.of(
                    thoko, Lungi, Ayanda, Magret, Thabani,
                    Phili, Netty, Lucky, Crisman, Maria,
                    Toni, Shepherd, Sicelo, Virginia, Nkosi,
                    Bongi, Ciphers);


            try {
                employeeRepository.saveAll(employees);
//                System.out.println(List.of(
//                        thoko, Lungi, Ayanda, Magret, Thabani,
//                        Phili, Netty, Lucky, Crisman, Maria,
//                        Toni, Shepherd, Sicelo, Virginia, Nkosi,
//                        Bongi, Ciphers));

            } catch (DataIntegrityViolationException dataIntegrityViolationException) {

               dataIntegrityViolationException.getCause();
                System.out.println("email address already in use");

            }
        };


    }
}
//
//			employeeRepository.saveAll(List.of(thoko, Lungi, Ayanda, Magret,
//					Thabani, Phili, Netty, Lucky, Crisman, Maria, Toni,
//					Shepherd, Sicelo, Virginia, Nkosi, Bongi, Ciphers));
//
//
//			};


//		Faker faker = new Faker();
//
//			for (int i = 0; i <=50; i++) {
//				String firstName = faker.name().firstName();
//				String lastName = faker.name().lastName();
//				String email = String.format("%s@fiskhumalo.com", firstName);
//				boolean bool = faker.bool().bool();
//				int age = faker.number().numberBetween(18, 50);
//				String occupation = faker.name().title();
//				double numberBetween = faker.number().numberBetween((int) 6000.00, (int) 25000.00);
//				BigDecimal salary = BigDecimal.valueOf(numberBetween);
//
//
//

//			Employee employee = new Employee(
//						firstName,
//						lastName,
//						email,
//						bool,
//						age,
//						occupation,
//						salary








