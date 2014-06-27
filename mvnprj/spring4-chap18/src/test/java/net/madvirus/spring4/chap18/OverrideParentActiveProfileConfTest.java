package net.madvirus.spring4.chap18;

import net.madvirus.spring4.chap18.SystemLogger;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(value = "local", inheritProfiles = false)
public class OverrideParentActiveProfileConfTest extends CommonActiveProfileTest {
	@Autowired
	private SystemLogger logger;

	@Test
	public void sum() {
		logger.log("test");
	}

}
