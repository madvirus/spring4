package net.madvirus.spring4.chap11.guest;

import java.util.List;

public interface GuestMessageDao {

	List<GuestMessage> list(int start, int size);

}
