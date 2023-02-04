package com.ahmetdayi.patikaorderapp.entity;

import jakarta.persistence.*;
import lombok.*;
//import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

//import java.util.Date;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private double price;

//    @CreatedDate aslında bu şekilde yapılabılır ama kendım zaman belırleyebılmek adına degıstırıyorum
//    private Date createdDate;

    private LocalDate createdDate;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn
    private Company company;

    public Bill(double price, LocalDate createdDate, User user, Company company) {
        this.price = price;
        this.createdDate = createdDate;
        this.user = user;
        this.company = company;
    }
}
