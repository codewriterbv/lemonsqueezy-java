package be.codewriter.lemonsqueezy.product;

import be.codewriter.lemonsqueezy.BaseAttributes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductOptions extends BaseAttributes {

    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    // An array of image URLs to use as the product's media
    @JsonProperty("media")
    private List<String> media;
    @JsonProperty("redirect_url")
    private String redirectUrl;
    @JsonProperty("receipt_button_text")
    private String receiptButtonText;
    @JsonProperty("receipt_link_url")
    private String receiptLinkUrl;
    @JsonProperty("receipt_thank_you_note")
    private String receiptThankYouNote;
    // An array of variant IDs to enable for this checkout. If this is empty, all variants will be enabled.
    @JsonProperty("enabled_variants")
    private List<String> enabledVariants;

    public ProductOptions() {
        // For JSON parsing
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getMedia() {
        return media;
    }

    public void setMedia(List<String> media) {
        this.media = media;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getReceiptButtonText() {
        return receiptButtonText;
    }

    public void setReceiptButtonText(String receiptButtonText) {
        this.receiptButtonText = receiptButtonText;
    }

    public String getReceiptLinkUrl() {
        return receiptLinkUrl;
    }

    public void setReceiptLinkUrl(String receiptLinkUrl) {
        this.receiptLinkUrl = receiptLinkUrl;
    }

    public String getReceiptThankYouNote() {
        return receiptThankYouNote;
    }

    public void setReceiptThankYouNote(String receiptThankYouNote) {
        this.receiptThankYouNote = receiptThankYouNote;
    }

    public List<String> getEnabledVariants() {
        return enabledVariants;
    }

    public void setEnabledVariants(List<String> enabledVariants) {
        this.enabledVariants = enabledVariants;
    }
}
