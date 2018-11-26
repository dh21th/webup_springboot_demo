package com.webup.soa.base;

import java.io.IOException;
import java.lang.reflect.Method;

import com.webup.soa.exception.ApplicationException;
import org.slf4j.Logger;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class BaseEnumSerializer extends JsonSerializer<BaseEnum<?>> {

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(BaseEnumSerializer.class);

	@Override
	public void serialize(BaseEnum<?> enumObj, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {

		try {
			jgen.writeStartObject();
			Class clazz = enumObj.getClass();
			// Method m = clazz.getMethod("name");
			Method[] mehods = clazz.getDeclaredMethods();		
			Method name = clazz.getMethod("name");
			//jgen.writeStringField("id", enumObj.getId().toString());
			jgen.writeObjectField("id", enumObj.getId());
			for (Method m : mehods) {
				String methodName = m.getName();
				Integer argCount=m.getParameterTypes().length;
				if (methodName.startsWith("get") && methodName.indexOf("getId") < 0&&argCount==0) {
					String fieldName = methodName.substring(3).toLowerCase();
					jgen.writeStringField(fieldName, m.invoke(enumObj).toString());
				}
			}
			jgen.writeStringField("enumName", name.invoke(enumObj).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("枚举json序列化失败:{}", e);
			throw new ApplicationException(e.getMessage());
		} finally {
			jgen.writeEndObject();
		}

	}
}
