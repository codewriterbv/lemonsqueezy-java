package be.codewriter.lemonsqueezy.webhook.data.attributes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

/**
 * https://docs.lemonsqueezy.com/api/license-keys#the-license-key-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LicenseKeyAttributes {
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
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("user_email")
    private String userEmail;
    @JsonProperty("key")
    private String key;
    @JsonProperty("key_short")
    private String keyShort;
    @JsonProperty("activation_limit")
    private Integer activationLimit;
    @JsonProperty("instances_count")
    private Integer instancesCount;
    @JsonProperty("disabled")
    private Boolean disabled;
    @JsonProperty("status")
    private String status;
    @JsonProperty("status_formatted")
    private String statusFormatted;
    @JsonProperty("expires_at")
    private LocalDateTime expiresAt;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    public LicenseKeyAttributes() {
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKeyShort() {
        return keyShort;
    }

    public void setKeyShort(String keyShort) {
        this.keyShort = keyShort;
    }

    public Integer getActivationLimit() {
        return activationLimit;
    }

    public void setActivationLimit(Integer activationLimit) {
        this.activationLimit = activationLimit;
    }

    public Integer getInstancesCount() {
        return instancesCount;
    }

    public void setInstancesCount(Integer instancesCount) {
        this.instancesCount = instancesCount;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
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

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
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
}
