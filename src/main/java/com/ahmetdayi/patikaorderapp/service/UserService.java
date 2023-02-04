package com.ahmetdayi.patikaorderapp.service;

import com.ahmetdayi.patikaorderapp.core.exception.UserNotFoundException;
import com.ahmetdayi.patikaorderapp.core.exception.constant.Constant;
import com.ahmetdayi.patikaorderapp.entity.User;
import com.ahmetdayi.patikaorderapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    protected User findById(UUID id){
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(Constant.USER_NOT_FOUND));
    }
}
