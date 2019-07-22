package dev.amaan.cardhelper.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "header",
        "widgets"
})
public class Section {

    @JsonProperty("header")
    private String header;
    @JsonProperty("widgets")
    private List<Widget> widgets = null;

    public static SectionBuilder builder() {
        return new SectionBuilder();
    }

    @JsonProperty("header")
    public String getHeader() {
        return header;
    }

    @JsonProperty("header")
    public void setHeader(String header) {
        this.header = header;
    }

    @JsonProperty("widgets")
    public List<Widget> getWidgets() {
        return widgets;
    }

    @JsonProperty("widgets")
    public void setWidgets(List<Widget> widgets) {
        this.widgets = widgets;
    }

    public static final class SectionBuilder extends NestedBuilder<Card.CardBuilder, Section> {
        private String header;
        private List<Widget> widgets = new ArrayList<Widget>();

        private Widget.WidgetBuilder widgetBuilder = Widget.builder().withParentBuilder(this);

        private SectionBuilder() {
        }

        public static SectionBuilder aSection() {
            return new SectionBuilder();
        }

        public Widget.WidgetBuilder addWidget() {
            return this.widgetBuilder;
        }

        public SectionBuilder withHeader(String header) {
            this.header = header;
            return this;
        }

        public SectionBuilder withWidgets(List<Widget> widgets) {
            this.widgets = widgets;
            return this;
        }

        public SectionBuilder withWidget(Widget widget) {
            this.widgets.add(widget);
            return this;
        }

        public Section build() {
            Section section = new Section();
            section.setHeader(header);
            section.setWidgets(widgets);
            return section;
        }
    }
}
