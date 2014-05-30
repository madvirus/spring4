package net.madvirus.spring4.chap14.common;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.RepositoryMetadata;

public class CustomRepositoryFactory extends JpaRepositoryFactory {

	private EntityManager entityManager;

	public CustomRepositoryFactory(EntityManager entityManager) {
		super(entityManager);
		this.entityManager = entityManager;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected Object getTargetRepository(RepositoryMetadata metadata) {
		return new CustomJpaRepository(metadata.getDomainType(), entityManager);
	}

	@Override
	protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
		return CustomJpaRepository.class;
	}

}
