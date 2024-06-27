package be.codewriter.lemonsqueezy.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAttributes {
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
    // TODO this is different to all other use cases with created_at, to check...
    @JsonProperty("createdAt")
    private LocalDateTime createdAt;
    // TODO this is different to all other use cases with updated_at, to check...
    @JsonProperty("updatedAt")
    private LocalDateTime updatedAt;

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
