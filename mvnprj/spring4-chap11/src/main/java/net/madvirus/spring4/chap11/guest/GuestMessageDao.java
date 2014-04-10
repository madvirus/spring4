package net.madvirus.spring4.chap11.guest;

import java.util.List;

public interface GuestMessageDao {

	List<GuestMessage> select(int start, int size);

	public int insert(GuestMessage message);
}
