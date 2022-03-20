package project.project1_test.OrderService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class NotificationClient {
    public void notifyToMobile(){
        System.out.println("norify to mobile success");
    }
}
