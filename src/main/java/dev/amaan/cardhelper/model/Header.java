package dev.amaan.cardhelper.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "title",
        "subtitle",
        "imageUrl"
})
public class Header {

    @JsonProperty("title")
    private String title;
    @JsonProperty("subtitle")
    private String subtitle;
    @JsonProperty("imageUrl")
    private String imageUrl;

    public static HeaderBuilder builder() {
        return new HeaderBuilder();
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("subtitle")
    public String getSubtitle() {
        return subtitle;
    }

    @JsonProperty("subtitle")
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    @JsonProperty("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("imageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static final class HeaderBuilder extends NestedBuilder<Card.CardBuilder, Header> {
        private String title;
        private String subtitle;
        private String imageUrl;

        private HeaderBuilder() {
        }

        public static HeaderBuilder aHeader() {
            return new HeaderBuilder();
        }

        public HeaderBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public HeaderBuilder withSubtitle(String subtitle) {
            this.subtitle = subtitle;
            return this;
        }

        public HeaderBuilder withImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Header build() {
            Header header = new Header();
            header.setTitle(title);
            header.setSubtitle(subtitle);
            header.setImageUrl(imageUrl);
            return header;
        }
    }
}
