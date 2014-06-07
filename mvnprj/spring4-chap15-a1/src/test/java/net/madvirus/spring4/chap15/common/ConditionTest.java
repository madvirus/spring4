package net.madvirus.spring4.chap15.common;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ConditionTest {

	@Test
	public void simple_one_wherePart() throws Exception {
		Condition wherePart = new BooleanCondition("a = ?", "1");
		assertThat(wherePart.getQuery(), equalTo("a = ?"));
		assertThat(wherePart.getParams(), equalTo(asList("1")));
	}

	private List<Object> asList(Object... values) {
		return Arrays.asList(values);
	}

	@Test
	public void test_and_condition() {
		BooleanCondition left = new BooleanCondition("a = ?", "1");
		BooleanCondition right = new BooleanCondition("b = ?", "2");
		Condition wherePart = new AndCondition(left, right);

		assertThat(wherePart.getQuery(), equalTo("a = ?" + " and " + "b = ?"));
		assertThat(wherePart.getParams(), equalTo(asList("1", "2")));
	}

	@Test
	public void test_or_condition() {
		BooleanCondition left = new BooleanCondition("a = ?", "1");
		BooleanCondition right = new BooleanCondition("b = ?", "2");
		Condition wherePart = new OrCondition(left, right);

		assertThat(wherePart.getQuery(), equalTo("a = ?" + " or " + "b = ?"));
		assertThat(wherePart.getParams(), equalTo(asList("1", "2")));
	}

	@Test
	public void successive_add_condition_to_junction() throws Exception {
		JunctionCondition junctionCondtion = new OrCondition()
				.add(new BooleanCondition("a = ?", "1"))
				.add(new BooleanCondition("b = ?", "2"))
				.add(new BooleanCondition("c = ?", "3"));
		assertThat(junctionCondtion.getQuery(), equalTo("a = ?" + " or " + "b = ?" + " or " + "c = ?"));
		assertThat(junctionCondtion.getParams(), equalTo(Arrays.<Object> asList("1", "2", "3")));
	}
	
	@Test
	public void test_composite_junction() throws Exception {
		JunctionCondition junctionCondtion = new AndCondition()
		.add(new BooleanCondition("a = ?", "1"))
		.add(new OrCondition(new BooleanCondition("b = ?", "2"), new BooleanCondition("c = ?", "3")));

		assertThat(junctionCondtion.getQuery(), equalTo("a = ?" + " and (" + "b = ?" + " or " + "c = ?" + ")"));
		assertThat(junctionCondtion.getParams(), equalTo(Arrays.<Object> asList("1", "2", "3")));

	}
}
