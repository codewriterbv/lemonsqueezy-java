package be.codewriter.lemonsqueezy.checkout;

import be.codewriter.lemonsqueezy.BaseAttributes;
import be.codewriter.lemonsqueezy.customer.BillingAddress;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckoutData extends BaseAttributes {

    @JsonProperty("email")
    private String email;
    @JsonProperty("name")
    private String name;
    @JsonProperty("billing_address")
    private BillingAddress billingAddress;
    @JsonProperty("tax_number")
    private String taxNumber;
    @JsonProperty("discount_code")
    private String discountCode;
    @JsonProperty("custom")
    // An object containing any custom data to be passed to the checkout
    private CheckoutDataCustom custom;
    // A list containing quantity data objects
    @JsonProperty("variant_quantities")
    private List<String> variantQuantities;

    public CheckoutData() {
        // For JSON parsing
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public CheckoutDataCustom getCustom() {
        return custom;
    }

    public void setCustom(CheckoutDataCustom custom) {
        this.custom = custom;
    }

    public List<String> getVariantQuantities() {
        return variantQuantities;
    }

    public void setVariantQuantities(List<String> variantQuantities) {
        this.variantQuantities = variantQuantities;
    }
}
