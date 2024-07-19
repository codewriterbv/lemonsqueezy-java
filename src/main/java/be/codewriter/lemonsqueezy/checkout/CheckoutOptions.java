package be.codewriter.lemonsqueezy.checkout;

import be.codewriter.lemonsqueezy.BaseAttributes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CheckoutOptions extends BaseAttributes {

    @JsonProperty("embed")
    private Boolean embed;
    @JsonProperty("media")
    private Boolean media;
    @JsonProperty("logo")
    private Boolean logo;
    @JsonProperty("desc")
    private Boolean desc;
    @JsonProperty("discount")
    private Boolean discount;
    @JsonProperty("dark")
    private Boolean dark;
    @JsonProperty("subscription_preview")
    private Boolean subscription_preview;
    @JsonProperty("button_color")
    private String button_color;

    public CheckoutOptions() {
        // For JSON parsing
    }

    public Boolean getEmbed() {
        return embed;
    }

    public void setEmbed(Boolean embed) {
        this.embed = embed;
    }

    public Boolean getMedia() {
        return media;
    }

    public void setMedia(Boolean media) {
        this.media = media;
    }

    public Boolean getLogo() {
        return logo;
    }

    public void setLogo(Boolean logo) {
        this.logo = logo;
    }

    public Boolean getDesc() {
        return desc;
    }

    public void setDesc(Boolean desc) {
        this.desc = desc;
    }

    public Boolean getDiscount() {
        return discount;
    }

    public void setDiscount(Boolean discount) {
        this.discount = discount;
    }

    public Boolean getDark() {
        return dark;
    }

    public void setDark(Boolean dark) {
        this.dark = dark;
    }

    public Boolean getSubscription_preview() {
        return subscription_preview;
    }

    public void setSubscription_preview(Boolean subscription_preview) {
        this.subscription_preview = subscription_preview;
    }

    public String getButton_color() {
        return button_color;
    }

    public void setButton_color(String button_color) {
        this.button_color = button_color;
    }
}
