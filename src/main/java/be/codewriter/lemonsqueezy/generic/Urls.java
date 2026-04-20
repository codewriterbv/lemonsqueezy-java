package be.codewriter.lemonsqueezy.generic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Urls {
    @JsonProperty("receipt")
    private String receipt;
    @JsonProperty("customer_portal")
    private String customerPortal;
    @JsonProperty("invoice_url")
    private String invoiceUrl;
    @JsonProperty("update_payment_method")
    private String updatePaymentMethod;
    @JsonProperty("customer_portal_update_subscription")
    private String customerPortalUpdateSubscription;

    public Urls() {
        // For JSON parsing
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getCustomerPortal() {
        return customerPortal;
    }

    public void setCustomerPortal(String customerPortal) {
        this.customerPortal = customerPortal;
    }

    public String getInvoiceUrl() {
        return invoiceUrl;
    }

    public void setInvoiceUrl(String invoiceUrl) {
        this.invoiceUrl = invoiceUrl;
    }

    public String getUpdatePaymentMethod() {
        return updatePaymentMethod;
    }

    public void setUpdatePaymentMethod(String updatePaymentMethod) {
        this.updatePaymentMethod = updatePaymentMethod;
    }

    public String getCustomerPortalUpdateSubscription() {
        return customerPortalUpdateSubscription;
    }

    public void setCustomerPortalUpdateSubscription(String customerPortalUpdateSubscription) {
        this.customerPortalUpdateSubscription = customerPortalUpdateSubscription;
    }
}
