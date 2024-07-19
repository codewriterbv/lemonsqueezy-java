package be.codewriter.lemonsqueezy.store;

import be.codewriter.lemonsqueezy.BaseTest;
import be.codewriter.lemonsqueezy.api.ApiRequest;
import be.codewriter.lemonsqueezy.generic.ApiEndpoint;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

class GetStoreTest extends BaseTest {

    @Test
    void shouldGetAllStoresFromApi() throws IOException, InterruptedException {
        HttpResponse<String> response = ApiRequest.get(ApiEndpoint.STORES, API_BEARER_TOKEN);
        assertEquals(200, response.statusCode(), "Should get valid response");

        var list = objectMapper.readValue(response.body(), StoreListResponse.class);
        assertAll(
                () -> assertNotNull(list, "Shop list should not be null"),
                () -> assertEquals(2, list.getStores().size(), "Should have correct number of stores"),
                () -> assertEquals("CodeWriter bv", list.getStores().get(0).getAttributes().getName(), "Should have correct store name"),
                () -> assertEquals("91257", list.getStores().get(0).getId(), "Should have correct store ID"),
                () -> assertEquals("UnitTestStore", list.getStores().get(1).getAttributes().getName(), "Should have correct store name"),
                () -> assertEquals("110198", list.getStores().get(1).getId(), "Should have correct store ID")
        );
    }
}
