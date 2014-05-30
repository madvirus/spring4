package net.madvirus.spring4.chap14.common;

import java.io.Serializable;

import javax.persistence.EntityManager;

import net.madvirus.spring4.chap14.domain.Option;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class CustomJpaRepository<T, ID extends Serializable>
		extends SimpleJpaRepository<T, ID>
		implements CustomRepository<T, ID> {

	private EntityManager entityManager;

	public CustomJpaRepository(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		this.entityManager = em;
	}

	public CustomJpaRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public Option<T> getOption(ID id) {
		return Option.value(entityManager.find(getDomainClass(), id));
	}

}
