package com.lakala.ppay.util.converter.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.lakala.ppay.util.Jacksons;

import java.io.IOException;
import java.util.Map;

/**
 * @author user
 */
public class StringToMapSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String val = value;
        if (value == null || value.isEmpty()) {
            val = "{}";
        }
        gen.writeObject(Jacksons.getMapper().readValue(val, Map.class));
    }

}
