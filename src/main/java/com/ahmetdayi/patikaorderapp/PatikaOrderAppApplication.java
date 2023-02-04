package com.ahmetdayi.patikaorderapp;

import com.ahmetdayi.patikaorderapp.entity.request.CreateBillRequest;
import com.ahmetdayi.patikaorderapp.entity.request.CreateUserRequest;
import com.ahmetdayi.patikaorderapp.service.BillService;
import com.ahmetdayi.patikaorderapp.service.CompanyService;
import com.ahmetdayi.patikaorderapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;


@SpringBootApplication
@RequiredArgsConstructor
public class PatikaOrderAppApplication implements CommandLineRunner {

    private final UserService userService;

    private final CompanyService companyService;

    private final BillService billService;


    public static void main(String[] args) {
        SpringApplication.run(PatikaOrderAppApplication.class, args);
    }

    @Override
    public void run(String... args)  {

        System.out.println();
        System.out.println();
        System.out.println("Users are Created");
        System.out.println();

        CreateUserRequest createUserRequest = new CreateUserRequest
                (
                        LocalDate.of(
                                2023,
                                6,
                                12
                        ),
                        "Ahmet Can"
                );
        System.out.println(userService.create(createUserRequest).toString());
        CreateUserRequest createUserRequest1 = new CreateUserRequest
                (
                        LocalDate.of(
                                2023,
                                6,
                                13
                        ),
                        "Ceyda Sirar"
                );
        System.out.println(userService.create(createUserRequest1).toString());
        CreateUserRequest createUserRequest2 = new CreateUserRequest
                (
                        LocalDate.of(
                                2023,
                                6,
                                14
                        ),
                        "Canan Kaya"
                );
        System.out.println(userService.create(createUserRequest2).toString());
        CreateUserRequest createUserRequest3 = new CreateUserRequest
                (
                        LocalDate.of(
                                2023,
                                7,
                                12
                        ),
                        "Ahmet Dayi"
                );
        System.out.println(userService.create(createUserRequest3).toString());
        System.out.println();
        System.out.println("Users Created");
        System.out.println();

        System.out.println("Companies are Created");
        System.out.println();
        System.out.println(companyService.create("Food"));
        System.out.println(companyService.create("Technology"));
        System.out.println(companyService.create("Food"));
        System.out.println(companyService.create("Technology"));
        System.out.println(companyService.create("Food"));
        System.out.println();
        System.out.println("Companies Created");
        System.out.println();

        System.out.println("Bills are Created");
        System.out.println();
        CreateBillRequest createBillRequest = new CreateBillRequest
                (
                        1500,
                        LocalDate.of(2023,6,12),
                        userService.findAll().get(0).getId(),
                        companyService.findAll().get(0).getId()
                );
        System.out.println(billService.create(createBillRequest));

        CreateBillRequest createBillRequest1 = new CreateBillRequest
                (
                        1500,
                        LocalDate.of(2023,6,12),
                        userService.findAll().get(1).getId(),
                        companyService.findAll().get(1).getId()
                );
        System.out.println(billService.create(createBillRequest1));
        CreateBillRequest createBillRequest2= new CreateBillRequest
                (
                        1700,
                        LocalDate.of(2023,7,13),
                        userService.findAll().get(2).getId(),
                        companyService.findAll().get(2).getId()
                );
        System.out.println(billService.create(createBillRequest2));
        CreateBillRequest createBillRequest3 = new CreateBillRequest
                (
                        400,
                        LocalDate.of(2023,6,12),
                        userService.findAll().get(3).getId(),
                        companyService.findAll().get(3).getId()
                );
        System.out.println(billService.create(createBillRequest3));
        System.out.println();
        System.out.println("Bills Created");


        System.out.println("------------------------------------------------");
        System.out.println("Filter By Full Name Contains 'C' ");
        System.out.println();
        userService.filterByFullNameContainsLetter("C").forEach(System.out::println);
        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println("Total Amount Of Pill Of User Registered In June ");
        System.out.println();
        System.out.println( userService.totalAmountOfPillOfUserRegisteredIJune());
        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println("All Of Bills");
        billService.findAll().forEach(System.out::println);
        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println("Filter By Price Bigger Than 1500");
        billService.filterByPriceBiggerThan1500().forEach(System.out::println);
        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println("Filter User Name With Pill Under 500");
        userService.filterUserWithPillUnder500().forEach(System.out::println);
        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println("Filter Company Sector Average Pill Price Under 750");
        companyService.filterAveragePillPriceUnder750().forEach(System.out::println);
        System.out.println();
        System.out.println();



    }
}
