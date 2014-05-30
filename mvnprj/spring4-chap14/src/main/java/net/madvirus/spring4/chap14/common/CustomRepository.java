package net.madvirus.spring4.chap14.common;

import java.io.Serializable;

import net.madvirus.spring4.chap14.domain.Option;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomRepository<T, ID extends Serializable>
		extends JpaRepository<T, ID> {
	public Option<T> getOption(ID id);
}
