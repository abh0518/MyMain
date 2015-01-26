package net.abh0518.http.test;

import org.apache.http.client.HttpClient;

public interface IHttpClientFactory {
	public HttpClient getClient();
}
