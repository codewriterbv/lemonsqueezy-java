package be.codewriter.lemonsqueezy.webhook.data;

import be.codewriter.lemonsqueezy.generic.Data;
import be.codewriter.lemonsqueezy.generic.DataType;
import be.codewriter.lemonsqueezy.webhook.attributes.OrderAttributes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * https://docs.lemonsqueezy.com/api/orders#the-order-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order extends Data {
    private OrderAttributes attributes;

    public Order() {
        // For JSON parsing
        setType(DataType.ORDERS);
    }

    public OrderAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(OrderAttributes attributes) {
        this.attributes = attributes;
    }
}
