package dev.amaan.cardhelper.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "header",
        "sections"
})
public class Card {

    @JsonProperty("header")
    private Header header;
    @JsonProperty("sections")
    private List<Section> sections = null;

    public static CardBuilder builder() {
        return new CardBuilder();
    }

    @JsonProperty("header")
    public Header getHeader() {
        return header;
    }

    @JsonProperty("header")
    public void setHeader(Header header) {
        this.header = header;
    }

    @JsonProperty("sections")
    public List<Section> getSections() {
        return sections;
    }

    @JsonProperty("sections")
    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public static final class CardBuilder extends NestedBuilder<Message.MessageBuilder, Card> {
        private Header header;
        private List<Section> sections = new ArrayList<Section>();

        private Header.HeaderBuilder headerBuilder = Header.builder().withParentBuilder(this);
        private Section.SectionBuilder sectionBuilder = Section.builder().withParentBuilder(this);

        private CardBuilder() {
        }

        public static CardBuilder aCard() {
            return new CardBuilder();
        }

        public Header.HeaderBuilder addHeader() {
            return this.headerBuilder;
        }

        public Section.SectionBuilder addSection() {
            return this.sectionBuilder;
        }

        public CardBuilder withHeader(Header header) {
            this.header = header;
            return this;
        }

        public CardBuilder withSections(List<Section> sections) {
            this.sections = sections;
            return this;
        }

        public CardBuilder withSection(Section section) {
            this.sections.add(section);
            return this;
        }

        public Card build() {
            Card card = new Card();
            card.setHeader(header);
            card.setSections(sections);
            return card;
        }
    }
}
