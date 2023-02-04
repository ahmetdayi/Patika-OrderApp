package com.ahmetdayi.patikaorderapp.entity.converter;

import com.ahmetdayi.patikaorderapp.entity.Bill;
import com.ahmetdayi.patikaorderapp.entity.response.BillResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BillConverter {

    private final UserConverter userConverter;

    private final CompanyConverter companyConverter;

    public BillResponse convert(Bill from) {

        return new BillResponse
                (
                        from.getId(),
                        from.getPrice(),
                        from.getCreatedDate(),
                        userConverter.convert(from.getUser()),
                        companyConverter.convert(from.getCompany())
                );
    }

    public List<BillResponse> convert(List<Bill> fromList) {
        if (fromList == null) {
            return null;
        }

        return fromList.stream().map(from -> new BillResponse
                (
                        from.getId(),
                        from.getPrice(),
                        from.getCreatedDate(),
                        userConverter.convert(from.getUser()),
                        companyConverter.convert(from.getCompany())
                )).toList();
    }
}
