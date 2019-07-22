package dev.amaan.cardhelper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.amaan.cardhelper.model.Message;

public class Main {

    public static void main(String... args) throws JsonProcessingException {
        /*Message message = Message
                .messageBuilder()
                    .addCard().addHeader().withTitle("A").withImageUrl("B").withSubtitle("C")
                              .done()
                    .addSection()
                        .addWidget()
                            .addImage().withImageUrl("D").addOpenLink().withUrl("E")
                            .done()
                        .done()
                    .done()
                        .addWidget()
                            .addKeyValue().withBottomLabel("F").withTopLabel("G").withContent("H")
                            .withContentMultiline("I")
                            .done()
                        .done()
                    .done()
                .done()
                .build();*/
        Message message = Message.
                messageBuilder()
                .addCard()
                .addSection()
                .addWidget()
                .addImage().addOpenLink().withUrl("test.com").done().done()
                .done()
                .done()
                .done()
                .build();

        ObjectMapper mapper = new ObjectMapper();

        String s = mapper.writeValueAsString(message);
        System.out.println(s);

    }
}
