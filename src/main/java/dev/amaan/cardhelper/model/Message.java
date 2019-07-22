package dev.amaan.cardhelper.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cards"
})
public class Message {

    @JsonProperty("cards")
    private List<Card> cards = null;

    public static MessageBuilder messageBuilder() {
        return new MessageBuilder();
    }

    @JsonProperty("cards")
    public List<Card> getCards() {
        return cards;
    }

    @JsonProperty("cards")
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public static final class MessageBuilder {
        private List<Card> cards = new ArrayList<Card>();

        private Card.CardBuilder cardBuilder = Card.Builder().withParentBuilder(this);

        private MessageBuilder() {
        }

        public static MessageBuilder aMessage() {
            return new MessageBuilder();
        }

        public Card.CardBuilder addCard() {
            return this.cardBuilder;
        }

        public MessageBuilder withCards(List<Card> cards) {
            this.cards = cards;
            return this;
        }

        public MessageBuilder withCard(Card card) {
            this.cards.add(card);
            return this;
        }

        public Message build() {
            Message message = new Message();
            message.setCards(cards);
            return message;
        }
    }
}
