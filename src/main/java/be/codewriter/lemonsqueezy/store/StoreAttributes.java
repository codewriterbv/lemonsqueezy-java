package be.codewriter.lemonsqueezy.store;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreAttributes {
    @JsonProperty("name")
    private String name;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("url")
    private String url;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    @JsonProperty("plan")
    private String plan;
    @JsonProperty("country")
    private String country;
    @JsonProperty("country_nicename")
    private String countryNicename;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("total_sales")
    private Double totalSales;
    @JsonProperty("total_revenue")
    private Double totalRevenue;
    @JsonProperty("thirty_day_sales")
    private Double thirtyDaySales;
    @JsonProperty("thirty_day_revenue")
    private Double thirtyDayRevenue;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    public StoreAttributes() {
        // For JSON parsing
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryNicename() {
        return countryNicename;
    }

    public void setCountryNicename(String countryNicename) {
        this.countryNicename = countryNicename;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Double totalSales) {
        this.totalSales = totalSales;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public Double getThirtyDaySales() {
        return thirtyDaySales;
    }

    public void setThirtyDaySales(Double thirtyDaySales) {
        this.thirtyDaySales = thirtyDaySales;
    }

    public Double getThirtyDayRevenue() {
        return thirtyDayRevenue;
    }

    public void setThirtyDayRevenue(Double thirtyDayRevenue) {
        this.thirtyDayRevenue = thirtyDayRevenue;
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
