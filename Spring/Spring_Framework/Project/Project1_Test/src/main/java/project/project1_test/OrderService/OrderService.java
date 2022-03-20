package project.project1_test.OrderService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final NotificationClient notificationClient;

    public void createOrder(boolean isNotify){
        List<Order> orderList = orderRepository.findOrderList();
        if(orderList.size() > 0){
            throw new OrderDuplicateException();
        }

        orderRepository.createOrder();

        if(isNotify){
            notificationClient.notifyToMobile();
        }
    }

}
