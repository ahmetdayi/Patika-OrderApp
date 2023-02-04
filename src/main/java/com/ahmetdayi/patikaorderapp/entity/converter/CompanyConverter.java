package com.ahmetdayi.patikaorderapp.entity.converter;

import com.ahmetdayi.patikaorderapp.entity.Company;
import com.ahmetdayi.patikaorderapp.entity.response.CompanyResponse;
import org.springframework.stereotype.Component;

@Component
public class CompanyConverter {

    public CompanyResponse convert(Company from){
        return new CompanyResponse
                (
                        from.getId(),
                        from.getSector()
                );
    }
}
