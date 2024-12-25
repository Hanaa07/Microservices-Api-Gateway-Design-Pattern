package org.emsi.apigatewayservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DesktopProduct {

    /**
     * The price of the product.
     */
    private String price;

    /**
     * The path to the image of the product.
     */
    private String imagePath;

}
