package be.codewriter.lemonsqueezy.checkout;

import be.codewriter.lemonsqueezy.BaseTest;
import be.codewriter.lemonsqueezy.generic.DataType;
import be.codewriter.lemonsqueezy.product.ProductOptions;
import be.codewriter.lemonsqueezy.relationship.RelationshipData;
import be.codewriter.lemonsqueezy.relationship.RelationshipItem;
import be.codewriter.lemonsqueezy.relationship.Relationships;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutTest extends BaseTest {

    @Test
    void shouldParseCheckout() throws IOException {
        Checkout checkout = objectMapper.readValue(loadJson("/lemonsqueezy/checkout/checkout.json"), Checkout.class);
        CheckoutAttributes attr = checkout.getAttributes();
        assertAll(
                () -> assertEquals(DataType.CHECKOUT, checkout.getType(), "Checkout type should be equal"),
                () -> assertEquals("edc0158c-794a-445d-bfad-24ab66baeb01", checkout.getId(), "Checkout ID should be equal"),
                // Data Attributes
                () -> assertNotNull(attr, "Checkout attributes should not be null"),
                () -> assertFalse(attr.getTestMode(), "Checkout attributes name should be equal"),
                () -> assertEquals(1, attr.getStoreId(), "Checkout attributes store ID should be equal"),
                () -> assertEquals(98, attr.getVariantId(), "Checkout attributes variant ID should be equal"),
                () -> assertNull(attr.getCustomerPrice(), "Checkout attributes customer price should be null"),
                () -> assertEquals(LocalDateTime.parse("2022-10-14T10:59:00.000000"), attr.getCreatedAt(), "Checkout attributes created at should be equal"),
                () -> assertEquals(LocalDateTime.parse("2022-10-14T10:59:00.000000"), attr.getUpdatedAt(), "Checkout attributes updated at should be equal"),
                // Data Attributes: Production Options
                () -> assertNotNull(attr.getProductOptions(), "Checkout attributes, product options should not be null"),
                () -> assertEquals("Product X", attr.getProductOptions().getName(), "Checkout attributes, product options, name should be equal"),
                () -> assertEquals("Product description", attr.getProductOptions().getDescription(), "Checkout attributes, product options, name should be equal"),
                // Data Attributes: Checkout Options
                () -> assertNotNull(attr.getCheckoutOptions(), "Checkout attributes, checkout options should not be null"),
                () -> assertFalse(attr.getCheckoutOptions().getEmbed(), "Checkout attributes, checkout options, embed should be false"),
                () -> assertTrue(attr.getCheckoutOptions().getLogo(), "Checkout attributes, checkout options, logo should be true"),
                // Data Attributes: Checkout Data
                () -> assertNotNull(attr.getCheckoutData(), "Checkout attributes, checkout data should not be null"),
                () -> assertEquals("test@test.com", attr.getCheckoutData().getEmail(), "Checkout attributes, product data, email should be equal"),
                // Data Attributes: Preview
                () -> assertNotNull(attr.getPreview(), "Checkout attributes, preview should not be null"),
                () -> assertEquals(1.23456, attr.getPreview().getCurrencyRate(), "Checkout attributes, preview, currency rate should be equal")
        );
    }

    @Test
    void shouldParseCheckoutResponse() throws IOException {
        CheckoutResponse response = objectMapper.readValue(loadJson("/lemonsqueezy/checkout/checkout_response.json"), CheckoutResponse.class);
        Checkout checkout = response.getCheckout();
        CheckoutAttributes attr = checkout.getAttributes();
        assertAll(
                // Json API
                () -> assertEquals("1.0", response.getJsonApi().getVersion(), "Response Json API version should be equal"),
                // checkout
                () -> assertEquals(DataType.CHECKOUT, checkout.getType(), "Checkout type should be equal"),
                () -> assertEquals("5e8b546c-c561-4a2c-a586-40c18bb2a195", checkout.getId(), "Checkout ID should be equal"),
                // Data Attributes
                () -> assertNotNull(attr, "Checkout attributes should not be null"),
                () -> assertFalse(attr.getTestMode(), "Checkout attributes name should be equal"),
                () -> assertEquals(1, attr.getStoreId(), "Checkout attributes name should be equal"),
                /*() -> assertEquals("Luke Skywalker", attr.getName(), "Checkout attributes name should be equal"),
                () -> assertEquals("lukeskywalker@example.com", attr.getEmail(), "Checkout attributes email should be equal"),
                () -> assertEquals("subscribed", attr.getStatus(), "Checkout attributes status should be equal"),
                () -> assertEquals("Subscribed", attr.getStatusFormatted(), "Checkout attributes status formatted should be equal"),
                () -> assertEquals("New York", attr.getCity(), "Checkout attributes city should be equal"),
                () -> assertEquals("NY", attr.getRegion(), "Checkout attributes region should be equal"),
                () -> assertEquals("US", attr.getCountry(), "Checkout attributes country should be equal"),
                () -> assertEquals("United States", attr.getCountryFormatted(), "Checkout attributes country formatted should be equal"),
                () -> assertEquals(0, attr.getTotalRevenueCurrency(), "Checkout attributes total revenue should be equal"),
                () -> assertEquals("$0.00", attr.getTotalRevenueCurrencyFormatted(), "Checkout attributes total revenue formatted should be equal"),
                () -> assertEquals(0, attr.getMonthlyRecurringRevenue(), "Checkout attributes monthly recurring should be equal"),
                () -> assertEquals("$0.00", attr.getMonthlyRecurringRevenueFormatted(), "Checkout attributes monthly recurring formatted should be equal"),
                () -> assertNull(attr.getUrls().getCheckoutPortal(), "Checkout attributes url Checkout portal should be null"),
                () -> assertEquals(LocalDateTime.parse("2022-12-01T13:01:07.000000"), attr.getCreatedAt(), "Checkout attributes created at should be equal"),
                () -> assertEquals(LocalDateTime.parse("2022-12-09T09:05:21.000000"), attr.getUpdatedAt(), "Checkout attributes updated at should be equal"),*/
                // Relationships
                () -> assertEquals("https://api.lemonsqueezy.com/v1/checkouts/5e8b546c-c561-4a2c-a586-40c18bb2a195/store", checkout.getRelationships().getStore().getLinks().getRelated(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/checkouts/5e8b546c-c561-4a2c-a586-40c18bb2a195/relationships/store", checkout.getRelationships().getStore().getLinks().getSelf(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/checkouts/5e8b546c-c561-4a2c-a586-40c18bb2a195/variant", checkout.getRelationships().getVariant().getLinks().getRelated(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/checkouts/5e8b546c-c561-4a2c-a586-40c18bb2a195/relationships/variant", checkout.getRelationships().getVariant().getLinks().getSelf(), "Data Relationship should be equal"),
                // Links
                () -> assertEquals("https://api.lemonsqueezy.com/v1/checkouts/5e8b546c-c561-4a2c-a586-40c18bb2a195", response.getLinks().getSelf(), "Response links self should be equal")
        );
    }


    @Test
    void shouldGenerateCheckoutRequest() throws IOException, JSONException {
        var productOptions = new ProductOptions();
        productOptions.setRedirectUrl("https://test.com");

        var checkoutOptions = new CheckoutOptions();
        checkoutOptions.setButtonColor("#2DD272");

        var checkoutData = new CheckoutData();
        checkoutData.setDiscountCode("10PERCENTOFF");
        checkoutData.setCustom(new CheckoutDataCustom(123));

        CheckoutAttributes attr = new CheckoutAttributes();
        attr.setCustomerPrice(50000.0);
        attr.setProductOptions(productOptions);
        attr.setCheckoutOptions(checkoutOptions);
        attr.setCheckoutData(checkoutData);
        attr.setExpiresAt(LocalDateTime.of(2022, 10, 30, 15, 20, 06));

        var relationships = new Relationships();
        relationships.setStore(new RelationshipItem(new RelationshipData("stores", "1")));
        relationships.setVariant(new RelationshipItem(new RelationshipData("variants", "1")));

        Checkout checkout = new Checkout(attr);
        checkout.setRelationships(relationships);

        JSONAssert.assertEquals(makePrettyJson(objectMapper.readValue(loadJson("/lemonsqueezy/checkout/checkout_request.json"), CheckoutResponse.class)), makePrettyJson(checkout), false);
    }
}
