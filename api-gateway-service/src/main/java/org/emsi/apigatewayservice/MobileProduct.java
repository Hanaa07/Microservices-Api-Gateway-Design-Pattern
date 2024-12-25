package org.emsi.apigatewayservice;

import lombok.Getter;
import lombok.Setter;

/**
 * Encapsulates all the information that mobile client needs to display a product.
 */
@Getter
@Setter
public class MobileProduct {
    /**
     * The price of the product.
     */
    private String price;
}
