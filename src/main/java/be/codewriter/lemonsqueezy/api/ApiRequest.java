package be.codewriter.lemonsqueezy.api;

import be.codewriter.lemonsqueezy.generic.ApiEndpoint;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {
    public static HttpResponse<String> get(ApiEndpoint endpoint, String bearerToken) throws IOException, InterruptedException {
        return get(endpoint, bearerToken, null);
    }

    public static HttpResponse<String> get(ApiEndpoint endpoint, String bearerToken, Object data) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint.getApiEndpoint()))
                .header("Accept", "application/vnd.api+json")
                .header("Content-Type", "application/vnd.api+json")
                .header("Authorization", "Bearer " + bearerToken)
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
