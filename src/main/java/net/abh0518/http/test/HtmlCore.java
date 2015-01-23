package net.abh0518.http.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class HtmlCore implements IHtmlGetter, IHtmlModifier{
	
	@Override
	public String getHtml(String url) throws ClientProtocolException, IOException{
		HttpClient client = getHttpClient();
		HttpGet get = new HttpGet(url);
		
		HttpResponse res = client.execute(get);
		InputStream is = res.getEntity().getContent();
		
		return IOUtils.toString(is, "utf-8");
	}
	
	public HttpClient getHttpClient(){
		return HttpClientBuilder.create().build();
	}
	
	@Override
	public void modifyHtml(){
		HttpClient cliet = getHttpClient();
	}
}
