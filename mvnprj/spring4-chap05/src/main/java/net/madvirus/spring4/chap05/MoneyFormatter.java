package net.madvirus.spring4.chap05;

import java.text.ParseException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.format.Formatter;

public class MoneyFormatter implements Formatter<Money> {

	@Override
	public String print(Money object, Locale locale) {
		return object.getAmount() + object.getCurrency();
	}

	@Override
	public Money parse(String text, Locale locale) throws ParseException {
		Pattern pattern = Pattern.compile("([0-9]+)([A-Z]{3})");
		Matcher matcher = pattern.matcher(text);
		if (!matcher.matches())
			throw new IllegalArgumentException("invalid format");

		int amount = Integer.parseInt(matcher.group(1));
		String currency = matcher.group(2);
		return new Money(amount, currency);
	}

}
