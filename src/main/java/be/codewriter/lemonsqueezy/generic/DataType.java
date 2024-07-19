package be.codewriter.lemonsqueezy.generic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * https://docs.lemonsqueezy.com/help/webhooks#event-types
 */
public enum DataType {
    CHECKOUT("checkouts"),
    CUSTOMERS("customers"),
    LICENSE_KEYS("license-keys"),
    ORDERS("orders"),
    STORES("stores"),
    SUBSCRIPTIONS("subscriptions"),
    SUBSCRIPTION_INVOICES("subscription-invoices"),
    USERS("users");

    private final String value;

    DataType(String value) {
        this.value = value;
    }

    @JsonCreator
    public static DataType forValue(String value) {
        for (DataType dataType : DataType.values()) {
            if (dataType.getValue().equals(value)) {
                return dataType;
            }
        }
        throw new IllegalArgumentException("Invalid data type value: " + value);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
