// demo/src/main/java/com/example/demo/transport/TransportController.java

package com.example.demo.transport;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transport")
public class TransportController {

    @GetMapping("/flights")
    public List<TransportDTO> getAllFlights() {
        // أرجع بيانات تجريبية أو من قاعدة البيانات لاحقًا
        return List.of(
            new TransportDTO(1, "Flight 1", "Riyadh", "Jeddah", "2025-05-10T12:00:00Z", 200.0),
            new TransportDTO(2, "Flight 2", "Jeddah", "Dubai", "2025-05-11T15:30:00Z", 300.0)
        );
    }
}
