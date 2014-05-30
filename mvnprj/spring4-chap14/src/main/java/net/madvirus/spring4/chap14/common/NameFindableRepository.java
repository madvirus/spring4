package net.madvirus.spring4.chap14.common;

public interface NameFindableRepository<T> {

	T findByName(String name);

}
