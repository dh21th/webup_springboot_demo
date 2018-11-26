package com.webup.soa.utils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
//import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;

public final class JsonUtils {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

//	private static Logger log = Logger.getLogger(JsonUtils.class);

	private JsonUtils() {
	}

	public static String toJson(Object value) {
		Assert.notNull(value);

		try {
			return OBJECT_MAPPER.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static <T> T toObject(String json, Class<T> valueType) {
		Assert.hasText(json);
		Assert.notNull(valueType);

		try {
			return OBJECT_MAPPER.readValue(json, valueType);
		} catch (JsonParseException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (JsonMappingException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static <T> T toObject(File file, Class<T> valueType){
		try {
			return OBJECT_MAPPER.readValue(file,valueType);
		} catch (Exception e) {
//			log.error("转换出错：错误信息为："+e.getMessage());
			return null;
		}
	}

	public static <T> T toObject(String json, TypeReference<?> typeReference) {
		Assert.hasText(json);
		Assert.notNull(typeReference);

		try {
			return OBJECT_MAPPER.readValue(json, typeReference);
		} catch (JsonParseException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (JsonMappingException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static <T> T toObject(String json, JavaType javaType) {
		Assert.hasText(json);
		Assert.notNull(javaType);

		try {
			return OBJECT_MAPPER.readValue(json, javaType);
		} catch (JsonParseException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (JsonMappingException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static JsonNode toTree(String json) {
		Assert.hasText(json);

		try {
			return OBJECT_MAPPER.readTree(json);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static JsonNode toTree(File file) {
		try {
			return OBJECT_MAPPER.readTree(file);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static void writeValue(Writer writer, Object value) {
		Assert.notNull(writer);
		Assert.notNull(value);

		try {
			OBJECT_MAPPER.writeValue(writer, value);
		} catch (JsonGenerationException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (JsonMappingException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static JavaType constructType(Type type) {
		Assert.notNull(type);

		return TypeFactory.defaultInstance().constructType(type);
	}

	public static JavaType constructType(TypeReference<?> typeReference) {
		Assert.notNull(typeReference);

		return TypeFactory.defaultInstance().constructType(typeReference);
	}

}