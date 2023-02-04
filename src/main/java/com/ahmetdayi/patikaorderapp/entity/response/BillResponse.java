package com.ahmetdayi.patikaorderapp.entity.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillResponse {

    private UUID id;

    private double price;

    private LocalDate createdDate;

    private UserResponse user;

    private CompanyResponse company;
}
