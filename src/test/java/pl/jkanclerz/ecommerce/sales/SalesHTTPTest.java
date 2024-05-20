package pl.jkanclerz.ecommerce.sales;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SalesHTTPTest {

    @Autowired
    TestRestTemplate http;

    @LocalServerPort
    int port;

    @Test
    void itShowsCurrentOfferToCustomer() {
        var url = String.format("http://localhost:%s/api/current-offer");

        ResponseEntity<Offer> offerResponse = http.getForEntity(url, Offer.class);

        assertThat(offerResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(offerResponse.getBody().getTotal()).isEqualTo(BigDecimal.ZERO);
        assertThat(offerResponse.getBody().getItemCount()).isEqualTo(0);
    }
}
