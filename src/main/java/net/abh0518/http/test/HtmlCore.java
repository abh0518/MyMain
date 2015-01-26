package net.abh0518.http.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

public class HtmlCore implements IHtmlGetter, IHtmlModifier{
	
	IHttpClientFactory httpClientFactory;
	
	public HtmlCore(IHttpClientFactory httpClientFactory){
		this.httpClientFactory = httpClientFactory;
	}
	
	@Override
	public String getHtml(String url) throws ClientProtocolException, IOException{
		HttpClient client = getHttpClient();
		HttpGet get = new HttpGet(url);
		
		HttpResponse res = client.execute(get);
		InputStream is = res.getEntity().getContent();
		
		return IOUtils.toString(is, "utf-8");
	}
	
	HttpClient client = null;
	
	private HttpClient getHttpClient(){
		if(client == null){
			client = httpClientFactory.getClient();
		}
		return client;
	}
	
	@Override
	public void modifyHtml(){
		HttpClient client = getHttpClient();
		//Html뭔가 변환작업을 해준다.
	}
}
