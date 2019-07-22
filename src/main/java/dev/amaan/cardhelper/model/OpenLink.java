package dev.amaan.cardhelper.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "url"
})
public class OpenLink {

    @JsonProperty("url")
    private String url;

    public static <T> OpenLinkBuilder<T> builder() {
        return new OpenLinkBuilder<T>();
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    public static final class OpenLinkBuilder<T> extends NestedBuilder<T, OpenLink> {
        private String url;

        private OpenLinkBuilder() {
        }

        public static <T> OpenLinkBuilder<T> anOpenLink() {
            return new OpenLinkBuilder<T>();
        }

        public OpenLinkBuilder<T> withUrl(String url) {
            this.url = url;
            return this;
        }

        public OpenLink build() {
            OpenLink openLink = new OpenLink();
            openLink.setUrl(url);
            return openLink;
        }
    }
}
