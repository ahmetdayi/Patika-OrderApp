package com.ahmetdayi.patikaorderapp.service;

import com.ahmetdayi.patikaorderapp.entity.Bill;
import com.ahmetdayi.patikaorderapp.entity.converter.BillConverter;
import com.ahmetdayi.patikaorderapp.entity.request.CreateBillRequest;
import com.ahmetdayi.patikaorderapp.entity.response.BillResponse;
import com.ahmetdayi.patikaorderapp.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository billRepository;

    private final CompanyService companyService;

    private final UserService userService;

    private final BillConverter billConverter;


    public BillResponse create(CreateBillRequest request){
        Bill bill = new Bill
                (
                        request.getPrice(),
                        request.getCreatedDate(),
                        userService.findById(request.getUserId()),
                        companyService.findById(request.getCompanyId())
                );
        return billConverter.convert(billRepository.save(bill));
    }

    public List<BillResponse> findAll(){
        return billConverter.convert(billRepository.findAll());
    }

    public List<BillResponse> filterByPriceBiggerThan1500(){
        return findAll().stream().filter(bill -> bill.getPrice()>1500).toList();
    }

    public Double averagePriceBiggerThan1500(){
        return filterByPriceBiggerThan1500().stream().mapToDouble(BillResponse::getPrice).average().orElseThrow();
    }



}
