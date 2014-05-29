package net.madvirus.spring4.chap14.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Address.class)
public class Address_ {
	public static volatile SingularAttribute<Address, String> address1;
	public static volatile SingularAttribute<Address, String> address2;
	public static volatile SingularAttribute<Address, String> zipcode;
}
