package be.codewriter.lemonsqueezy.order;

import be.codewriter.lemonsqueezy.generic.Data;
import be.codewriter.lemonsqueezy.generic.DataType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * https://docs.lemonsqueezy.com/api/orders#the-order-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
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
