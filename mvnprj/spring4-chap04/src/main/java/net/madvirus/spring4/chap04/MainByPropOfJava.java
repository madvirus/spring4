package net.madvirus.spring4.chap04;

import java.io.IOException;

import net.madvirus.spring4.chap04.config.ConfigByProp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainByPropOfJava {

	public static void main(String[] args) throws IOException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigByProp.class);
		ctx.close();
	}
}
