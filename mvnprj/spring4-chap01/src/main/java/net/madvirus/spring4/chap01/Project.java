package net.madvirus.spring4.chap01;

import java.util.List;

public class Project {

	private List<String> srcDirs;
	private String binDir;
	private BuildRunner buildRunner;
	
	public void build() {
		buildRunner.build(srcDirs, binDir);
	}

	public void setSrcDirs(List<String> srcDirs) {
		this.srcDirs = srcDirs;
	}

	public void setBinDir(String binDir) {
		this.binDir = binDir;
	}

	public void setBuildRunner(BuildRunner buildRunner) {
		this.buildRunner = buildRunner;
	}

}
