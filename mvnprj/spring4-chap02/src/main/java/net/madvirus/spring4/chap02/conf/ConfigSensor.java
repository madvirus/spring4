package net.madvirus.spring4.chap02.conf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import net.madvirus.spring4.chap02.sensor.Monitor;
import net.madvirus.spring4.chap02.sensor.Sensor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSensor {

	@Bean
	public Sensor sensor1() {
		Sensor s = new Sensor();
		Properties properties = new Properties();
		properties.setProperty("threshold", "1500");
		properties.setProperty("retry", "3");
		s.setAdditionalInfo(properties);
		return s;
	}

	@Bean
	public Sensor sensor2() {
		Sensor s = new Sensor();
		Set<String> codes = new HashSet<>();
		codes.add("200");
		codes.add("300");
		s.setAgentCodes(codes);
		Properties properties = new Properties();
		properties.setProperty("threshold", "3000");
		properties.setProperty("retry", "5");
		s.setAdditionalInfo(properties);
		return s;
	}

	@Bean
	public Monitor monitor() {
		Monitor m = new Monitor();
		Map<String, Sensor> sensorMap = new HashMap<>();
		sensorMap.put("frontDoor", sensor1());
		sensorMap.put("backDoor", sensor2());
		m.setSensorMap(sensorMap);

		Map<String, Integer> config = new HashMap<>();
		config.put("interval", 1000);
		config.put("period", 2000);
		m.setConfig(config);

		return m;
	}

}
