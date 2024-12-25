package org.emsi.imagemicroservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    /**
     * An endpoint for a user to retrieve an image path.
     *
     * @return An image path
     */
    @GetMapping("/image-path")
    public String getImagePath() {
        System.out.println("Successfully found image path");
        return "/product-image.png";
    }
}