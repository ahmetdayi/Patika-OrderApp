package com.ahmetdayi.patikaorderapp.entity.converter;

import com.ahmetdayi.patikaorderapp.entity.User;
import com.ahmetdayi.patikaorderapp.entity.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserConverter {

    public UserResponse convert(User from) {
        return new UserResponse
                (
                        from.getId(),
                        from.getCreatedDate(),
                        from.getFullName()

                );
    }

    public List<UserResponse> convert(List<User> fromList) {
        if (fromList == null) {
            return null;
        }
        return fromList.stream().map(from -> new UserResponse
                (
                        from.getId(),
                        from.getCreatedDate(),
                        from.getFullName()
                )).toList();
    }
}
