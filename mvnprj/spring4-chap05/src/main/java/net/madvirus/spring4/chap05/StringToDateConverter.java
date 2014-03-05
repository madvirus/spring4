package net.madvirus.spring4.chap05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date> {

	private String pattern;

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public Date convert(String source) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		try {
			return dateFormat.parse(source);
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

}
