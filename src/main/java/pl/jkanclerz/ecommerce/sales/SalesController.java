package pl.jkanclerz.ecommerce.sales;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesController {

    SalesFacade salesFacade;

    public SalesController(SalesFacade salesFacade) {
        this.salesFacade = salesFacade;
    }

    @GetMapping("/api/current-offer")
    Offer getCurrentOffer() {
        String customerId = getCustomerId();
        return salesFacade.getCurrentOffer(customerId);
    }

    @PostMapping("/api/add-product/{productId}")
    void addProduct(@PathVariable String productId) {
        String customerId = getCustomerId();
        salesFacade.addProduct(customerId, productId);
    }

    private String getCustomerId() {
        return "guest";
    }
}
