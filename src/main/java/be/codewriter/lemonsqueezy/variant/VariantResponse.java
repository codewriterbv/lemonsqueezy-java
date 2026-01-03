package be.codewriter.lemonsqueezy.variant;

import be.codewriter.lemonsqueezy.generic.Response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VariantResponse extends Response {
    private Variant data;

    public Variant getData() {
        return data;
    }

    public void setData(Variant data) {
        this.data = data;
    }
}
