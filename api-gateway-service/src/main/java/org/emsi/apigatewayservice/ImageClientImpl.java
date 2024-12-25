package org.emsi.apigatewayservice;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class ImageClientImpl implements ImageClient {

    /**
     * Makes a simple HTTP Get request to the Image microservice.
     *
     * @return The path to the image
     */
    @Override
    public String getImagePath() {
        var httpClient = HttpClient.newHttpClient();
        var httpGet = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:50005/image-path"))
                .build();

        try {
            System.out.println("Sending request to fetch image path");
            var httpResponse = httpClient.send(httpGet, HttpResponse.BodyHandlers.ofString());
            logResponse(httpResponse);
            return httpResponse.body();
        } catch (IOException ioe) {
            System.out.println("Failure occurred while getting image path");
        } catch (InterruptedException ie) {
            System.out.println("Failure occurred while getting image path");
            Thread.currentThread().interrupt();
        }

        return null;
    }

    private void logResponse(HttpResponse<String> httpResponse) {
        if (isSuccessResponse(httpResponse.statusCode())) {
            System.out.println("Image path received successfully");
        } else {
            System.out.println("Image path request failed");
        }
    }

    private boolean isSuccessResponse(int responseCode) {
        return responseCode >= 200 && responseCode <= 299;
    }
}
