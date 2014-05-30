package net.madvirus.spring4.chap14.main;

import net.madvirus.spring4.chap14.application.UpdateTeamService;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForModifying {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:/springconf.xml");

		UpdateTeamService updateTeamService = ctx.getBean(UpdateTeamService.class);
		updateTeamService.udpateName(1L, "새이름");
		ctx.close();
	}
}
