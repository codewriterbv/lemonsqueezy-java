package be.codewriter.lemonsqueezy.checkout;

import be.codewriter.lemonsqueezy.BaseAttributes;
import be.codewriter.lemonsqueezy.product.ProductOptions;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckoutAttributes extends BaseAttributes {

    @JsonProperty("variant_id")
    private Long variantId;
    @JsonProperty("customer_price")
    private Double customerPrice;
    @JsonProperty("product_options")
    private ProductOptions productOptions;
    @JsonProperty("checkout_options")
    private CheckoutOptions checkoutOptions;
    @JsonProperty("checkout_data")
    private CheckoutData checkoutData;
    @JsonProperty("preview")
    private Preview preview;
    @JsonProperty("expires_at")
    private LocalDateTime expiresAt;
    @JsonProperty("url")
    private String url;

    public CheckoutAttributes() {
        // For JSON parsing
    }

    public Long getVariantId() {
        return variantId;
    }

    public void setVariantId(Long variantId) {
        this.variantId = variantId;
    }

    public Double getCustomerPrice() {
        return customerPrice;
    }

    public void setCustomerPrice(Double customerPrice) {
        this.customerPrice = customerPrice;
    }

    public ProductOptions getProductOptions() {
        return productOptions;
    }

    public void setProductOptions(ProductOptions productOptions) {
        this.productOptions = productOptions;
    }

    public CheckoutOptions getCheckoutOptions() {
        return checkoutOptions;
    }

    public void setCheckoutOptions(CheckoutOptions checkoutOptions) {
        this.checkoutOptions = checkoutOptions;
    }

    public CheckoutData getCheckoutData() {
        return checkoutData;
    }

    public void setCheckoutData(CheckoutData checkoutData) {
        this.checkoutData = checkoutData;
    }

    public Preview getPreview() {
        return preview;
    }

    public void setPreview(Preview preview) {
        this.preview = preview;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
