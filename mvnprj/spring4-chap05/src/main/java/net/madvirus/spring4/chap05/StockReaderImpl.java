package net.madvirus.spring4.chap05;

import java.util.Date;

public class StockReaderImpl implements StockReader {

	@Override
	public int getClosePrice(Date date, String code) {
		System.out.println("StockReaderImpl: " + code);
		// 가짜 구현
		try { // 시간이 걸림을 나타내기 위한 300 밀리초 슬립
			Thread.sleep(300);
		} catch (InterruptedException e) {
		}
		return 500;
	}

}
