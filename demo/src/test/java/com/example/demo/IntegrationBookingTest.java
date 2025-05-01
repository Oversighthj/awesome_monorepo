// File: demo/src/test/java/com/example/demo/IntegrationBookingTest.java
package com.example.demo;

import com.example.demo.dto.TransportBookingDTO;
import com.example.demo.entity.BookingEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class IntegrationBookingTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void bookTransport_Integration_ReturnsBookingEntity() {
        // given
        TransportBookingDTO dto = new TransportBookingDTO();
        dto.setFlightId("FL123");
        dto.setUserId("USR1");
        dto.setSeatCount(3);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TransportBookingDTO> request = new HttpEntity<>(dto, headers);

        // when
        ResponseEntity<BookingEntity> response = restTemplate.exchange(
            "/transport/book",
            HttpMethod.POST,
            request,
            BookingEntity.class
        );

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        BookingEntity booking = response.getBody();
        assertThat(booking).isNotNull();
        assertThat(booking.getId()).isNotNull();
        assertThat(booking.getFlightId()).isEqualTo("FL123");
        assertThat(booking.getUserId()).isEqualTo("USR1");
        assertThat(booking.getSeatCount()).isEqualTo(3);
        assertThat(booking.getStatus()).isEqualTo("CONFIRMED");
        assertThat(booking.getBookingTime()).isBeforeOrEqualTo(LocalDateTime.now());
    }
}
