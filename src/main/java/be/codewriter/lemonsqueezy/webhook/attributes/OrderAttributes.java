package be.codewriter.lemonsqueezy.webhook.attributes;

import be.codewriter.lemonsqueezy.generic.Urls;
import be.codewriter.lemonsqueezy.webhook.item.OrderItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * https://docs.lemonsqueezy.com/api/orders#the-order-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderAttributes {
    @JsonProperty("store_id")
    private Long storeId;
    @JsonProperty("customer_id")
    private Long customerId;
    @JsonProperty("order_number")
    private Long orderNumber;
    @JsonProperty("identifier")
    private UUID identifier;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("user_email")
    private String userEmail;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("currency_rate")
    private String currencyRate;
    @JsonProperty("subtotal")
    private Double subTotal;
    @JsonProperty("subtotal_usd")
    private Double subTotalUsd;
    @JsonProperty("subtotal_formatted")
    private String subTotalFormatted;
    @JsonProperty("discount_total")
    private Double discountTotal;
    @JsonProperty("discount_total_usd")
    private Double discountTotalUsd;
    @JsonProperty("discount_total_formatted")
    private String discountTotalFormatted;
    private Double total;
    @JsonProperty("total_usd")
    private Double totalUsd;
    @JsonProperty("total_formatted")
    private String totalFormatted;
    private Double tax;
    @JsonProperty("tax_usd")
    private Double taxUsd;
    @JsonProperty("tax_rate")
    private Double taxRate;
    @JsonProperty("tax_formatted")
    private String taxFormatted;
    @JsonProperty("tax_name")
    private String taxName;
    @JsonProperty("status")
    private String status;
    @JsonProperty("status_formatted")
    private String statusFormatted;
    @JsonProperty("refunded")
    private Boolean refunded;
    @JsonProperty("first_order_item")
    private OrderItem firstOrderItem;
    @JsonProperty("urls")
    private Urls urls;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
    @JsonProperty("deleted_at")
    private LocalDateTime deletedAt;

    public OrderAttributes() {
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

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(String currencyRate) {
        this.currencyRate = currencyRate;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getSubTotalUsd() {
        return subTotalUsd;
    }

    public void setSubTotalUsd(Double subTotalUsd) {
        this.subTotalUsd = subTotalUsd;
    }

    public String getSubTotalFormatted() {
        return subTotalFormatted;
    }

    public void setSubTotalFormatted(String subTotalFormatted) {
        this.subTotalFormatted = subTotalFormatted;
    }

    public Double getDiscountTotal() {
        return discountTotal;
    }

    public void setDiscountTotal(Double discountTotal) {
        this.discountTotal = discountTotal;
    }

    public Double getDiscountTotalUsd() {
        return discountTotalUsd;
    }

    public void setDiscountTotalUsd(Double discountTotalUsd) {
        this.discountTotalUsd = discountTotalUsd;
    }

    public String getDiscountTotalFormatted() {
        return discountTotalFormatted;
    }

    public void setDiscountTotalFormatted(String discountTotalFormatted) {
        this.discountTotalFormatted = discountTotalFormatted;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTotalUsd() {
        return totalUsd;
    }

    public void setTotalUsd(Double totalUsd) {
        this.totalUsd = totalUsd;
    }

    public String getTotalFormatted() {
        return totalFormatted;
    }

    public void setTotalFormatted(String totalFormatted) {
        this.totalFormatted = totalFormatted;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTaxUsd() {
        return taxUsd;
    }

    public void setTaxUsd(Double taxUsd) {
        this.taxUsd = taxUsd;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public String getTaxFormatted() {
        return taxFormatted;
    }

    public void setTaxFormatted(String taxFormatted) {
        this.taxFormatted = taxFormatted;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
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

    public Boolean getRefunded() {
        return refunded;
    }

    public void setRefunded(Boolean refunded) {
        this.refunded = refunded;
    }

    public OrderItem getFirstOrderItem() {
        return firstOrderItem;
    }

    public void setFirstOrderItem(OrderItem firstOrderItem) {
        this.firstOrderItem = firstOrderItem;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
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
