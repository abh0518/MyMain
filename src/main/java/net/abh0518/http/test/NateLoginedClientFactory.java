package net.abh0518.http.test;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NateLoginedClientFactory implements IHttpClientFactory{

	static Logger logger = LoggerFactory.getLogger(NateLoginedClientFactory.class);
	
	String id;
	String passwd;
	
	@Override
	public HttpClient getClient() {
		logger.info("네이트 로그인이 된 클라이언트 입니다.");
		logger.info(this.id + " / " + this.passwd);
		return HttpClientBuilder.create().build();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}	

	
}
