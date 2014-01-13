package net.madvirus.spring4.chap04;

import java.io.IOException;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainByEnvOfXml {

	public static void main(String[] args) throws IOException {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();
		MutablePropertySources propSources = env.getPropertySources();
		propSources.addLast(new ResourcePropertySource("classpath:/db.properties"));

		String javaVersion = env.getProperty("java.version");
		String dbUser = env.getProperty("db.user");
		System.out.printf("java version is %s\n", javaVersion);
		System.out.printf("dbUser is %s\n", dbUser);
	}
}
