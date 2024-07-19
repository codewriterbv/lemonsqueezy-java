package be.codewriter.lemonsqueezy.checkout;

import be.codewriter.lemonsqueezy.generic.Response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * https://docs.lemonsqueezy.com/api/checkouts#the-checkout-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CheckoutResponse extends Response {
    @JsonProperty("data")
    private Checkout checkout;

    public CheckoutResponse() {
        // For JSON parsing
    }

    public Checkout getCheckout() {
        return checkout;
    }

    public void setCheckout(Checkout checkout) {
        this.checkout = checkout;
    }
}
