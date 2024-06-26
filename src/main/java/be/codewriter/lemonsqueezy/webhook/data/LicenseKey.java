package be.codewriter.lemonsqueezy.webhook.data;

import be.codewriter.lemonsqueezy.webhook.data.attributes.LicenseKeyAttributes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * https://docs.lemonsqueezy.com/api/license-keys#the-license-key-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LicenseKey extends Data {
    private LicenseKeyAttributes attributes;

    public LicenseKey() {
        // For JSON parsing
        setType(DataType.LICENSE_KEYS);
    }

    public LicenseKeyAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(LicenseKeyAttributes attributes) {
        this.attributes = attributes;
    }
}
