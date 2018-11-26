package com.webup.soa.base;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class BaseEnumDeserializer<T extends BaseEnum<?>> extends JsonDeserializer<T> {
 
    @Override
    public T deserialize(JsonParser jp, DeserializationContext ctxt) 
      throws IOException, JsonProcessingException {
        //JsonNode node = jp.getCodec().readTree(jp);
    	//int index = (Integer) ((IntNode) node.get("index")).numberValue();
    	Object inputSource=jp.getInputSource();
 
        return null;
    }
}


