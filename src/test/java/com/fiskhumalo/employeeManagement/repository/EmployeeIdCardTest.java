package com.fiskhumalo.employeeManagement.repository;

import com.fiskhumalo.employeeManagement.model.employeeId.EmployeeIdCard;
import com.fiskhumalo.employeeManagement.repository.employeeIdCardRepo.EmployeeIdCardRepository;
import com.fiskhumalo.employeeManagement.repository.employeeRepository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.LocalDate.of;

@SpringBootTest
public class EmployeeIdCardTest {

    @Autowired
    private EmployeeIdCardRepository employeeIdCardRepository;
    @Autowired
    private EmployeeRepository employeeRepository;



    @Test
    public void saveEmployeeId(){

//       EmployeeIdCard employeeIdCard = EmployeeIdCard.builder()
//                .employeeId(1L)
//                .expiryDate(LocalDate.of(2027, Month.JUNE,5)).build();
//
//
//        EmployeeIdCard employeeIdCard1 = EmployeeIdCard.builder()
//                .employeeId(2L)
//                .expiryDate(LocalDate.of(2027, Month.JUNE,5)).build();
//
//
//        EmployeeIdCard employeeIdCard2 = EmployeeIdCard.builder()
//                .employeeId(3L)
//                .expiryDate(of(2025, Month.JULY, 20))
//                .build();
//
//        EmployeeIdCard employeeIdCard3 = EmployeeIdCard.builder()
//                .employeeId(4L)
//                .expiryDate(of(2026, Month.JUNE, 10))
//                .build();
//
//        EmployeeIdCard employeeIdCard4 = EmployeeIdCard.builder()
//               .employeeId(5L)
//                .expiryDate(of(2026, Month.FEBRUARY, 10))
//                .build();
//
//
//
//        EmployeeIdCard employeeIdCard5 = EmployeeIdCard.builder()
//                .employeeId(6L)
//                .expiryDate(LocalDate.of(2028,Month.DECEMBER,5))
//                .build();
//
//        EmployeeIdCard employeeIdCard6 = EmployeeIdCard.builder()
//                .employeeId(7L)
//                .expiryDate(LocalDate.of(2027,Month.MARCH,25))
//                .build();
//
//
//        try{
//            employeeIdCardRepository.saveAll(List.of(
//                    employeeIdCard,employeeIdCard1,employeeIdCard2,employeeIdCard3,employeeIdCard4,employeeIdCard5,employeeIdCard6));
//        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
//            dataIntegrityViolationException.getCause();
//            System.out.println("no such id available");

//        EmployeeIdCard employeeIdCard1 = EmployeeIdCard.builder()
//                .employeeId(1L)
//                .expiryDate(LocalDate.of(2027, Month.JUNE,5)).build();
//
//
//        EmployeeIdCard employeeIdCard2 = EmployeeIdCard.builder()
//                .employeeId(2L)
//                .expiryDate(of(2025, Month.JULY, 20))
//                .build();
//
//        EmployeeIdCard employeeIdCard3 = EmployeeIdCard.builder()
//                .employeeId(3L)
//                .expiryDate(of(2026, Month.JUNE, 10))
//                .build();
//
//        EmployeeIdCard employeeIdCard4 = EmployeeIdCard.builder()
//                .employeeId(4L)
//                .expiryDate(of(2026, Month.FEBRUARY, 10))
//                .build();


//        Employee thoko = new Employee(17L,
//                "Thoko", "Sibanda", "thok@fiskhumalo.com", true, 34, "Deli", new BigDecimal(7500),
//                employeeIdCard1
//        );
//        Employee Lungi = new Employee(2L,
//                "Lungi", "Shabalala", "lungi@fiskhumalo.com", true, 36, "Deli", new BigDecimal(6500),
//                employeeIdCard2
//        );
//
//        Employee Ayanda = new Employee(3L,
//                "Ayanda", "Sibanda", "ayanda@fiskhumalo.com", false, 22, "Deli", new BigDecimal(5500),
//                employeeIdCard3
//        );
//
//        Employee Magret = new Employee(4L,
//                "Magret", "Nyoni", "mag@fiskhumalo.com", true, 44, "Waiters", new BigDecimal(2500),
//                employeeIdCard4
//        );
//        Employee Thabani = new Employee(5L,
//                "Thabani", "Dube", "thaban@fiskhumalo.com", true, 42, "Waiters", new BigDecimal(2500),
//                EmployeeIdCard.builder()
//                        .employeeId(5L)
//                        .expiryDate(of(2028, Month.JULY, 5))
//                        .build()
//        );
//        Employee Phili = new Employee(6L,
//                "Phili", "Ndebele", "phili@fiskhumalo.com", false, 30, "Greek-section", new BigDecimal(6400),
//                EmployeeIdCard.builder()
//                        .employeeId(6L)
//                        .expiryDate(of(2027, Month.MARCH, 30))
//                        .build()
//        );
//        Employee Netty = new Employee(7L,
//                "Netty", "Ndlovu", "netty@fiskhumalo.com", true, 33, "Greek-section", new BigDecimal(6800),
//                EmployeeIdCard.builder()
//                        .employeeId(7L)
//                        .expiryDate(of(2027, Month.MAY, 31))
//                        .build()
//        );
//        Employee Lucky = new Employee(8L,
//                "Lucky", "Ncube", "lucky@fiskhumalo.com", true, 32, "Chef", new BigDecimal(7100),
//                EmployeeIdCard.builder()
//                        .employeeId(8L)
//                        .expiryDate(of(2025, Month.AUGUST, 10)).build()
//        );
//        Employee Crisman = new Employee(9L,
//                "Crisman", "Ncube", "cris@fiskhumalo.com", false, 35, "Chef", new BigDecimal(6900),
//                EmployeeIdCard.builder()
//                        .employeeId(9L)
//                        .expiryDate(of(2028, Month.DECEMBER, 20))
//                        .build()
//        );
//        Employee Maria = new Employee(10L,
//                "Maria", "Sibanda", "maria@fiskhumalo.com", true, 54, "Greek-Food", new BigDecimal(8500),
//                EmployeeIdCard.builder()
//                        .employeeId(10L)
//                        .expiryDate(of(2028, Month.JANUARY, 10)).build()
//        );
//        Employee Toni = new Employee(11L,
//                "Toni", "Bestakos", "toni@fiskhumalo.com", true, 49, "Manager", new BigDecimal(13500),
//                EmployeeIdCard.builder().employeeId(11L)
//                        .expiryDate(of(2029, Month.APRIL, 15))
//                        .build()
//        );
//        Employee Shepherd = new Employee(12L,
//                "Shepherd", "Ndlovu", "shepered@fiskhumalo.com", false, 37, "Manager", new BigDecimal(9800),
//                EmployeeIdCard.builder()
//                        .employeeId(12L)
//                        .expiryDate(of(2026, Month.MAY, 10))
//                        .build()
//        );
//        Employee Sicelo = new Employee(13L,
//                "Sicelo", "Tshuma", "sicelo@fiskhumalo.com", false, 30, "Salads", new BigDecimal(6800),
//                EmployeeIdCard.builder()
//                        .employeeId(13L)
//                        .expiryDate(of(2029, Month.JUNE, 17))
//                        .build()
//        );
//        Employee Virginia = new Employee(14L,
//                "Virginia", "Makadzi", "vig@fiskhumalo.com", true, 48, "Manager", new BigDecimal(10800),
//                EmployeeIdCard.builder()
//                        .employeeId(14L)
//                        .expiryDate(of(2030, Month.MARCH, 13))
//                        .build()
//        );
//        Employee Nkosi = new Employee(15L,
//                "Nkosi", "Ndlovu", "nkosi@fiskhumalo.com", true, 27, "Scallary", new BigDecimal(5800),
//                EmployeeIdCard.builder()
//                        .employeeId(15L)
//                        .expiryDate(of(2026, Month.JULY, 18))
//                        .build()
//        );
//        Employee Bongi = new Employee(16L,
//                "Bongi", "Sibanda", "bongi@fiskhumalo.com", true, 39, "Bakery", new BigDecimal(8800),
//                EmployeeIdCard.builder()
//                        .employeeId(16L)
//                        .expiryDate(of(2027, Month.DECEMBER, 28))
//                        .build()
//        );
//
//
//        Employee Ciphers = new Employee(17L,
//                "Ciphers", "Sibanda", "ciphers@fiskhumalo.com", false, 57, "Bakery", new BigDecimal(9800),
//
//                EmployeeIdCard.builder()
//                        .employeeId(17L)
//                        .expiryDate(of(2026,Month.JUNE,5))
//                        .build()
//        );
//
//
//
//
//
//        List<Employee> employees = List.of(
//                thoko, Lungi, Ayanda, Magret, Thabani,
//                Phili, Netty, Lucky, Crisman, Maria,
//                Toni, Shepherd, Sicelo, Virginia, Nkosi,
//                Bongi, Ciphers);
//
//
//        try {
//            employeeRepository.saveAll(employees);
//
//        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
//            dataIntegrityViolationException.getCause();
//            System.out.println("email address already in use");
//
//        }
        }}

