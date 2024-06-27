package be.codewriter.lemonsqueezy.webhook.data;

import be.codewriter.lemonsqueezy.generic.Data;
import be.codewriter.lemonsqueezy.generic.DataType;
import be.codewriter.lemonsqueezy.webhook.attributes.SubscriptionInvoiceAttributes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * https://docs.lemonsqueezy.com/api/subscription-invoices#the-subscription-invoice-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionInvoice extends Data {
    private SubscriptionInvoiceAttributes attributes;

    public SubscriptionInvoice() {
        // For JSON parsing
        setType(DataType.SUBSCRIPTION_INVOICES);
    }

    public SubscriptionInvoiceAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(SubscriptionInvoiceAttributes attributes) {
        this.attributes = attributes;
    }
}
