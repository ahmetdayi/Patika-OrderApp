package com.ahmetdayi.patikaorderapp.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    private LocalDate createdDate;

    private String fullName;
}
