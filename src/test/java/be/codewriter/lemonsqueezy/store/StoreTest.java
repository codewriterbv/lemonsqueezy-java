package be.codewriter.lemonsqueezy.store;

import be.codewriter.lemonsqueezy.BaseTest;
import be.codewriter.lemonsqueezy.generic.DataType;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest extends BaseTest {

    @Test
    void shouldParseStore() throws IOException {
        Store store = objectMapper.readValue(loadJson("/lemonsqueezy/store/store.json"), Store.class);
        StoreAttributes attr = store.getAttributes();
        assertAll(
                () -> assertEquals(DataType.STORES, store.getType(), "Store type should be equal"),
                () -> assertEquals("1", store.getId(), "Store ID should be equal"),
                // Data Attributes
                () -> assertNotNull(attr, "Store attributes should not be null"),
                () -> assertEquals("My Store", attr.getName(), "Store attributes name should be equal"),
                () -> assertEquals("my-store", attr.getSlug(), "Store attributes email should be equal"),
                () -> assertEquals("my-store.lemonsqueezy.com", attr.getDomain(), "Store attributes domain should be equal"),
                () -> assertEquals("https://demo-store.lemonsqueezy.com", attr.getUrl(), "Store attributes url should be equal"),
                () -> assertEquals("https://app.lemonsqueezy.com/storage/avatars/stores/1/czTkMkDm4Vfb8PZehb5c29XFCm9JZyJx0AjEZP7s.png", attr.getAvatarUrl(), "Store attributes avatar url should be equal"),
                () -> assertEquals("fresh", attr.getPlan(), "Store attributes fresh should be equal"),
                () -> assertEquals("US", attr.getCountry(), "Store attributes country should be equal"),
                () -> assertEquals("United States", attr.getCountryNicename(), "Store attributes country nice name should be equal"),
                () -> assertEquals("USD", attr.getCurrency(), "Store attributes currency should be equal"),
                () -> assertEquals(1, attr.getTotalSales(), "Store attributes total sales should be equal"),
                () -> assertEquals(999, attr.getTotalRevenue(), "Store attributes total revenue should be equal"),
                () -> assertEquals(0, attr.getThirtyDaySales(), "Store attributes thirty day sales should be equal"),
                () -> assertEquals(0, attr.getThirtyDayRevenue(), "Store attributes thirty day revenue should be equal"),
                () -> assertEquals(LocalDateTime.parse("2021-05-24T14:15:06.000000"), attr.getCreatedAt(), "Store attributes created at should be equal"),
                () -> assertEquals(LocalDateTime.parse("2021-06-15T10:03:14.000000"), attr.getUpdatedAt(), "Store attributes updated at should be equal")
        );
    }

    @Test
    void shouldParseStoreResponse() throws IOException {
        StoreResponse response = objectMapper.readValue(loadJson("/lemonsqueezy/store/store_response.json"), StoreResponse.class);
        Store store = response.getStore();
        StoreAttributes attr = store.getAttributes();
        assertAll(
                // Json API
                () -> assertEquals("1.0", response.getJsonApi().getVersion(), "Response Json API version should be equal"),
                // Store
                () -> assertEquals(DataType.STORES, store.getType(), "Store type should be equal"),
                () -> assertEquals("1", store.getId(), "Store ID should be equal"),
                // Data Attributes
                () -> assertNotNull(attr, "Store attributes should not be null"),
                () -> assertEquals("My Store", attr.getName(), "Store attributes name should be equal"),
                () -> assertEquals("my-store", attr.getSlug(), "Store attributes email should be equal"),
                () -> assertEquals("my-store.lemonsqueezy.com", attr.getDomain(), "Store attributes domain should be equal"),
                () -> assertEquals("https://my-store.lemonsqueezy.com", attr.getUrl(), "Store attributes url should be equal"),
                () -> assertEquals("https://app.lemonsqueezy.com/storage/avatars/stores/1/czTkMkDm4Vfb8PZehb5c29XFCm9JZyJx0AjEZP7s.png", attr.getAvatarUrl(), "Store attributes avatar url should be equal"),
                () -> assertEquals("fresh", attr.getPlan(), "Store attributes fresh should be equal"),
                () -> assertEquals("US", attr.getCountry(), "Store attributes country should be equal"),
                () -> assertEquals("United States", attr.getCountryNicename(), "Store attributes country nice name should be equal"),
                () -> assertEquals("USD", attr.getCurrency(), "Store attributes currency should be equal"),
                () -> assertEquals(1, attr.getTotalSales(), "Store attributes total sales should be equal"),
                () -> assertEquals(999, attr.getTotalRevenue(), "Store attributes total revenue should be equal"),
                () -> assertEquals(0, attr.getThirtyDaySales(), "Store attributes thirty day sales should be equal"),
                () -> assertEquals(0, attr.getThirtyDayRevenue(), "Store attributes thirty day revenue should be equal"),
                () -> assertEquals(LocalDateTime.parse("2021-05-24T14:15:06.000000"), attr.getCreatedAt(), "Store attributes created at should be equal"),
                () -> assertEquals(LocalDateTime.parse("2021-06-15T10:03:14.000000"), attr.getUpdatedAt(), "Store attributes updated at should be equal"),
                // Relationships
                () -> assertEquals("https://api.lemonsqueezy.com/v1/stores/1/products", store.getRelationships().getProducts().getLinks().getRelated(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/stores/1/relationships/products", store.getRelationships().getProducts().getLinks().getSelf(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/stores/1/orders", store.getRelationships().getOrders().getLinks().getRelated(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/stores/1/relationships/orders", store.getRelationships().getOrders().getLinks().getSelf(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/stores/1/subscriptions", store.getRelationships().getSubscriptions().getLinks().getRelated(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/stores/1/relationships/subscriptions", store.getRelationships().getSubscriptions().getLinks().getSelf(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/stores/1/discounts", store.getRelationships().getDiscounts().getLinks().getRelated(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/stores/1/relationships/discounts", store.getRelationships().getDiscounts().getLinks().getSelf(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/stores/1/license-keys", store.getRelationships().getLicenseKeys().getLinks().getRelated(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/stores/1/relationships/license-keys", store.getRelationships().getLicenseKeys().getLinks().getSelf(), "Data Relationship should be equal"),

                // Links
                () -> assertEquals("https://api.lemonsqueezy.com/v1/stores/1", response.getLinks().getSelf(), "Response links self should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/stores/1", store.getLinks().getSelf(), "Store links self should be equal")
        );
    }

    @Test
    void shouldParseAllStoresResponse() throws IOException {
        StoreListResponse response = objectMapper.readValue(loadJson("/lemonsqueezy/store/all_stores_response.json"), StoreListResponse.class);
        List<Store> stores = response.getStores();
        StoreAttributes attr = stores.get(0).getAttributes();
        assertAll(
                // Json API
                () -> assertEquals("1.0", response.getJsonApi().getVersion(), "Response Json API version should be equal"),
                // List
                () -> assertEquals(3, stores.size(), "Number of stores should be equal"),
                // Store
                () -> assertEquals(DataType.STORES, stores.get(0).getType(), "Store type should be equal"),
                () -> assertEquals("1", stores.get(0).getId(), "Store ID should be equal"),
                // Data Attributes
                () -> assertEquals("My Store", attr.getName(), "Store attributes name should be equal"),
                () -> assertEquals("my-store", attr.getSlug(), "Store attributes email should be equal"),
                () -> assertEquals("my-store.lemonsqueezy.com", attr.getDomain(), "Store attributes domain should be equal"),
                () -> assertEquals("https://my-store.lemonsqueezy.com", attr.getUrl(), "Store attributes url should be equal"),
                () -> assertEquals("https://app.lemonsqueezy.com/storage/avatars/stores/1/czTkMkDm4Vfb8PZehb5c29XFCm9JZyJx0AjEZP7s.png", attr.getAvatarUrl(), "Store attributes avatar url should be equal"),
                () -> assertEquals("fresh", attr.getPlan(), "Store attributes fresh should be equal"),
                () -> assertEquals("US", attr.getCountry(), "Store attributes country should be equal"),
                () -> assertEquals("United States", attr.getCountryNicename(), "Store attributes country nice name should be equal"),
                () -> assertEquals("USD", attr.getCurrency(), "Store attributes currency should be equal"),
                () -> assertEquals(1, attr.getTotalSales(), "Store attributes total sales should be equal"),
                () -> assertEquals(999, attr.getTotalRevenue(), "Store attributes total revenue should be equal"),
                () -> assertEquals(0, attr.getThirtyDaySales(), "Store attributes thirty day sales should be equal"),
                () -> assertEquals(0, attr.getThirtyDayRevenue(), "Store attributes thirty day revenue should be equal"),
                () -> assertEquals(LocalDateTime.parse("2021-05-24T14:15:06.000000"), attr.getCreatedAt(), "Store attributes created at should be equal"),
                () -> assertEquals(LocalDateTime.parse("2021-06-15T10:03:14.000000"), attr.getUpdatedAt(), "Store attributes updated at should be equal"),
                // Links
                () -> assertEquals("https://api.lemonsqueezy.com/v1/stores/1", stores.get(0).getLinks().getSelf(), "Store links self should be equal")
        );
    }
}
