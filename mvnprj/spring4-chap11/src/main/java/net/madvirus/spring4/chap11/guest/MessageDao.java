package net.madvirus.spring4.chap11.guest;

import java.util.List;

public interface MessageDao {

	List<Message> select(int start, int size);

	public int counts();
	
	public int insert(Message message);
	
	public int delete(int id);
}
