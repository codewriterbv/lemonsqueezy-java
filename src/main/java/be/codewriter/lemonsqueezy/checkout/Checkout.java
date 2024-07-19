package be.codewriter.lemonsqueezy.checkout;

import be.codewriter.lemonsqueezy.generic.Data;
import be.codewriter.lemonsqueezy.generic.DataType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * https://docs.lemonsqueezy.com/api/checkouts#the-checkout-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Checkout extends Data {
    private CheckoutAttributes attributes;

    public Checkout() {
        // For JSON parsing
        setType(DataType.CHECKOUT);
    }

    public Checkout(CheckoutAttributes attributes) {
        this.attributes = attributes;
    }

    public CheckoutAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(CheckoutAttributes attributes) {
        this.attributes = attributes;
    }
}
