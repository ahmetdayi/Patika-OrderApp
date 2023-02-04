package com.ahmetdayi.patikaorderapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String sector;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE,mappedBy = "company")
    private List<Bill> bills;

    public Company(String sector) {
        this.sector = sector;
    }
}
