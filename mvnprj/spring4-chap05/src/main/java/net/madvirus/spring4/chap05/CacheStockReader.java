package net.madvirus.spring4.chap05;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CacheStockReader implements StockReader {

	private Map<String, Integer> cache = new HashMap<>();
	private StockReader delegate;

	public CacheStockReader(StockReader delegate) {
		this.delegate = delegate;
	}

	@Override
	public int getClosePrice(Date date, String code) {
		String key = createKey(date, code);
		System.out.println("CacheStockReader: " + key);
		if (cache.containsKey(key))
			return cache.get(key);

		int value = delegate.getClosePrice(date, code);
		cache.put(key, value);
		return value;
	}

	private String createKey(Date date, String code) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		return dateFormat.format(date) + "-" + code;
	}

}
