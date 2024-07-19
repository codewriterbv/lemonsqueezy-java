package be.codewriter.lemonsqueezy.relationship;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Relationships {
    @JsonProperty("store")
    private RelationshipItem store;
    @JsonProperty("customer")
    private RelationshipItem customer;
    @JsonProperty("order")
    private RelationshipItem order;
    @JsonProperty("orders")
    private RelationshipItem orders;
    @JsonProperty("order-item")
    private RelationshipItem orderItem;
    @JsonProperty("product")
    private RelationshipItem product;
    @JsonProperty("products")
    private RelationshipItem products;
    @JsonProperty("variant")
    private RelationshipItem variant;
    @JsonProperty("discounts")
    private RelationshipItem discounts;
    @JsonProperty("subscriptions")
    private RelationshipItem subscriptions;
    @JsonProperty("subscription-items")
    private RelationshipItem subscriptionItems;
    @JsonProperty("subscription-invoices")
    private RelationshipItem subscriptionInvoices;
    @JsonProperty("license-keys")
    private RelationshipItem licenseKeys;

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

    public RelationshipItem getOrders() {
        return orders;
    }

    public void setOrders(RelationshipItem orders) {
        this.orders = orders;
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

    public RelationshipItem getProducts() {
        return products;
    }

    public void setProducts(RelationshipItem products) {
        this.products = products;
    }

    public RelationshipItem getVariant() {
        return variant;
    }

    public void setVariant(RelationshipItem variant) {
        this.variant = variant;
    }

    public RelationshipItem getDiscounts() {
        return discounts;
    }

    public void setDiscounts(RelationshipItem discounts) {
        this.discounts = discounts;
    }

    public RelationshipItem getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(RelationshipItem subscriptions) {
        this.subscriptions = subscriptions;
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

    public RelationshipItem getLicenseKeys() {
        return licenseKeys;
    }

    public void setLicenseKeys(RelationshipItem licenseKeys) {
        this.licenseKeys = licenseKeys;
    }
}
