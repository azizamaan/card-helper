package dev.amaan.cardhelper.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "text",
        "openLink"
})
public class TextButton extends Button {

    @JsonProperty("text")
    private String text;
    @JsonProperty("openLink")
    private OpenLink openLink;

    public static TextButtonBuilder Builder() {
        return new TextButtonBuilder();
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("openLink")
    public OpenLink getOpenLink() {
        return openLink;
    }

    @JsonProperty("openLink")
    public void setOpenLink(OpenLink openLink) {
        this.openLink = openLink;
    }

    public static final class TextButtonBuilder extends NestedBuilder<Widget.WidgetBuilder, TextButton> {
        private String text;
        private OpenLink openLink;

        private TextButtonBuilder() {
        }

        public static TextButtonBuilder aTextButton() {
            return new TextButtonBuilder();
        }

        public TextButtonBuilder withText(String text) {
            this.text = text;
            return this;
        }

        public TextButtonBuilder withOpenLink(OpenLink openLink) {
            this.openLink = openLink;
            return this;
        }

        public TextButton build() {
            TextButton textButton = new TextButton();
            textButton.setText(text);
            textButton.setOpenLink(openLink);
            return textButton;
        }
    }
}
