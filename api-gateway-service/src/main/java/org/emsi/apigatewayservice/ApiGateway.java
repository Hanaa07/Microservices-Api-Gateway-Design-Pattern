package org.emsi.apigatewayservice;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiGateway {

    @Resource
    private ImageClient imageClient;

    @Resource
    private PriceClient priceClient;

    /**
     * Retrieves product information that desktop clients need.
     *
     * @return Product information for clients on a desktop
     */
    @GetMapping("/desktop")
    public DesktopProduct getProductDesktop() {
        var desktopProduct = new DesktopProduct();
        desktopProduct.setImagePath(imageClient.getImagePath());
        desktopProduct.setPrice(priceClient.getPrice());
        return desktopProduct;
    }

    /**
     * Retrieves product information that mobile clients need.
     *
     * @return Product information for clients on a mobile device
     */
    @GetMapping("/mobile")
    public MobileProduct getProductMobile() {
        var mobileProduct = new MobileProduct();
        mobileProduct.setPrice(priceClient.getPrice());
        return mobileProduct;
    }
}
