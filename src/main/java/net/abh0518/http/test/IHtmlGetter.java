package net.abh0518.http.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public interface IHtmlGetter {
	
	String getHtml(String url) throws ClientProtocolException, IOException;

}
