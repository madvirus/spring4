package net.madvirus.spring4.chap02.sensor;

import java.util.Properties;
import java.util.Set;

public class Sensor {
	private Properties additionalInfo;
	private Set<String> agentCodes;

	public void setAdditionalInfo(Properties additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public void setAgentCodes(Set<String> agentCodes) {
		this.agentCodes = agentCodes;
	}

	public int read() {
		return 0;
	}

	@Override
	public String toString() {
		return "Sensor [additionalInfo=" + additionalInfo + ", agentCodes=" + agentCodes + "]";
	}

}
