package com.biraneves.service.net;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClient {

    public String getData(String url) {

        try {

            URI address = URI.create(url);  // URI to the API.
            java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient(); // HTTP client to send a request to the API.
            HttpRequest request = HttpRequest.newBuilder(address).GET().build();    // Request to consume the API.
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); // Resulting text from the API.

            return response.body();

        } catch (IOException | InterruptedException e) {

            throw new RuntimeException(e);

        }

    }

}
