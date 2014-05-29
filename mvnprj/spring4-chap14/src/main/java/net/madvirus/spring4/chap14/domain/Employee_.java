package net.madvirus.spring4.chap14.domain;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Employee.class)
public class Employee_ {
	public static volatile SingularAttribute<Employee, Long> id;
	public static volatile SingularAttribute<Employee, String> employeeNumber;
	public static volatile SingularAttribute<Employee, String> name;
	public static volatile SingularAttribute<Employee, Address> address;
	public static volatile SingularAttribute<Employee, Integer> birthYear;
	public static volatile SingularAttribute<Employee, Team> team;
	public static volatile SingularAttribute<Employee, Date> joinedDate;
}
