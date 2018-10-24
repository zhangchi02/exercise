package com.zhc.utils;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author zhangchi02
 * @date 2018年10月18日
 */
public class Date2LongSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializeProvider)
			throws IOException, JsonProcessingException {
		jsonGenerator.writeNumber(date.getTime() / 1000);
	}
}
