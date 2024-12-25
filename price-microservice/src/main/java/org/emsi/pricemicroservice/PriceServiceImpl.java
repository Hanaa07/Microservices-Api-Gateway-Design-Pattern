package org.emsi.pricemicroservice;

import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {

    @Override
    public String getPrice() {
        System.out.println("Successfully found price info");
        return "20";
    }
}
