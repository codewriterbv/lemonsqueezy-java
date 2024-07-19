package be.codewriter.lemonsqueezy.subscription;

import be.codewriter.lemonsqueezy.BaseAttributes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * https://docs.lemonsqueezy.com/api/subscription-invoices#the-subscription-invoice-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubscriptionInvoiceAttributes extends BaseAttributes {

    @JsonProperty("subscription_id")
    private Long subscriptionId;
    @JsonProperty("customer_id")
    private Long customerId;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("user_email")
    private String userEmail;
    @JsonProperty("billing_reason")
    private String billingReason;
    @JsonProperty("card_brand")
    private String cardBrand;
    @JsonProperty("card_last_four")
    private String cardLastFour;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("currency_rate")
    private String currencyRate;
    @JsonProperty("status")
    private String status;
    @JsonProperty("status_formatted")
    private String statusFormatted;
    @JsonProperty("refunded")
    private Boolean refunded;
    @JsonProperty("subtotal")
    private Double subtotal;
    @JsonProperty("subtotal_usd")
    private Double subtotalUsd;
    @JsonProperty("subtotal_formatted")
    private String subtotalformatted;
    @JsonProperty("discount_total")
    private Double discountTotal;
    @JsonProperty("discount_total_usd")
    private Double discountTotalUsd;
    @JsonProperty("discount_total_formatted")
    private String discountTotalFormatted;
    @JsonProperty("tax_inclusive")
    private Boolean taxInclusive;
    @JsonProperty("tax")
    private Double tax;
    @JsonProperty("tax_usd")
    private Double taxUsd;
    @JsonProperty("tax_formatted")
    private String taxFormatted;
    @JsonProperty("total")
    private Double total;
    @JsonProperty("total_usd")
    private Double totalUsd;
    @JsonProperty("total_formatted")
    private String totalformatted;

    @JsonProperty("test_mode")
    private Boolean testMode;

    public SubscriptionInvoiceAttributes() {
        // For JSON parsing
    }

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    public String getBillingReason() {
        return billingReason;
    }

    public void setBillingReason(String billingReason) {
        this.billingReason = billingReason;
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

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getSubtotalUsd() {
        return subtotalUsd;
    }

    public void setSubtotalUsd(Double subtotalUsd) {
        this.subtotalUsd = subtotalUsd;
    }

    public String getSubtotalformatted() {
        return subtotalformatted;
    }

    public void setSubtotalformatted(String subtotalformatted) {
        this.subtotalformatted = subtotalformatted;
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

    public Boolean getTaxInclusive() {
        return taxInclusive;
    }

    public void setTaxInclusive(Boolean taxInclusive) {
        this.taxInclusive = taxInclusive;
    }

    public String getTaxFormatted() {
        return taxFormatted;
    }

    public void setTaxFormatted(String taxFormatted) {
        this.taxFormatted = taxFormatted;
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

    public String getTotalformatted() {
        return totalformatted;
    }

    public void setTotalformatted(String totalformatted) {
        this.totalformatted = totalformatted;
    }

    public Boolean getTestMode() {
        return testMode;
    }

    public void setTestMode(Boolean testMode) {
        this.testMode = testMode;
    }
}
