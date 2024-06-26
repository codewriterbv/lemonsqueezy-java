package be.codewriter.lemonsqueezy.webhook.data;

import be.codewriter.lemonsqueezy.webhook.data.attributes.SubscriptionAttributes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * https://docs.lemonsqueezy.com/api/subscriptions#the-subscription-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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
