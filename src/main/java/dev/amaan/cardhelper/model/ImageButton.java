package dev.amaan.cardhelper.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "icon",
        "iconUrl",
        "openLink"
})
public class ImageButton extends Button {

    @JsonProperty("icon")
    private String icon;
    @JsonProperty("iconUrl")
    private String iconUrl;
    @JsonProperty("openLink")
    private OpenLink openLink;

    public static ImageButtonBuilder Builder() {
        return new ImageButtonBuilder();
    }

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JsonProperty("iconUrl")
    public String getIconUrl() {
        return iconUrl;
    }

    @JsonProperty("iconUrl")
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @JsonProperty("openLink")
    public OpenLink getOpenLink() {
        return openLink;
    }

    @JsonProperty("openLink")
    public void setOpenLink(OpenLink openLink) {
        this.openLink = openLink;
    }

    public static final class ImageButtonBuilder extends NestedBuilder<Widget.WidgetBuilder, ImageButton> {
        private String icon;
        private String iconUrl;
        private OpenLink openLink;

        private ImageButtonBuilder() {
        }

        public static ImageButtonBuilder anImageButton() {
            return new ImageButtonBuilder();
        }

        public ImageButtonBuilder withIcon(String icon) {
            this.icon = icon;
            return this;
        }

        public ImageButtonBuilder withIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
            return this;
        }

        public ImageButtonBuilder withOpenLink(OpenLink openLink) {
            this.openLink = openLink;
            return this;
        }

        public ImageButton build() {
            ImageButton imageButton = new ImageButton();
            imageButton.setIcon(icon);
            imageButton.setIconUrl(iconUrl);
            imageButton.setOpenLink(openLink);
            return imageButton;
        }
    }
}