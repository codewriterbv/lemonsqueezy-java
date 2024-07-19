package be.codewriter.lemonsqueezy.generic;

import be.codewriter.lemonsqueezy.checkout.Checkout;
import be.codewriter.lemonsqueezy.customer.Customer;
import be.codewriter.lemonsqueezy.license.LicenseKey;
import be.codewriter.lemonsqueezy.order.Order;
import be.codewriter.lemonsqueezy.relationship.Relationships;
import be.codewriter.lemonsqueezy.store.Store;
import be.codewriter.lemonsqueezy.subscription.Subscription;
import be.codewriter.lemonsqueezy.subscription.SubscriptionInvoice;
import be.codewriter.lemonsqueezy.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * https://docs.lemonsqueezy.com/help/webhooks#event-types
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Checkout.class, name = "checkouts"),
        @JsonSubTypes.Type(value = Customer.class, name = "customers"),
        @JsonSubTypes.Type(value = LicenseKey.class, name = "license-keys"),
        @JsonSubTypes.Type(value = Order.class, name = "orders"),
        @JsonSubTypes.Type(value = Store.class, name = "stores"),
        @JsonSubTypes.Type(value = Subscription.class, name = "subscriptions"),
        @JsonSubTypes.Type(value = SubscriptionInvoice.class, name = "subscription-invoices"),
        @JsonSubTypes.Type(value = User.class, name = "users"),
})
public abstract class Data {
    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private DataType type;
    @JsonProperty("relationships")
    private Relationships relationships;
    @JsonProperty("links")
    private Links links;

    public Data() {
        // For JSON parsing
    }

    public DataType getType() {
        return type;
    }

    public void setType(DataType type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Relationships getRelationships() {
        return relationships;
    }

    public void setRelationships(Relationships relationships) {
        this.relationships = relationships;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
