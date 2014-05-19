package net.madvirus.spring4.chap13.store.domain;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectKey;

public interface PaymentInfoRepository {
	@Insert("insert into PAYMENT_INFO (PRICE) values (#{price})")
	@Options(keyProperty = "id", useGeneratedKeys = true)
	void save(PaymentInfo paymentInfo);

}
