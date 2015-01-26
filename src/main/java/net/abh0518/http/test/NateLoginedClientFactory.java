package net.abh0518.http.test;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class NateLoginedClientFactory implements IHttpClientFactory{

	String id;
	String passwd;
	
	@Override
	public HttpClient getClient() {
		System.out.println("네이트 로그인이 된 클라이언트 입니다.");
		System.out.println(this.id + " / " + this.passwd);
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
