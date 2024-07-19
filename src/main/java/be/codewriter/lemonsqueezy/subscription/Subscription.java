package be.codewriter.lemonsqueezy.subscription;

import be.codewriter.lemonsqueezy.generic.Data;
import be.codewriter.lemonsqueezy.generic.DataType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * https://docs.lemonsqueezy.com/api/subscriptions#the-subscription-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Subscription extends Data {
    private SubscriptionAttributes attributes;

    public Subscription() {
        // For JSON parsing
        setType(DataType.SUBSCRIPTIONS);
    }

    public SubscriptionAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(SubscriptionAttributes attributes) {
        this.attributes = attributes;
    }
}
