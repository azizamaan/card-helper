package dev.amaan.cardhelper.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "keyValue",
        "image",
        "buttons"
})
public class Widget {

    @JsonProperty("keyValue")
    private KeyValue keyValue;
    @JsonProperty("image")
    private Image image;
    @JsonProperty("buttons")
    private List<Button> buttons = null;

    public static WidgetBuilder builder() {
        return new WidgetBuilder();
    }

    @JsonProperty("keyValue")
    public KeyValue getKeyValue() {
        return keyValue;
    }

    @JsonProperty("keyValue")
    public void setKeyValue(KeyValue keyValue) {
        this.keyValue = keyValue;
    }

    @JsonProperty("image")
    public Image getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(Image image) {
        this.image = image;
    }

    @JsonProperty("buttons")
    public List<Button> getButtons() {
        return buttons;
    }

    @JsonProperty("buttons")
    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    public static final class WidgetBuilder extends NestedBuilder<Section.SectionBuilder, Widget> {
        private KeyValue keyValue;
        private Image image;
        private List<Button> buttons = new ArrayList<Button>();

        private KeyValue.KeyValueBuilder keyValueBuilder = KeyValue.builder().withParentBuilder(this);
        private Image.ImageBuilder imageBuilder = Image.builder().withParentBuilder(this);

        private ImageButton.ImageButtonBuilder imageButtonBuilder = ImageButton.builder().withParentBuilder(this);
        public ImageButton.ImageButtonBuilder addImageButton() {
            return this.imageButtonBuilder;
        }
        private TextButton.TextButtonBuilder textButtonBuilder = TextButton.builder().withParentBuilder(this);
        public TextButton.TextButtonBuilder addTextButton() {
            return this.textButtonBuilder;
        }

        private WidgetBuilder() {
        }

        public static WidgetBuilder aWidget() {
            return new WidgetBuilder();
        }

        public KeyValue.KeyValueBuilder addKeyValue() {
            return this.keyValueBuilder;
        }

        public Image.ImageBuilder addImage() {
            return this.imageBuilder;
        }

        public WidgetBuilder withKeyValue(KeyValue keyValue) {
            this.keyValue = keyValue;
            return this;
        }

        public WidgetBuilder withImage(Image image) {
            this.image = image;
            return this;
        }

        public WidgetBuilder withButtons(List<Button> buttons) {
            this.buttons = buttons;
            return this;
        }

        public WidgetBuilder withImageButton(ImageButton button) {
            this.buttons.add(button);
            return this;
        }

        public WidgetBuilder withTextButton(TextButton button) {
            this.buttons.add(button);
            return this;
        }

        public Widget build() {
            Widget widget = new Widget();
            widget.setKeyValue(keyValue);
            widget.setImage(image);
            widget.setButtons(buttons);
            return widget;
        }
    }
}
