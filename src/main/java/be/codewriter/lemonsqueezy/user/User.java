package be.codewriter.lemonsqueezy.user;

import be.codewriter.lemonsqueezy.generic.Data;
import be.codewriter.lemonsqueezy.generic.DataType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * https://docs.lemonsqueezy.com/api/users#the-user-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends Data {
    private UserAttributes attributes;

    public User() {
        // For JSON parsing
        setType(DataType.USERS);
    }

    public UserAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(UserAttributes attributes) {
        this.attributes = attributes;
    }
}
