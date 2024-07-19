package be.codewriter.lemonsqueezy.license;

import be.codewriter.lemonsqueezy.generic.Data;
import be.codewriter.lemonsqueezy.generic.DataType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * https://docs.lemonsqueezy.com/api/license-keys#the-license-key-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
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
