package project.project1_test.OrderService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class OrderRepository {

    public List<Order> findOrderList() {
        System.out.println("real OrderRepository findOrderList");
        return Collections.emptyList();
    }

    public void createOrder(){
        System.out.println("creatOrder success");
    }

}
