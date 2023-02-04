package com.ahmetdayi.patikaorderapp.service;

import com.ahmetdayi.patikaorderapp.core.exception.CompanyNotFoundException;
import com.ahmetdayi.patikaorderapp.core.exception.constant.Constant;
import com.ahmetdayi.patikaorderapp.entity.Company;
import com.ahmetdayi.patikaorderapp.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    protected Company findById(UUID id){
        return companyRepository.findById(id).orElseThrow(()-> new CompanyNotFoundException(Constant.COMPANY_NOT_FOUND));
    }
}
