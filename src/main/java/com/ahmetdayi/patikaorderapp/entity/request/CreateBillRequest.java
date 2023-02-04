package com.ahmetdayi.patikaorderapp.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBillRequest {

    private double price;

    private LocalDate createdDate;

    private UUID userId;

    private UUID companyId;
}
