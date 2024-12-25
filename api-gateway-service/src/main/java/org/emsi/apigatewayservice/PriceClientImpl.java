package org.emsi.apigatewayservice;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class PriceClientImpl implements PriceClient {

    /**
     * Makes a simple HTTP Get request to the Price microservice.
     *
     * @return The price of the product
     */
    @Override
    public String getPrice() {
        var httpClient = HttpClient.newHttpClient();
        var httpGet = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:50006/price"))
                .build();

        try {
            System.out.println("Sending request to fetch price info");
            var httpResponse = httpClient.send(httpGet, HttpResponse.BodyHandlers.ofString());
            logResponse(httpResponse);
            return httpResponse.body();
        } catch (IOException e) {
            System.out.println("Failure occurred while getting price info");
        } catch (InterruptedException e) {
            System.out.println("Failure occurred while getting price info");
            Thread.currentThread().interrupt();
        }

        return null;
    }

    private void logResponse(HttpResponse<String> httpResponse) {
        if (isSuccessResponse(httpResponse.statusCode())) {
            System.out.println("Price info received successfully");
        } else {
            System.out.println("Price info request failed");
        }
    }

    private boolean isSuccessResponse(int responseCode) {
        return responseCode >= 200 && responseCode <= 299;
    }
}
