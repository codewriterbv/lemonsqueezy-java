package be.codewriter.lemonsqueezy.customer;

import be.codewriter.lemonsqueezy.BaseTest;
import be.codewriter.lemonsqueezy.generic.DataType;
import be.codewriter.lemonsqueezy.generic.Page;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest extends BaseTest {

    @Test
    void shouldParseCustomer() throws IOException {
        Customer user = objectMapper.readValue(loadJson("lemonsqueezy/customer/customer.json"), Customer.class);
        CustomerAttributes attr = user.getAttributes();
        assertAll(
                () -> assertEquals(DataType.CUSTOMERS, user.getType(), "Customer type should be equal"),
                () -> assertEquals("1", user.getId(), "Customer ID should be equal"),
                // Data Attributes
                () -> assertNotNull(attr, "Customer attributes should not be null"),
                () -> assertFalse(attr.getTestMode(), "Customer attributes name should be equal"),
                () -> assertEquals(1, attr.getStoreId(), "Customer attributes name should be equal"),
                () -> assertEquals("Luke Skywalker", attr.getName(), "Customer attributes name should be equal"),
                () -> assertEquals("lukeskywalker@example.com", attr.getEmail(), "Customer attributes email should be equal"),
                () -> assertEquals("subscribed", attr.getStatus(), "Customer attributes status should be equal"),
                () -> assertEquals("Subscribed", attr.getStatusFormatted(), "Customer status formatted should be equal"),
                () -> assertEquals("Brussels", attr.getCity(), "Customer attributes city should be equal"),
                () -> assertEquals("Earth", attr.getRegion(), "Customer attributes region should be equal"),
                () -> assertEquals("BE", attr.getCountry(), "Customer attributes country should be equal"),
                () -> assertEquals("Belgium", attr.getCountryFormatted(), "Customer attributes country formatted should be equal"),
                () -> assertEquals(84332, attr.getTotalRevenueCurrency(), "Customer attributes total revenue should be equal"),
                () -> assertEquals("$843.32", attr.getTotalRevenueCurrencyFormatted(), "Customer attributes total revenue formatted should be equal"),
                () -> assertEquals(1999, attr.getMonthlyRecurringRevenue(), "Customer attributes monthly recurring should be equal"),
                () -> assertEquals("$19.99", attr.getMonthlyRecurringRevenueFormatted(), "Customer attributes monthly recurring formatted should be equal"),
                () -> assertEquals("https://my-store.lemonsqueezy.com/billing?expires=1666869343&signature=82ae290ceac8edd4190c82825dd73a8743346d894a8ddbc4898b97eb96d105a5", attr.getUrls().getCustomerPortal(), "Customer attributes url customer portal should be equal"),
                () -> assertEquals(LocalDateTime.parse("2022-12-01T13:01:07.000000"), attr.getCreatedAt(), "Customer attributes created at should be equal"),
                () -> assertEquals(LocalDateTime.parse("2022-12-09T09:05:21.000000"), attr.getUpdatedAt(), "Customer attributes updated at should be equal")
        );
    }

    @Test
    void shouldParseCustomerResponse() throws IOException {
        CustomerResponse response = objectMapper.readValue(loadJson("lemonsqueezy/customer/customer_response.json"), CustomerResponse.class);
        Customer customer = response.getCustomer();
        CustomerAttributes attr = customer.getAttributes();
        assertAll(
                // Json API
                () -> assertEquals("1.0", response.getJsonApi().getVersion(), "Response Json API version should be equal"),
                // User
                () -> assertEquals(DataType.CUSTOMERS, customer.getType(), "Customer type should be equal"),
                () -> assertEquals("1", customer.getId(), "Customer ID should be equal"),
                // Data Attributes
                () -> assertNotNull(attr, "Customer attributes should not be null"),
                () -> assertFalse(attr.getTestMode(), "Customer attributes name should be equal"),
                () -> assertEquals(1, attr.getStoreId(), "Customer attributes name should be equal"),
                () -> assertEquals("Luke Skywalker", attr.getName(), "Customer attributes name should be equal"),
                () -> assertEquals("lukeskywalker@example.com", attr.getEmail(), "Customer attributes email should be equal"),
                () -> assertEquals("subscribed", attr.getStatus(), "Customer attributes status should be equal"),
                () -> assertEquals("Subscribed", attr.getStatusFormatted(), "Customer attributes status formatted should be equal"),
                () -> assertEquals("New York", attr.getCity(), "Customer attributes city should be equal"),
                () -> assertEquals("NY", attr.getRegion(), "Customer attributes region should be equal"),
                () -> assertEquals("US", attr.getCountry(), "Customer attributes country should be equal"),
                () -> assertEquals("United States", attr.getCountryFormatted(), "Customer attributes country formatted should be equal"),
                () -> assertEquals(0, attr.getTotalRevenueCurrency(), "Customer attributes total revenue should be equal"),
                () -> assertEquals("$0.00", attr.getTotalRevenueCurrencyFormatted(), "Customer attributes total revenue formatted should be equal"),
                () -> assertEquals(0, attr.getMonthlyRecurringRevenue(), "Customer attributes monthly recurring should be equal"),
                () -> assertEquals("$0.00", attr.getMonthlyRecurringRevenueFormatted(), "Customer attributes monthly recurring formatted should be equal"),
                () -> assertNull(attr.getUrls().getCustomerPortal(), "Customer attributes url customer portal should be null"),
                () -> assertEquals(LocalDateTime.parse("2022-12-01T13:01:07.000000"), attr.getCreatedAt(), "Customer attributes created at should be equal"),
                () -> assertEquals(LocalDateTime.parse("2022-12-09T09:05:21.000000"), attr.getUpdatedAt(), "Customer attributes updated at should be equal"),
                // Relationships
                () -> assertEquals("https://api.lemonsqueezy.com/v1/customers/1/store", customer.getRelationships().getStore().getLinks().getRelated(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/customers/1/relationships/store", customer.getRelationships().getStore().getLinks().getSelf(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/customers/1/orders", customer.getRelationships().getOrders().getLinks().getRelated(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/customers/1/relationships/orders", customer.getRelationships().getOrders().getLinks().getSelf(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/customers/1/subscriptions", customer.getRelationships().getSubscriptions().getLinks().getRelated(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/customers/1/relationships/subscriptions", customer.getRelationships().getSubscriptions().getLinks().getSelf(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/customers/1/license-keys", customer.getRelationships().getLicenseKeys().getLinks().getRelated(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/customers/1/relationships/license-keys", customer.getRelationships().getLicenseKeys().getLinks().getSelf(), "Data Relationship should be equal"),
                // Links
                () -> assertEquals("https://api.lemonsqueezy.com/v1/customers/1", response.getLinks().getSelf(), "Response links self should be equal")
        );
    }

    @Test
    void shouldParseAllCustomersResponse() throws IOException {
        CustomerListResponse response = objectMapper.readValue(loadJson("lemonsqueezy/customer/all_customers_response.json"), CustomerListResponse.class);
        List<Customer> customers = response.getCustomers();
        CustomerAttributes attr1 = customers.get(0).getAttributes();
        CustomerAttributes attr2 = customers.get(1).getAttributes();
        Page page = response.getMeta().getPage();
        assertAll(
                // Meta Page
                () -> assertEquals(1, page.getCurrentPage(), "Response Meta Page current should be equal"),
                () -> assertEquals(1, page.getFrom(), "Response Meta Page from should be equal"),
                () -> assertEquals(1, page.getLastPage(), "Response Meta Page last page should be equal"),
                () -> assertEquals(10, page.getPerPage(), "Response Meta Page per page should be equal"),
                () -> assertEquals(10, page.getTo(), "Response Meta Page to should be equal"),
                () -> assertEquals(10, page.getTotal(), "Response Meta Page total should be equal"),
                // Json API
                () -> assertEquals("1.0", response.getJsonApi().getVersion(), "Response Json API version should be equal"),
                // List
                () -> assertEquals(2, customers.size(), "Number of customers should be equal"),
                // Customer - 1
                () -> assertEquals(DataType.CUSTOMERS, customers.get(0).getType(), "Customer type should be equal"),
                () -> assertEquals("1", customers.get(0).getId(), "Customer ID should be equal"),
                // Data Attributes - 1
                () -> assertNotNull(attr1, "Customer attributes should not be null"),
                () -> assertFalse(attr1.getTestMode(), "Customer attributes name should be equal"),
                () -> assertEquals(1, attr1.getStoreId(), "Customer attributes name should be equal"),
                () -> assertEquals("Luke Skywalker", attr1.getName(), "Customer attributes name should be equal"),
                () -> assertEquals("lukeskywalker@example.com", attr1.getEmail(), "Customer attributes email should be equal"),
                () -> assertEquals("subscribed", attr1.getStatus(), "Customer attributes status should be equal"),
                () -> assertEquals("Subscribed", attr1.getStatusFormatted(), "Customer attributes status formatted should be equal"),
                () -> assertNull(attr1.getCity(), "Customer attributes city should be equal"),
                () -> assertNull(attr1.getRegion(), "Customer attributes region should be equal"),
                () -> assertEquals("US", attr1.getCountry(), "Customer attributes country should be equal"),
                () -> assertEquals("United States", attr1.getCountryFormatted(), "Customer attributes country formatted should be equal"),
                () -> assertEquals(84332, attr1.getTotalRevenueCurrency(), "Customer attributes total revenue should be equal"),
                () -> assertEquals("$843.32", attr1.getTotalRevenueCurrencyFormatted(), "Customer attributes total revenue formatted should be equal"),
                () -> assertEquals(1999, attr1.getMonthlyRecurringRevenue(), "Customer attributes monthly recurring should be equal"),
                () -> assertEquals("$19.99", attr1.getMonthlyRecurringRevenueFormatted(), "Customer attributes monthly recurring formatted should be equal"),
                () -> assertEquals("https://my-store.lemonsqueezy.com/billing?expires=1666869343&signature=82ae290ceac8edd4190c82825dd73a8743346d894a8ddbc4898b97eb96d105a5", attr1.getUrls().getCustomerPortal(), "Customer attributes url customer portal should be null"),
                () -> assertEquals(LocalDateTime.parse("2022-12-01T13:01:07.000000"), attr1.getCreatedAt(), "Customer attributes created at should be equal"),
                () -> assertEquals(LocalDateTime.parse("2022-12-09T09:05:21.000000"), attr1.getUpdatedAt(), "Customer attributes updated at should be equal"),
                // Customer - 2
                () -> assertEquals(DataType.CUSTOMERS, customers.get(1).getType(), "Customer type should be equal"),
                () -> assertEquals("2", customers.get(1).getId(), "Customer ID should be equal"),
                // Data Attributes - 2
                () -> assertEquals("Brother of Luke Skywalker", attr2.getName(), "Customer attributes name should be equal"),
                () -> assertEquals("lukeskywalker.brother@example.com", attr2.getEmail(), "Customer attributes email should be equal"),
                // Links
                () -> assertEquals("https://api.lemonsqueezy.com/v1/customers/1", customers.get(0).getLinks().getSelf(), "Customer links self should be equal")
        );
    }
}
