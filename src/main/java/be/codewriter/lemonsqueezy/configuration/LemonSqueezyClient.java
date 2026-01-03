package be.codewriter.lemonsqueezy.configuration;

import be.codewriter.lemonsqueezy.generic.ApiEndpoint;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LemonSqueezyClient {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String apiKey;
    private final HttpClient client;

    public LemonSqueezyClient(final String apiKey) {
        this.apiKey = apiKey;
        this.objectMapper.registerModule(new JavaTimeModule());
        this.client = HttpClient.newHttpClient();
    }

    public String getApiKey() {
        return apiKey;
    }

    public <T> T get(final ApiEndpoint endpoint, final Class<T> responseType) throws IOException, InterruptedException {
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint.getApiEndpoint()))
                .header("Accept", "application/vnd.api+json")
                .header("Content-Type", "application/vnd.api+json")
                .header("Authorization", "Bearer " + apiKey)
                .build();

        // Get response as String
        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Deserialize String into the specific type T
        return objectMapper.readValue(response.body(), responseType);
    }
}
