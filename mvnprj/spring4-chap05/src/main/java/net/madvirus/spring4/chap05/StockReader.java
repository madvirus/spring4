package net.madvirus.spring4.chap05;

import java.util.Date;

public interface StockReader {

	public int getClosePrice(Date date, String code);
}
