package com.ahmetdayi.patikaorderapp.entity.converter;

import com.ahmetdayi.patikaorderapp.entity.Company;
import com.ahmetdayi.patikaorderapp.entity.response.CompanyResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyConverter {

    public CompanyResponse convert(Company from) {
        return new CompanyResponse
                (
                        from.getId(),
                        from.getSector()
                );
    }

    public List<CompanyResponse> convert(List<Company> fromList) {
        if (fromList == null) {
            return null;
        }
        return fromList.stream().map(from -> new CompanyResponse(
                from.getId(),
                from.getSector()
        )).toList();
    }
}
