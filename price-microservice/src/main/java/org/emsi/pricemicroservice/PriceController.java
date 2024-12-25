package org.emsi.pricemicroservice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;

    /**
     * An endpoint for a user to retrieve a product's price.
     *
     * @return A product's price
     */
    @GetMapping("/price")
    public String getPrice() {
        return priceService.getPrice();
    }
}