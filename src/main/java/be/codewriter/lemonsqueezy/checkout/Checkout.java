package be.codewriter.lemonsqueezy.checkout;

import be.codewriter.lemonsqueezy.generic.Data;
import be.codewriter.lemonsqueezy.generic.DataType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * https://docs.lemonsqueezy.com/api/checkouts#the-checkout-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Checkout extends Data {
    private CheckoutAttributes attributes;

    public Checkout() {
        // For JSON parsing
        setType(DataType.CHECKOUT);
    }

    public CheckoutAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(CheckoutAttributes attributes) {
        this.attributes = attributes;
    }
}
