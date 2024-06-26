package be.codewriter.lemonsqueezy.webhook.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Relationships {
    @JsonProperty("store")
    private Relationship store;
    @JsonProperty("customer")
    private Relationship customer;
    @JsonProperty("order")
    private Relationship order;
    @JsonProperty("order-item")
    private Relationship orderItem;
    @JsonProperty("product")
    private Relationship product;
    @JsonProperty("variant")
    private Relationship variant;
    @JsonProperty("subscription-items")
    private Relationship subscriptionItems;
    @JsonProperty("subscription-invoices")
    private Relationship subscriptionInvoices;

    public Relationships() {
        // For JSON parsing
    }

    public Relationship getStore() {
        return store;
    }

    public void setStore(Relationship store) {
        this.store = store;
    }

    public Relationship getCustomer() {
        return customer;
    }

    public void setCustomer(Relationship customer) {
        this.customer = customer;
    }

    public Relationship getOrder() {
        return order;
    }

    public void setOrder(Relationship order) {
        this.order = order;
    }

    public Relationship getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(Relationship orderItem) {
        this.orderItem = orderItem;
    }

    public Relationship getProduct() {
        return product;
    }

    public void setProduct(Relationship product) {
        this.product = product;
    }

    public Relationship getVariant() {
        return variant;
    }

    public void setVariant(Relationship variant) {
        this.variant = variant;
    }

    public Relationship getSubscriptionItems() {
        return subscriptionItems;
    }

    public void setSubscriptionItems(Relationship subscriptionItems) {
        this.subscriptionItems = subscriptionItems;
    }

    public Relationship getSubscriptionInvoices() {
        return subscriptionInvoices;
    }

    public void setSubscriptionInvoices(Relationship subscriptionInvoices) {
        this.subscriptionInvoices = subscriptionInvoices;
    }
}
