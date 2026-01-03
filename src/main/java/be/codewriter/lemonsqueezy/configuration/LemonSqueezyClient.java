package be.codewriter.lemonsqueezy.configuration;

import be.codewriter.lemonsqueezy.generic.ApiEndpoint;
import be.codewriter.lemonsqueezy.response.LemonSqueezyResponse;
import com.fasterxml.jackson.core.type.TypeReference;
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
        final HttpResponse<String> response = getHttpResponse(endpoint, -1L);

        // Deserialize String into the specific type T
        return objectMapper.readValue(response.body(), responseType);
    }

    public <T> T getItem(final ApiEndpoint endpoint, final Long id, final Class<T> responseType) throws IOException, InterruptedException {
        final HttpResponse<String> response = getHttpResponse(endpoint, id);

        // Deserialize String into the specific type T
        return objectMapper.readValue(response.body(), responseType);
    }

    public <T> LemonSqueezyResponse<T> getList(final ApiEndpoint endpoint) throws IOException, InterruptedException {
        final HttpResponse<String> response = getHttpResponse(endpoint, -1L);

        // Deserialize String into the specific type T
        final TypeReference<LemonSqueezyResponse<T>> typeRef = new TypeReference<>() {};
        return objectMapper.readValue(response.body(), typeRef);
    }

    private HttpResponse<String> getHttpResponse(final ApiEndpoint endpoint, final Long id) throws IOException, InterruptedException {
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint.getApiEndpoint() + (id > 0 ? "/" + id: "")))
                .header("Accept", "application/vnd.api+json")
                .header("Content-Type", "application/vnd.api+json")
                .header("Authorization", "Bearer " + apiKey)
                .build();

        // Get response as String
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
