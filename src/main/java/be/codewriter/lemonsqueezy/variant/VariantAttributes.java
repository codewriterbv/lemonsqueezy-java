package be.codewriter.lemonsqueezy.variant;

import be.codewriter.lemonsqueezy.BaseAttributes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

/**
 *https://docs.lemonsqueezy.com/api/variants/the-variant-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VariantAttributes extends BaseAttributes {
    private int price;
    @JsonProperty("is_subscription")
    private boolean isSubscription;
    private String interval;
    @JsonProperty("interval_count")
    private Integer intervalCount;
    @JsonProperty("has_free_trial")
    private boolean hasFreeTrial;
    @JsonProperty("trial_interval")
    private String trialInterval;
    @JsonProperty("trial_interval_count")
    private int trialIntervalCount;
    @JsonProperty("pay_what_you_want")
    private boolean payWhatYouWant;
    @JsonProperty("min_price")
    private int minPrice;
    @JsonProperty("suggested_price")
    private int suggestedPrice;
    @JsonProperty("product_id")
    private int productId;
    private String name;
    private String slug;
    private String description;
    @JsonProperty("has_license_keys")
    private boolean hasLicenseKeys;
    @JsonProperty("license_activation_limit")
    private int licenseActivationLimit;
    @JsonProperty("is_license_limit_unlimited")
    private boolean isLicenseLimitUnlimited;
    @JsonProperty("license_length_value")
    private int licenseLengthValue;
    @JsonProperty("license_length_unit")
    private String licenseLengthUnit;
    @JsonProperty("is_license_length_unlimited")
    private boolean isLicenseLengthUnlimited;
    private int sort;
    private String status;
    @JsonProperty("status_formatted")
    private String statusFormatted;
    @JsonProperty("test_mode")
    private boolean testMode;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    public int getPrice() { 
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isSubscription() {
        return isSubscription;
    }

    public void setSubscription(boolean subscription) {
        isSubscription = subscription;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public Integer getIntervalCount() {
        return intervalCount;
    }

    public void setIntervalCount(Integer intervalCount) {
        this.intervalCount = intervalCount;
    }

    public boolean isHasFreeTrial() {
        return hasFreeTrial;
    }

    public void setHasFreeTrial(boolean hasFreeTrial) {
        this.hasFreeTrial = hasFreeTrial;
    }

    public String getTrialInterval() {
        return trialInterval;
    }

    public void setTrialInterval(String trialInterval) {
        this.trialInterval = trialInterval;
    }

    public int getTrialIntervalCount() {
        return trialIntervalCount;
    }

    public void setTrialIntervalCount(int trialIntervalCount) {
        this.trialIntervalCount = trialIntervalCount;
    }

    public boolean isPayWhatYouWant() {
        return payWhatYouWant;
    }

    public void setPayWhatYouWant(boolean payWhatYouWant) {
        this.payWhatYouWant = payWhatYouWant;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getSuggestedPrice() {
        return suggestedPrice;
    }

    public void setSuggestedPrice(int suggestedPrice) {
        this.suggestedPrice = suggestedPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHasLicenseKeys() {
        return hasLicenseKeys;
    }

    public void setHasLicenseKeys(boolean hasLicenseKeys) {
        this.hasLicenseKeys = hasLicenseKeys;
    }

    public int getLicenseActivationLimit() {
        return licenseActivationLimit;
    }

    public void setLicenseActivationLimit(int licenseActivationLimit) {
        this.licenseActivationLimit = licenseActivationLimit;
    }

    public boolean isLicenseLimitUnlimited() {
        return isLicenseLimitUnlimited;
    }

    public void setLicenseLimitUnlimited(boolean licenseLimitUnlimited) {
        isLicenseLimitUnlimited = licenseLimitUnlimited;
    }

    public int getLicenseLengthValue() {
        return licenseLengthValue;
    }

    public void setLicenseLengthValue(int licenseLengthValue) {
        this.licenseLengthValue = licenseLengthValue;
    }

    public String getLicenseLengthUnit() {
        return licenseLengthUnit;
    }

    public void setLicenseLengthUnit(String licenseLengthUnit) {
        this.licenseLengthUnit = licenseLengthUnit;
    }

    public boolean isLicenseLengthUnlimited() {
        return isLicenseLengthUnlimited;
    }

    public void setLicenseLengthUnlimited(boolean licenseLengthUnlimited) {
        isLicenseLengthUnlimited = licenseLengthUnlimited;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
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

    public boolean isTestMode() {
        return testMode;
    }

    public void setTestMode(boolean testMode) {
        this.testMode = testMode;
    }
}
