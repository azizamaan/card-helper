package dev.amaan.cardhelper;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.amaan.cardhelper.model.Message;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
public class Main {
	public static void main(String... args) throws IOException {
		/*
		 * Message message = Message .messageBuilder()
		 * .addCard().addHeader().withTitle("A").withImageUrl("B").withSubtitle("C")
		 * .done() .addSection() .addWidget()
		 * .addImage().withImageUrl("D").addOpenLink().withUrl("E") .done() .done()
		 * .done() .addWidget()
		 * .addKeyValue().withBottomLabel("F").withTopLabel("G").withContent("H")
		 * .withContentMultiline("I") .done() .done() .done() .done() .build();
		 */
		/*
		 * Message message = Message. messageBuilder() .addCard() .addSection()
		 * .addWidget() .addImage().addOpenLink().withUrl("test.com").done().done()
		 * .done() .done() .done() .build();
		 */
		Message message = Message
				.messageBuilder()
				.addCard()
				.addHeader().withTitle("A").withSubtitle("C")
				.done()
				.done()
				.build();
		ObjectMapper mapper = new ObjectMapper();

		String s = mapper.writeValueAsString(message);
		System.out.println(s);
		// Replace the webhook with actual webhook url
		callWebhook("webhook",s);
	}

	private static void callWebhook(String webhook, String message) throws IOException {
		URL url = new URL(webhook);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("accept", "application/json");
		conn.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		wr.writeBytes(message);
		wr.flush();
		wr.close();
		if (conn.getResponseCode() != 200) {
			System.out.println("Error occured "+conn.getResponseMessage());
		}


		conn.disconnect();
	}
}
