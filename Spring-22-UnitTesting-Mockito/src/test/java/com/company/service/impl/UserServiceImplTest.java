package com.company.service.impl;

import com.company.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;
    @InjectMocks // will inject all the mocks inside userService
    UserServiceImpl userService;

    @Test
    void deleteByUsername_test() {

        userService.deleteByUserName("mikesmith@company.com");
//        Mockito.verify(userRepository).deleteByUserName("mikesmith@company.com"); // verify deleteByUserName runs as expected

        verify(userRepository).deleteByUserName("mikesmith@company.com");
//        verify(userRepository, times(2)).deleteByUserName("mikesmith@company.com");
//        verify(userRepository, atLeastOnce()).deleteByUserName("mikesmith@company.com");
//        verify(userRepository, atLeast(5)).deleteByUserName("mikesmith@company.com");
//        verify(userRepository, atMostOnce()).deleteByUserName("mikesmith@company.com");
//        verify(userRepository, atMost(5)).deleteByUserName("mikesmith@company.com");

        InOrder inOrder = inOrder(userRepository); // InOrder class comes from Mockito. It wil check order of the executions

        inOrder.verify(userRepository).deleteByUserName("mikesmith@company.com");
        inOrder.verify(userRepository).findAll();

    }

}