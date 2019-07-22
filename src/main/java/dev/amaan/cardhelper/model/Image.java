package dev.amaan.cardhelper.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import dev.amaan.cardhelper.model.OpenLink.OpenLinkBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "imageUrl",
        "openLink"
})
public class Image {

    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("openLink")
    private OpenLink openLink;

    public static ImageBuilder Builder() {
        return new ImageBuilder();
    }

    @JsonProperty("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("imageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("openLink")
    public OpenLink getOpenLink() {
        return openLink;
    }

    @JsonProperty("openLink")
    public void setOpenLink(OpenLink openLink) {
        this.openLink = openLink;
    }

    public static final class ImageBuilder extends NestedBuilder<Widget.WidgetBuilder, Image> {
        private String imageUrl;
        private OpenLink openLink;

       private OpenLinkBuilder<ImageBuilder> openLinkBuilder =
            OpenLink.<ImageBuilder>Builder().withParentBuilder(this);

        private ImageBuilder() {
        }

        public static ImageBuilder anImage() {
            return new ImageBuilder();
        }

        public OpenLinkBuilder<ImageBuilder> addOpenLink() {
            return this.openLinkBuilder;
        }

        public ImageBuilder withImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public ImageBuilder withOpenLink(OpenLink openLink) {
            this.openLink = openLink;
            return this;
        }

        public Image build() {
            Image image = new Image();
            image.setImageUrl(imageUrl);
            image.setOpenLink(openLink);
            return image;
        }
    }
}
