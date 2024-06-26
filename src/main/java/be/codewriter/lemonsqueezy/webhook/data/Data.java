package be.codewriter.lemonsqueezy.webhook.data;

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
        @JsonSubTypes.Type(value = Order.class, name = "orders"),
        @JsonSubTypes.Type(value = Subscription.class, name = "subscriptions"),
        @JsonSubTypes.Type(value = SubscriptionInvoice.class, name = "subscription-invoices"),
        @JsonSubTypes.Type(value = LicenseKey.class, name = "license-keys"),
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

