package be.codewriter.lemonsqueezy.webhook.data.attributes;

import be.codewriter.lemonsqueezy.webhook.data.item.SubscriptionItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

/**
 * https://docs.lemonsqueezy.com/api/subscriptions#the-subscription-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionAttributes {
    @JsonProperty("store_id")
    private Long storeId;
    @JsonProperty("customer_id")
    private Long customerId;
    @JsonProperty("order_id")
    private Long orderId;
    @JsonProperty("order_item_id")
    private Long orderItemId;
    @JsonProperty("product_id")
    private Long productId;
    @JsonProperty("variant_id")
    private Long variantId;
    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("variant_name")
    private String variantName;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("user_email")
    private String userEmail;
    @JsonProperty("status")
    private String status;
    @JsonProperty("status_formatted")
    private String statusFormatted;
    @JsonProperty("card_brand")
    private String cardBrand;
    @JsonProperty("card_last_four")
    private String cardLastFour;
    @JsonProperty("pause")
    private String pause;
    @JsonProperty("cancelled")
    private Boolean cancelled;
    @JsonProperty("billing_anchor")
    private Long billingAnchor;

    @JsonProperty("first_subscription_item")
    private SubscriptionItem firstSubscriptionItem;

    @JsonProperty("trial_ends_at")
    private LocalDateTime trialEndsAt;
    @JsonProperty("renews_at")
    private LocalDateTime renewsAt;
    @JsonProperty("ends_at")
    private LocalDateTime endsAt;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @JsonProperty("test_mode")
    private Boolean testMode;

    public SubscriptionAttributes() {
        // For JSON parsing
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getVariantId() {
        return variantId;
    }

    public void setVariantId(Long variantId) {
        this.variantId = variantId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getVariantName() {
        return variantName;
    }

    public void setVariantName(String variantName) {
        this.variantName = variantName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusFormatted() {
        return statusFormatted;
    }

    public void setStatusFormatted(String statusFormatted) {
        this.statusFormatted = statusFormatted;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }

    public String getCardLastFour() {
        return cardLastFour;
    }

    public void setCardLastFour(String cardLastFour) {
        this.cardLastFour = cardLastFour;
    }

    public String getPause() {
        return pause;
    }

    public void setPause(String pause) {
        this.pause = pause;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

    public Long getBillingAnchor() {
        return billingAnchor;
    }

    public void setBillingAnchor(Long billingAnchor) {
        this.billingAnchor = billingAnchor;
    }

    public SubscriptionItem getFirstSubscriptionItem() {
        return firstSubscriptionItem;
    }

    public void setFirstSubscriptionItem(SubscriptionItem firstSubscriptionItem) {
        this.firstSubscriptionItem = firstSubscriptionItem;
    }

    public LocalDateTime getTrialEndsAt() {
        return trialEndsAt;
    }

    public void setTrialEndsAt(LocalDateTime trialEndsAt) {
        this.trialEndsAt = trialEndsAt;
    }

    public LocalDateTime getRenewsAt() {
        return renewsAt;
    }

    public void setRenewsAt(LocalDateTime renewsAt) {
        this.renewsAt = renewsAt;
    }

    public LocalDateTime getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(LocalDateTime endsAt) {
        this.endsAt = endsAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getTestMode() {
        return testMode;
    }

    public void setTestMode(Boolean testMode) {
        this.testMode = testMode;
    }
}
