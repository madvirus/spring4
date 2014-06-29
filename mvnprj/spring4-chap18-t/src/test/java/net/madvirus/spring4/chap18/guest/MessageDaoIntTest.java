package net.madvirus.spring4.chap18.guest;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
@TransactionConfiguration
public class MessageDaoIntTest {

	@Autowired
	private MessageDao messageDao;

	@Test
	public void counts() {
		assertThat(messageDao.counts(), equalTo(28));
	}

	@Transactional
	@Test
	public void insert() {
		Message message = new Message();
		message.setName("bkchoi");
		message.setMessage("message");
		message.setCreationTime(new Date());
		int newMesageId = messageDao.insert(message);
		assertThat(newMesageId, greaterThan(0));
	}

}
