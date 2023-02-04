package com.ahmetdayi.patikaorderapp.entity.converter;

import com.ahmetdayi.patikaorderapp.entity.User;
import com.ahmetdayi.patikaorderapp.entity.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserResponse convert(User from){
        return new UserResponse
                (
                        from.getId(),
                        from.getCreatedDate(),
                        from.getFullName()

                );
    }
}
