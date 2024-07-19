package be.codewriter.lemonsqueezy.checkout;

import be.codewriter.lemonsqueezy.BaseAttributes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Preview extends BaseAttributes {

    @JsonProperty("currency")
    private String currency;
    @JsonProperty("currency_rate")
    private Double currencyRate;
    @JsonProperty("subtotal")
    private Double subtotal;
    @JsonProperty("subtotal_usd")
    private Double subtotalUsd;
    @JsonProperty("subtotal_formatted")
    private String subtotalFormatted;
    @JsonProperty("discount_total")
    private Double discountTotal;
    @JsonProperty("discount_total_usd")
    private Double discountTotalUsd;
    @JsonProperty("discount_total_formatted")
    private String discountTotalFormatted;
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
    private String totalFormatted;

    public Preview() {
        // For JSON parsing
    }

    public String getCurrency() {

        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(Double currencyRate) {
        this.currencyRate = currencyRate;
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

    public String getSubtotalFormatted() {
        return subtotalFormatted;
    }

    public void setSubtotalFormatted(String subtotalFormatted) {
        this.subtotalFormatted = subtotalFormatted;
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

    public String getTotalFormatted() {
        return totalFormatted;
    }

    public void setTotalFormatted(String totalFormatted) {
        this.totalFormatted = totalFormatted;
    }
}
