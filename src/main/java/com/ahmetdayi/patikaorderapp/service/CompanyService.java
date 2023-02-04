package com.ahmetdayi.patikaorderapp.service;

import com.ahmetdayi.patikaorderapp.core.exception.CompanyNotFoundException;
import com.ahmetdayi.patikaorderapp.core.exception.constant.Constant;
import com.ahmetdayi.patikaorderapp.entity.Bill;
import com.ahmetdayi.patikaorderapp.entity.Company;
import com.ahmetdayi.patikaorderapp.entity.converter.CompanyConverter;
import com.ahmetdayi.patikaorderapp.entity.response.CompanyResponse;
import com.ahmetdayi.patikaorderapp.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    private final CompanyConverter companyConverter;

    public CompanyResponse create(String sector){
        Company company = new Company(sector);
        return companyConverter.convert(companyRepository.save(company));
    }
    public List<String> filterAveragePillPriceUnder750(){
        List<Company> companies2 = companyRepository.findAll().stream().filter(company -> company.getBills().size() != 0).toList();
        List<Company> companiesDontHaveBill = companyRepository.findAll().stream().filter(company -> company.getBills().size() == 0).toList();
        List<Company> companies = companies2.stream().filter(company -> company.getBills().stream().mapToDouble(Bill::getPrice).average().orElseThrow() < 750).toList();
        List<Company> companies1 = companies.stream().filter(company -> company.getBills().stream().filter(bill -> bill.getCreatedDate().getMonthValue() <6).isParallel()).toList();
        List<Company> company = new ArrayList<>(companiesDontHaveBill);
        company.addAll(companies1);
        return company.stream().map(Company::getSector).toList();
    }

    protected Company findById(UUID id){
        return companyRepository.findById(id).orElseThrow(()-> new CompanyNotFoundException(Constant.COMPANY_NOT_FOUND));
    }

    public List<CompanyResponse> findAll(){
        return companyConverter.convert(companyRepository.findAll());
    }
}
