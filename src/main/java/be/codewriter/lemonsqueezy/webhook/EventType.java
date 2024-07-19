package be.codewriter.lemonsqueezy.webhook;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * https://docs.lemonsqueezy.com/help/webhooks#event-types
 */
public enum EventType {
    ORDER_CREATED("order_created"),
    ORDER_REFUNDED("order_refunded"),
    SUBSCRIPTION_CREATED("subscription_created"),
    SUBSCRIPTION_UPDATED("subscription_updated"),
    SUBSCRIPTION_CANCELLED("subscription_cancelled"),
    SUBSCRIPTION_RESUMED("subscription_resumed"),
    SUBSCRIPTION_EXPIRED("subscription_expired"),
    SUBSCRIPTION_PAUSED("subscription_paused"),
    SUBSCRIPTION_UNPAUSED("subscription_unpaused"),
    SUBSCRIPTION_PAYMENT_SUCCESS("subscription_payment_success"),
    SUBSCRIPTION_PAYMENT_FAILED("subscription_payment_failed"),
    SUBSCRIPTION_PAYMENT_RECOVERED("subscription_payment_recovered"),
    SUBSCRIPTION_PAYMENT_REFUNDED("subscription_payment_refunded"),
    SUBSCRIPTION_LICENSE_KEY_CREATED("license_key_created"),
    SUBSCRIPTION_LICENSE_KEY_UPDATED("license_key_updated"),
    UNDEFINED("");

    private final String label;

    EventType(String label) {
        this.label = label;
    }

    @JsonCreator
    public static EventType fromValue(String value) {
        for (EventType eventType : EventType.values()) {
            if (eventType.getLabel().equals(value)) {
                return eventType;
            }
        }
        return UNDEFINED;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }
}
