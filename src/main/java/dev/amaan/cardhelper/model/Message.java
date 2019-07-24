package dev.amaan.cardhelper.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cards"
})
public class Message {

    @JsonProperty("cards")
    private List<Card> cards = null;
    private HttpRequestFactory requestFactory;

    public static MessageBuilder messageBuilder() {
        return new MessageBuilder();
    }

    public Message() {
        HttpTransport httpTransport = null;
        try {
            httpTransport = GoogleNetHttpTransport.newTrustedTransport();
            requestFactory = httpTransport.createRequestFactory();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        private Card.CardBuilder cardBuilder = Card.builder().withParentBuilder(this);

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

    @Override
    public String toString() {
        String message = "";
        try {
            message = new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return message;
    }

    public void send(String webhookUrl) {
        GenericUrl genericUrl = new GenericUrl(webhookUrl);
        HttpContent content = null;
        try {
            content = new ByteArrayContent("application/json", this.toString().getBytes("UTF-8"));
            HttpRequest request = this.requestFactory.buildPostRequest(genericUrl, content);
            HttpResponse response = request.execute();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
