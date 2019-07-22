package dev.amaan.cardhelper.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "topLabel",
        "content",
        "contentMultiline",
        "bottomLabel",
        "openLink",
        "icon",
        "iconUrl",
        "button"
})
public class KeyValue {

    @JsonProperty("topLabel")
    private String topLabel;
    @JsonProperty("content")
    private String content;
    @JsonProperty("contentMultiline")
    private String contentMultiline;
    @JsonProperty("bottomLabel")
    private String bottomLabel;
    @JsonProperty("openLink")
    private OpenLink openLink;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("iconUrl")
    private String iconUrl;
    @JsonProperty("button")
    private Button button;

    public static KeyValueBuilder builder() {
        return new KeyValueBuilder();
    }

    @JsonProperty("topLabel")
    public String getTopLabel() {
        return topLabel;
    }

    @JsonProperty("topLabel")
    public void setTopLabel(String topLabel) {
        this.topLabel = topLabel;
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("contentMultiline")
    public String getContentMultiline() {
        return contentMultiline;
    }

    @JsonProperty("contentMultiline")
    public void setContentMultiline(String contentMultiline) {
        this.contentMultiline = contentMultiline;
    }

    @JsonProperty("bottomLabel")
    public String getBottomLabel() {
        return bottomLabel;
    }

    @JsonProperty("bottomLabel")
    public void setBottomLabel(String bottomLabel) {
        this.bottomLabel = bottomLabel;
    }

    @JsonProperty("openLink")
    public OpenLink getOpenLink() {
        return openLink;
    }

    @JsonProperty("openLink")
    public void setOpenLink(OpenLink openLink) {
        this.openLink = openLink;
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

    @JsonProperty("button")
    public Button getButton() {
        return button;
    }

    @JsonProperty("button")
    public void setButton(Button button) {
        this.button = button;
    }

    public static final class KeyValueBuilder extends NestedBuilder<Widget.WidgetBuilder, KeyValue> {
        private String topLabel;
        private String content;
        private String contentMultiline;
        private String bottomLabel;
        private OpenLink openLink;
        private String icon;
        private String iconUrl;
        private Button button;
        private OpenLink.OpenLinkBuilder<KeyValueBuilder> openLinkBuilder = OpenLink.<KeyValueBuilder>builder().withParentBuilder(this);

        private KeyValueBuilder() {
        }

        public static KeyValueBuilder aKeyValue() {
            return new KeyValueBuilder();
        }

        public OpenLink.OpenLinkBuilder<KeyValueBuilder> addOpenLink() {
            return this.openLinkBuilder;
        }


        public KeyValueBuilder withTopLabel(String topLabel) {
            this.topLabel = topLabel;
            return this;
        }

        public KeyValueBuilder withContent(String content) {
            this.content = content;
            return this;
        }

        public KeyValueBuilder withContentMultiline(String contentMultiline) {
            this.contentMultiline = contentMultiline;
            return this;
        }

        public KeyValueBuilder withBottomLabel(String bottomLabel) {
            this.bottomLabel = bottomLabel;
            return this;
        }

        public KeyValueBuilder withOpenLink(OpenLink openLink) {
            this.openLink = openLink;
            return this;
        }

        public KeyValueBuilder withIcon(String icon) {
            this.icon = icon;
            return this;
        }

        public KeyValueBuilder withIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
            return this;
        }

        public KeyValueBuilder withButton(Button button) {
            this.button = button;
            return this;
        }

        public KeyValue build() {
            KeyValue keyValue = new KeyValue();
            keyValue.setTopLabel(topLabel);
            keyValue.setContent(content);
            keyValue.setContentMultiline(contentMultiline);
            keyValue.setBottomLabel(bottomLabel);
            keyValue.setOpenLink(openLink);
            keyValue.setIcon(icon);
            keyValue.setIconUrl(iconUrl);
            keyValue.setButton(button);
            return keyValue;
        }
    }
}