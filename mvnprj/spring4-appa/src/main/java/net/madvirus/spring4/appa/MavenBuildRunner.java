package net.madvirus.spring4.appa;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MavenBuildRunner implements BuildRunner {
	private Log log = LogFactory.getLog(MavenBuildRunner.class);

	private String mavenPath;

	@Override
	public void build(List<String> srcDirs, String binDir) {
		String info = "\t메이븐 경로: " + mavenPath + "\n";
		for (String srcDir : srcDirs)
			info += "\t소스 경로: " + srcDir + "\n";
		info += "\t클래스파일 경로: " + binDir + "\n";

		log.info(String.format("MavenBuildRunner.build() 실행\n%s", info));
	}

	public void setMavenPath(String mavenPath) {
		this.mavenPath = mavenPath;
	}

}
