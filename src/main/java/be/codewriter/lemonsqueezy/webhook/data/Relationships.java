package be.codewriter.lemonsqueezy.webhook.data;

import be.codewriter.lemonsqueezy.webhook.item.RelationshipItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Relationships {
    @JsonProperty("store")
    private RelationshipItem store;
    @JsonProperty("customer")
    private RelationshipItem customer;
    @JsonProperty("order")
    private RelationshipItem order;
    @JsonProperty("order-item")
    private RelationshipItem orderItem;
    @JsonProperty("product")
    private RelationshipItem product;
    @JsonProperty("variant")
    private RelationshipItem variant;
    @JsonProperty("subscription-items")
    private RelationshipItem subscriptionItems;
    @JsonProperty("subscription-invoices")
    private RelationshipItem subscriptionInvoices;

    public Relationships() {
        // For JSON parsing
    }

    public RelationshipItem getStore() {
        return store;
    }

    public void setStore(RelationshipItem store) {
        this.store = store;
    }

    public RelationshipItem getCustomer() {
        return customer;
    }

    public void setCustomer(RelationshipItem customer) {
        this.customer = customer;
    }

    public RelationshipItem getOrder() {
        return order;
    }

    public void setOrder(RelationshipItem order) {
        this.order = order;
    }

    public RelationshipItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(RelationshipItem orderItem) {
        this.orderItem = orderItem;
    }

    public RelationshipItem getProduct() {
        return product;
    }

    public void setProduct(RelationshipItem product) {
        this.product = product;
    }

    public RelationshipItem getVariant() {
        return variant;
    }

    public void setVariant(RelationshipItem variant) {
        this.variant = variant;
    }

    public RelationshipItem getSubscriptionItems() {
        return subscriptionItems;
    }

    public void setSubscriptionItems(RelationshipItem subscriptionItems) {
        this.subscriptionItems = subscriptionItems;
    }

    public RelationshipItem getSubscriptionInvoices() {
        return subscriptionInvoices;
    }

    public void setSubscriptionInvoices(RelationshipItem subscriptionInvoices) {
        this.subscriptionInvoices = subscriptionInvoices;
    }
}
