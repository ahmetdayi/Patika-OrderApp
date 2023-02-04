package com.ahmetdayi.patikaorderapp.entity;

import jakarta.persistence.*;
import lombok.*;
//import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
//import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

//    @CreatedDate
//    private Date createdTime;

    private LocalDate createdDate;

    private String fullName;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE,mappedBy = "user")
    private List<Bill> bills;

    public User(LocalDate createdDate, String fullName) {
        this.createdDate = createdDate;
        this.fullName = fullName;
    }
}
