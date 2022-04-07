package com.cobi.testdouble.non_spring;

import com.cobi.testdouble.NotificationClient;
import com.cobi.testdouble.repository.OrderRepository;
import com.cobi.testdouble.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

@ExtendWith(MockitoExtension.class)
public class SpyTests {
    @Spy
    private OrderRepository orderRepository;
    @Spy
    private NotificationClient notificationClient;
    @InjectMocks
    private OrderService orderService;

    @Test
    public void createOrderTest_basic() {
        // given

        //doReturn() 경우
        Mockito.doReturn(null).when(orderRepository).createOrder();

        //doNothing() 경우
        Mockito.doNothing().when(orderRepository).createOrder();

        //doThrow() 경우
        Mockito.doThrow(new RuntimeException()).when(orderRepository).createOrder();

        //doAnswer() 경우
        Mockito.doAnswer(invocation -> {
            System.out.println("I'm spy orderRepository createOrder");
            return null;
        }).when(orderRepository).createOrder();

        //thenCallRealMethod() 경우
        Mockito.doCallRealMethod().when(orderRepository).createOrder();


        Mockito.doAnswer(invocation -> {
            System.out.println("I'm spy notificationclient");
            return null;
        }).when(notificationClient).notifyToMobile();


        // when
        orderService.createOrder(true);

        // then
        Mockito.verify(orderRepository, Mockito.times(1)).createOrder();
        Mockito.verify(notificationClient, Mockito.times(1)).notifyToMobile();
    }
}
