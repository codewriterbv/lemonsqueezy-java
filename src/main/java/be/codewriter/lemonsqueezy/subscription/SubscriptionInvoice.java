package be.codewriter.lemonsqueezy.subscription;

import be.codewriter.lemonsqueezy.generic.Data;
import be.codewriter.lemonsqueezy.generic.DataType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * https://docs.lemonsqueezy.com/api/subscription-invoices#the-subscription-invoice-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
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
