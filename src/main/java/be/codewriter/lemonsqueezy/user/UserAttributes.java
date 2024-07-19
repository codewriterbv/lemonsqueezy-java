package be.codewriter.lemonsqueezy.user;

import be.codewriter.lemonsqueezy.BaseAttributes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAttributes extends BaseAttributes {
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("color")
    private String color;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    @JsonProperty("has_custom_avatar")
    private Boolean hasCustomAvatar;

    public UserAttributes() {
        // For JSON parsing
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Boolean getHasCustomAvatar() {
        return hasCustomAvatar;
    }

    public void setHasCustomAvatar(Boolean hasCustomAvatar) {
        this.hasCustomAvatar = hasCustomAvatar;
    }
}
