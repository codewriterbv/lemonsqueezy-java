package be.codewriter.lemonsqueezy.customer;

import be.codewriter.lemonsqueezy.generic.Urls;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerAttributes {
    @JsonProperty("test_mode")
    private Boolean testMode;
    @JsonProperty("store_id")
    private Long storeId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("status")
    private String status;
    @JsonProperty("status_formatted")
    private String statusFormatted;
    @JsonProperty("city")
    private String city;
    @JsonProperty("region")
    private String region;
    @JsonProperty("country")
    private String country;
    @JsonProperty("country_formatted")
    private String countryFormatted;
    @JsonProperty("total_revenue_currency")
    private Double totalRevenueCurrency;
    @JsonProperty("total_revenue_currency_formatted")
    private String totalRevenueCurrencyFormatted;
    @JsonProperty("mrr")
    private Double monthlyRecurringRevenue;
    @JsonProperty("mrr_formatted")
    private String monthlyRecurringRevenueFormatted;
    @JsonProperty("urls")
    private Urls urls;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    public CustomerAttributes() {
        // For JSON parsing
    }

    public Boolean getTestMode() {
        return testMode;
    }

    public void setTestMode(Boolean testMode) {
        this.testMode = testMode;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryFormatted() {
        return countryFormatted;
    }

    public void setCountryFormatted(String countryFormatted) {
        this.countryFormatted = countryFormatted;
    }

    public Double getTotalRevenueCurrency() {
        return totalRevenueCurrency;
    }

    public void setTotalRevenueCurrency(Double totalRevenueCurrency) {
        this.totalRevenueCurrency = totalRevenueCurrency;
    }

    public String getTotalRevenueCurrencyFormatted() {
        return totalRevenueCurrencyFormatted;
    }

    public void setTotalRevenueCurrencyFormatted(String totalRevenueCurrencyFormatted) {
        this.totalRevenueCurrencyFormatted = totalRevenueCurrencyFormatted;
    }

    public Double getMonthlyRecurringRevenue() {
        return monthlyRecurringRevenue;
    }

    public void setMonthlyRecurringRevenue(Double monthlyRecurringRevenue) {
        this.monthlyRecurringRevenue = monthlyRecurringRevenue;
    }

    public String getMonthlyRecurringRevenueFormatted() {
        return monthlyRecurringRevenueFormatted;
    }

    public void setMonthlyRecurringRevenueFormatted(String monthlyRecurringRevenueFormatted) {
        this.monthlyRecurringRevenueFormatted = monthlyRecurringRevenueFormatted;
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
