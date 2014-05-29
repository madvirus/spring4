package net.madvirus.spring4.chap14.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Team.class)
public class Team_ {
	public static volatile SingularAttribute<Team, Long> id;
	public static volatile SingularAttribute<Team, String> name;
}
