package org.demo.people.creditcard.domain.card;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class CreditCardDeserializer { //extends JsonDeserializer<CreditCard> {
//    @Override
//    public CreditCard deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
//        ObjectCodec oc = jsonParser.getCodec();
//        JsonNode node = oc.readTree(jsonParser);
//
//        if (node == null) {
//            return null;
//        }
//
//        String text = node.textValue(); // gives "A" from the request
//
//        if (text == null) {
//            return null;
//        }
//
//        return CreditCard.fromText(text);
//    }
}
