package net.madvirus.spring4.chap05;

import java.net.URL;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RestClient {

	private URL serverUrl;
	private Date apiDate;

	public void setServerUrl(URL serverUrl) {
		this.serverUrl = serverUrl;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public void setApiDate(Date apiDate) {
		this.apiDate = apiDate;
	}

	@Override
	public String toString() {
		return "RestClient [serverUrl=" + serverUrl + "]";
	}

}
