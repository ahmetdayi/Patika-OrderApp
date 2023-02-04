package com.ahmetdayi.patikaorderapp.service;

import com.ahmetdayi.patikaorderapp.core.exception.UserNotFoundException;
import com.ahmetdayi.patikaorderapp.core.exception.constant.Constant;
import com.ahmetdayi.patikaorderapp.entity.Bill;
import com.ahmetdayi.patikaorderapp.entity.User;
import com.ahmetdayi.patikaorderapp.entity.converter.UserConverter;
import com.ahmetdayi.patikaorderapp.entity.request.CreateUserRequest;
import com.ahmetdayi.patikaorderapp.entity.response.UserResponse;
import com.ahmetdayi.patikaorderapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserConverter userConverter;


    public UserResponse create(CreateUserRequest request){
        User user = new User
                (
                        request.getCreatedDate(),
                        request.getFullName()
                );
        return userConverter.convert(userRepository.save(user));

    }

    public List<UserResponse> findAll(){
        return userConverter.convert(userRepository.findAll());
    }

    public List<UserResponse> filterByFullNameContainsLetter(String letter){
        return userConverter.convert(userRepository.findByFullNameContainsIgnoreCase(letter));
    }

    public Double totalAmountOfPillOfUserRegisteredIJune(){
        return userRepository
                .findAll()
                .stream()
                .filter(user -> user
                        .getCreatedDate()
                        .getMonthValue()==6)
                .map(value -> value
                        .getBills()
                        .stream()
                        .mapToDouble(Bill::getPrice)
                        .sum())
                .toList()
                .get(0);

    }

    public List<String> filterUserWithPillUnder500(){
        return userRepository.findByBills_PriceLessThan(500).stream().map(User::getFullName).toList();
    }

    protected User findById(UUID id){
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(Constant.USER_NOT_FOUND));
    }
}
