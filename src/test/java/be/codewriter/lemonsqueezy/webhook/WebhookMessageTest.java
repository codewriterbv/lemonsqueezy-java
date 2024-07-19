package be.codewriter.lemonsqueezy.webhook;

import be.codewriter.lemonsqueezy.BaseTest;
import be.codewriter.lemonsqueezy.generic.DataType;
import be.codewriter.lemonsqueezy.license.LicenseKeyAttributes;
import be.codewriter.lemonsqueezy.order.OrderAttributes;
import be.codewriter.lemonsqueezy.subscription.SubscriptionAttributes;
import be.codewriter.lemonsqueezy.subscription.SubscriptionInvoiceAttributes;
import be.codewriter.lemonsqueezy.license.LicenseKey;
import be.codewriter.lemonsqueezy.order.Order;
import be.codewriter.lemonsqueezy.subscription.Subscription;
import be.codewriter.lemonsqueezy.subscription.SubscriptionInvoice;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class WebhookMessageTest extends BaseTest {

    @Test
    void shouldParseMinimal() throws IOException {
        WebhookMessage message = objectMapper.readValue(loadJson("/lemonsqueezy/webhook/minimal.json"), WebhookMessage.class);
        assertAll(
                // Meta
                () -> assertNotNull(message.getMeta(), "Meta should not be null"),
                () -> assertEquals(UUID.fromString("c3c57ee7-4dc7-4ff6-875e-63455b3cf829"), message.getMeta().getId(), "Meta ID should be equal"),
                () -> assertEquals(EventType.ORDER_CREATED, message.getMeta().getType(), "Meta type should be equal"),
                // Data
                () -> assertNotNull(message.getData(), "Data should not be null"),
                () -> assertEquals("2925880", message.getData().getId(), "Data id should not be null"),
                () -> assertEquals(DataType.ORDERS, message.getData().getType(), "Data type should be equal")
        );
    }

    @Test
    void shouldParseLicenseKeyCreated() throws IOException {
        WebhookMessage message = objectMapper.readValue(loadJson("/lemonsqueezy/webhook/license_key_created.json"), WebhookMessage.class);
        LicenseKeyAttributes attr = ((LicenseKey) message.getData()).getAttributes();
        assertAll(
                // Meta
                () -> assertNotNull(message.getMeta(), "Meta should not be null"),
                () -> assertEquals(UUID.fromString("919979c4-6ca1-430d-8ca5-0a083e9a2c92"), message.getMeta().getId(), "Meta ID should be equal"),
                // Data
                () -> assertNotNull(message.getData(), "Data should not be null"),
                () -> assertEquals("536156", message.getData().getId(), "Data id should not be null"),
                () -> assertEquals(DataType.LICENSE_KEYS, message.getData().getType(), "Data type should be equal"),
                // Data Attributes
                () -> assertNotNull(attr, "Data attributes should not be null"),
                () -> assertEquals(91257, attr.getStoreId(), "Data attributes store ID should be equal"),
                () -> assertEquals(3083767, attr.getCustomerId(), "Data attributes customer ID should be equal"),
                () -> assertEquals(2925880, attr.getOrderId(), "Data attributes order ID should be equal"),
                () -> assertEquals(2881059, attr.getOrderItemId(), "Data attributes order item ID should be equal"),
                () -> assertEquals(278897, attr.getProductId(), "Data attributes product ID should be equal"),
                () -> assertEquals("Mr. X and Mrs. Y", attr.getUserName(), "Data attributes user name should be equal"),
                () -> assertEquals("test@company.com", attr.getUserEmail(), "Data attributes user email should be equal"),
                () -> assertEquals("7A5472DB-C5B9-459E-9F6D-FAE467F0B28E", attr.getKey(), "Data attributes key should be equal"),
                () -> assertEquals("XXXX-FAE467F0B28E", attr.getKeyShort(), "Data attributes key short should be equal"),
                () -> assertEquals(1, attr.getActivationLimit(), "Data attributes activation limit should be equal"),
                () -> assertNull(attr.getInstancesCount(), "Data attributes instances count should be null"),
                () -> assertFalse(attr.getDisabled(), "Data attributes disabled should be false"),
                () -> assertEquals("inactive", attr.getStatus(), "Data attributes status should be equal"),
                () -> assertEquals("Inactive", attr.getStatusFormatted(), "Data attributes status formatted should be equal"),
                () -> assertNull(attr.getExpiresAt(), "Data attributes expires at should be null"),
                () -> assertEquals(LocalDateTime.parse("2024-06-19T14:08:15.000000"), attr.getCreatedAt(), "Data attributes created at should be equal"),
                () -> assertEquals(LocalDateTime.parse("2024-06-19T14:08:15.000000"), attr.getUpdatedAt(), "Data attributes updated at should be equal")
        );
    }

    @Test
    void shouldParseOrderCreated() throws IOException {
        WebhookMessage message = objectMapper.readValue(loadJson("/lemonsqueezy/webhook/order_created.json"), WebhookMessage.class);
        OrderAttributes attr = ((Order) message.getData()).getAttributes();
        assertAll(
                // Meta
                () -> assertNotNull(message.getMeta(), "Meta should not be null"),
                () -> assertEquals(UUID.fromString("c3c57ee7-4dc7-4ff6-875e-63455b3cf829"), message.getMeta().getId(), "Meta ID should be equal"),
                // Data
                () -> assertNotNull(message.getData(), "Data should not be null"),
                () -> assertEquals("2925880", message.getData().getId(), "Data id should not be null"),
                () -> assertEquals(DataType.ORDERS, message.getData().getType(), "Data type should be equal"),
                // Data Attributes
                () -> assertNotNull(attr, "Data attributes should not be null"),
                () -> assertEquals(91257, attr.getStoreId(), "Data attributes store ID should be equal"),
                () -> assertEquals(3083767, attr.getCustomerId(), "Data attributes customer ID should be equal"),
                () -> assertEquals(UUID.fromString("62acd246-fb68-46f0-94d1-5879182773b7"), attr.getIdentifier(), "Data attributes identifier should be equal"),
                () -> assertEquals(912571, attr.getOrderNumber(), "Data attributes order number should be equal"),
                () -> assertEquals("Mr. X and Mrs. Y", attr.getUserName(), "Data attributes user name should be equal"),
                () -> assertEquals("test@company.com", attr.getUserEmail(), "Data attributes user email should be equal"),
                () -> assertEquals("\u20ac0.00", attr.getTaxFormatted(), "Data attributes tax formatted should be equal"),
                () -> assertEquals("\u20ac19.99", attr.getTotalFormatted(), "Data attributes total formatted should be equal"),
                () -> assertEquals(278897, attr.getFirstOrderItem().getProductId(), "Data attributes first order item product id should be equal"),
                () -> assertEquals("MelodyMatrix (1 year subscription)", attr.getFirstOrderItem().getProductName(), "Data attributes first order product name should be equal"),
                () -> assertEquals(LocalDateTime.parse("2024-06-19T14:08:14.000000"), attr.getFirstOrderItem().getCreatedAt(), "Data attributes first order item created at should be equal"),
                () -> assertEquals("https://app.lemonsqueezy.com/my-orders/62acd246-fb68-46f0-94d1-5879182773b7?signature=44ac813b596ec2dbe724c011b3fc8d8648cdc6293a977df815b063e3d41cb69d", attr.getUrls().getReceipt(), "Data attributes urls receipt should be equal")
        );
    }

    @Test
    void shouldParseSubscriptionCreated() throws IOException {
        WebhookMessage message = objectMapper.readValue(loadJson("/lemonsqueezy/webhook/subscription_created.json"), WebhookMessage.class);
        SubscriptionAttributes attr = ((Subscription) message.getData()).getAttributes();
        assertAll(
                // Meta
                () -> assertNotNull(message.getMeta(), "Meta should not be null"),
                () -> assertEquals(UUID.fromString("0a56770f-2096-43b9-821e-8340a2917b6d"), message.getMeta().getId(), "Meta ID should be equal"),
                // Data
                () -> assertNotNull(message.getData(), "Data should not be null"),
                () -> assertEquals("421953", message.getData().getId(), "Data id should not be null"),
                () -> assertEquals(DataType.SUBSCRIPTIONS, message.getData().getType(), "Data type should be equal"),
                // Data Attributes
                () -> assertNotNull(attr, "Data attributes should not be null"),
                () -> assertEquals(91257, attr.getStoreId(), "Data attributes store ID should be equal"),
                () -> assertEquals(3083767, attr.getCustomerId(), "Data attributes customer ID should be equal"),
                () -> assertEquals(2925880, attr.getOrderId(), "Data attributes order ID should be equal"),
                () -> assertEquals(2881059, attr.getOrderItemId(), "Data attributes order item ID should be equal"),
                () -> assertEquals(278897, attr.getProductId(), "Data attributes product ID should be equal"),
                () -> assertEquals(394420, attr.getVariantId(), "Data attributes variant ID should be equal"),
                () -> assertEquals("MelodyMatrix (1 year subscription)", attr.getProductName(), "Data attributes product name should be equal"),
                () -> assertEquals("Default", attr.getVariantName(), "Data attributes variant name should be equal"),
                () -> assertEquals("Mr. X and Mrs. Y", attr.getUserName(), "Data attributes user name should be equal"),
                () -> assertEquals("test@company.com", attr.getUserEmail(), "Data attributes user email should be equal"),
                () -> assertEquals("active", attr.getStatus(), "Data attributes status should be equal"),
                () -> assertEquals("Active", attr.getStatusFormatted(), "Data attributes status formatted should be equal"),
                () -> assertEquals("visa", attr.getCardBrand(), "Data attributes card brand should be equal"),
                () -> assertEquals("4242", attr.getCardLastFour(), "Data attributes card last four should be equal"),
                () -> assertNull(attr.getPause(), "Data attributes pause should be null"),
                () -> assertFalse(attr.getCancelled(), "Data attributes cancelled should be false"),
                () -> assertNull(attr.getTrialEndsAt(), "Data attributes trial ends at should be null"),
                () -> assertEquals(19, attr.getBillingAnchor(), "Data attributes billing anchor should be equal"),
                () -> assertTrue(attr.getTestMode(), "Data attributes test mode should be true"),

                () -> assertNotNull(attr.getFirstSubscriptionItem(), "Data attributes first subscription item should not be null"),
                () -> assertEquals(355942, attr.getFirstSubscriptionItem().getId(), "Data attributes first subscription item ID should be equal"),
                () -> assertEquals(421953, attr.getFirstSubscriptionItem().getSubscriptionId(), "Data attributes first subscription item subscription ID should be equal"),
                () -> assertEquals(571912, attr.getFirstSubscriptionItem().getPriceId(), "Data attributes first subscription item price ID should be equal"),
                () -> assertEquals(1, attr.getFirstSubscriptionItem().getQuantity(), "Data attributes first subscription item quantity should be equal"),
                () -> assertFalse(attr.getFirstSubscriptionItem().getUsageBased(), "Data attributes first subscription item usage based should be null"),
                () -> assertEquals(LocalDateTime.parse("2024-06-19T14:08:15.000000"), attr.getFirstSubscriptionItem().getCreatedAt(), "Data attributes first subscription item created at should be equal"),
                () -> assertEquals(LocalDateTime.parse("2024-06-19T14:08:15.000000"), attr.getFirstSubscriptionItem().getUpdatedAt(), "Data attributes first subscription item updated at should be equal"),

                () -> assertEquals(LocalDateTime.parse("2025-06-19T14:08:09.000000"), attr.getRenewsAt(), "Data attributes renews at should be equal"),
                () -> assertNull(attr.getEndsAt(), "Data attributes ends at should be null"),
                () -> assertEquals(LocalDateTime.parse("2024-06-19T14:08:10.000000"), attr.getCreatedAt(), "Data attributes created at should be equal"),
                () -> assertEquals(LocalDateTime.parse("2024-06-19T14:08:14.000000"), attr.getUpdatedAt(), "Data attributes updated at should be equal"),

                // Data Relationships
                () -> assertEquals("https://api.lemonsqueezy.com/v1/subscriptions/421953/store", message.getData().getRelationships().getStore().getLinks().getRelated(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/subscriptions/421953/relationships/store", message.getData().getRelationships().getStore().getLinks().getSelf(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/subscriptions/421953/customer", message.getData().getRelationships().getCustomer().getLinks().getRelated(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/subscriptions/421953/relationships/customer", message.getData().getRelationships().getCustomer().getLinks().getSelf(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/subscriptions/421953/order", message.getData().getRelationships().getOrder().getLinks().getRelated(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/subscriptions/421953/relationships/order", message.getData().getRelationships().getOrder().getLinks().getSelf(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/subscriptions/421953/order-item", message.getData().getRelationships().getOrderItem().getLinks().getRelated(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/subscriptions/421953/relationships/order-item", message.getData().getRelationships().getOrderItem().getLinks().getSelf(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/subscriptions/421953/product", message.getData().getRelationships().getProduct().getLinks().getRelated(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/subscriptions/421953/relationships/product", message.getData().getRelationships().getProduct().getLinks().getSelf(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/subscriptions/421953/variant", message.getData().getRelationships().getVariant().getLinks().getRelated(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/subscriptions/421953/relationships/variant", message.getData().getRelationships().getVariant().getLinks().getSelf(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/subscriptions/421953/subscription-items", message.getData().getRelationships().getSubscriptionItems().getLinks().getRelated(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/subscriptions/421953/relationships/subscription-items", message.getData().getRelationships().getSubscriptionItems().getLinks().getSelf(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/subscriptions/421953/subscription-invoices", message.getData().getRelationships().getSubscriptionInvoices().getLinks().getRelated(), "Data Relationship should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/subscriptions/421953/relationships/subscription-invoices", message.getData().getRelationships().getSubscriptionInvoices().getLinks().getSelf(), "Data Relationship should be equal"),

                () -> assertEquals("https://api.lemonsqueezy.com/v1/subscriptions/421953", message.getData().getLinks().getSelf(), "Data Links should be equal")
        );
    }

    @Test
    void shouldParseSubscriptionUpdated() throws IOException {
        WebhookMessage message = objectMapper.readValue(loadJson("/lemonsqueezy/webhook/subscription_updated.json"), WebhookMessage.class);
        SubscriptionAttributes attr = ((Subscription) message.getData()).getAttributes();
        assertAll(
                // Meta
                () -> assertNotNull(message.getMeta(), "Meta should not be null"),
                () -> assertEquals(UUID.fromString("36c4d6ea-c859-4f3c-998b-b4426917af44"), message.getMeta().getId(), "Meta ID should be equal"),
                // Data
                () -> assertNotNull(message.getData(), "Data should not be null"),
                () -> assertEquals("421953", message.getData().getId(), "Data id should not be null"),
                () -> assertEquals(DataType.SUBSCRIPTIONS, message.getData().getType(), "Data type should be equal"),
                // Data Attributes
                () -> assertNotNull(attr, "Data attributes should not be null"),
                () -> assertEquals(91257, attr.getStoreId(), "Data attributes store ID should be equal"),
                () -> assertEquals(3083767, attr.getCustomerId(), "Data attributes customer ID should be equal"),
                () -> assertEquals(2925880, attr.getOrderId(), "Data attributes order ID should be equal"),
                () -> assertEquals(2881059, attr.getOrderItemId(), "Data attributes order item ID should be equal"),
                () -> assertEquals(278897, attr.getProductId(), "Data attributes product ID should be equal"),
                () -> assertEquals(394420, attr.getVariantId(), "Data attributes variant ID should be equal"),
                () -> assertEquals("MelodyMatrix (1 year subscription)", attr.getProductName(), "Data attributes product name should be equal"),
                () -> assertEquals("Default", attr.getVariantName(), "Data attributes variant name should be equal"),
                () -> assertEquals("Mr. X and Mrs. Y", attr.getUserName(), "Data attributes user name should be equal"),
                () -> assertEquals("test@company.com", attr.getUserEmail(), "Data attributes user email should be equal"),
                () -> assertEquals("active", attr.getStatus(), "Data attributes status should be equal"),
                () -> assertEquals("Active", attr.getStatusFormatted(), "Data attributes status formatted should be equal"),
                () -> assertEquals("visa", attr.getCardBrand(), "Data attributes card brand should be equal"),
                () -> assertEquals("4242", attr.getCardLastFour(), "Data attributes card last four should be equal"),
                () -> assertNull(attr.getPause(), "Data attributes pause should be null"),
                () -> assertFalse(attr.getCancelled(), "Data attributes cancelled should be false"),
                () -> assertNull(attr.getTrialEndsAt(), "Data attributes trial ends at should be null"),
                () -> assertEquals(19, attr.getBillingAnchor(), "Data attributes billing anchor should be equal"),
                () -> assertTrue(attr.getTestMode(), "Data attributes test mode should be true"),
                () -> assertEquals(LocalDateTime.parse("2024-06-19T14:08:13.000000"), attr.getRenewsAt(), "Data attributes renews at at should be equal"),
                () -> assertNull(attr.getEndsAt(), "Data attributes ends at should be null"),
                () -> assertEquals(LocalDateTime.parse("2024-06-19T14:08:10.000000"), attr.getCreatedAt(), "Data attributes created at should be equal"),
                () -> assertEquals(LocalDateTime.parse("2024-06-19T14:08:14.000000"), attr.getUpdatedAt(), "Data attributes updated at should be equal")
        );
    }

    @Test
    void shouldParseSubscriptionPaymentSuccess() throws IOException {
        WebhookMessage message = objectMapper.readValue(loadJson("/lemonsqueezy/webhook/subscription_payment_success.json"), WebhookMessage.class);
        SubscriptionInvoiceAttributes attr = ((SubscriptionInvoice) message.getData()).getAttributes();
        assertAll(
                // Meta
                () -> assertNotNull(message.getMeta(), "Meta should not be null"),
                () -> assertEquals(UUID.fromString("f61d9089-9ca1-4753-9b9b-19710c27d0a9"), message.getMeta().getId(), "Meta ID should be equal"),
                // Data
                () -> assertNotNull(message.getData(), "Data should not be null"),
                () -> assertEquals("1134198", message.getData().getId(), "Data id should not be null"),
                () -> assertEquals(DataType.SUBSCRIPTION_INVOICES, message.getData().getType(), "Data type should be equal"),
                // Data Attributes
                () -> assertNotNull(attr, "Data attributes should not be null"),
                () -> assertEquals(91257, attr.getStoreId(), "Data attributes store ID should be equal"),
                () -> assertEquals(421953, attr.getSubscriptionId(), "Data attributes order number should be equal"),
                () -> assertEquals(3083767, attr.getCustomerId(), "Data attributes customer ID should be equal"),
                () -> assertEquals("Mr. X and Mrs. Y", attr.getUserName(), "Data attributes user name should be equal"),
                () -> assertEquals("test@company.com", attr.getUserEmail(), "Data attributes user email should be equal"),
                () -> assertEquals("initial", attr.getBillingReason(), "Data attributes billing reason should be equal"),
                () -> assertEquals("visa", attr.getCardBrand(), "Data attributes card brand should be equal"),
                () -> assertEquals("4242", attr.getCardLastFour(), "Data attributes card last four should be equal"),
                () -> assertEquals("EUR", attr.getCurrency(), "Data attributes currency should be equal"),
                () -> assertEquals("1.07424309", attr.getCurrencyRate(), "Data attributes currency rate should be equal"),
                () -> assertEquals("paid", attr.getStatus(), "Data attributes status should be equal"),
                () -> assertEquals("Paid", attr.getStatusFormatted(), "Data attributes status formatted should be equal"),
                () -> assertFalse(attr.getRefunded(), "Data attributes refunded should be false"),
                () -> assertEquals(1999, attr.getSubtotal(), "Data attributes sub total should be equal"),
                () -> assertEquals(0, attr.getDiscountTotal(), "Data attributes discount total should be equal"),
                () -> assertTrue(attr.getTaxInclusive(), "Data attributes tax inclusive should be true"),
                () -> assertEquals(1999, attr.getTotal(), "Data attributes total should be equal"),
                () -> assertEquals(2147, attr.getSubtotalUsd(), "Data attributes sub total USD should be equal"),
                () -> assertEquals(0, attr.getDiscountTotalUsd(), "Data attributes discount total USD should be equal"),
                () -> assertEquals(0, attr.getTaxUsd(), "Data attributes tax USD should be equal"),
                () -> assertEquals(2147, attr.getTotalUsd(), "Data attributes total USD should be equal"),
                () -> assertEquals("\u20ac19.99", attr.getSubtotalformatted(), "Data attributes sub total formatted should be equal"),
                () -> assertEquals("\u20ac0.00", attr.getDiscountTotalFormatted(), "Data attributes discount total formatted should be equal"),
                () -> assertEquals("\u20ac0.00", attr.getTaxFormatted(), "Data attributes tax formatted should be equal"),
                () -> assertEquals("\u20ac19.99", attr.getTotalformatted(), "Data attributes total formatted should be equal"),
                () -> assertEquals(LocalDateTime.parse("2024-06-19T14:08:13.000000"), attr.getCreatedAt(), "Data attributes created at should be equal"),
                () -> assertEquals(LocalDateTime.parse("2024-06-19T14:08:15.000000"), attr.getUpdatedAt(), "Data attributes updated at should be equal"),
                () -> assertTrue(attr.getTestMode(), "Data attributes test mode should be true")
        );
    }
}
