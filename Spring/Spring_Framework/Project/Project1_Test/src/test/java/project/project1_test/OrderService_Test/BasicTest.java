package project.project1_test.OrderService_Test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.project1_test.OrderService.OrderService;

@SpringBootTest
class BasicSpringTests {
    @Autowired
    private OrderService orderService;

    @Test
    void createOrderTest() {
        orderService.createOrder(true);
    }
}
