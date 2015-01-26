import java.io.IOException;
import java.util.Properties;

import net.abh0518.http.test.IHtmlGetter;

import org.apache.http.client.ClientProtocolException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Main {
	
	ApplicationContext context;
	
	public static void main(String args[]) throws ClientProtocolException, IOException {
		Main main = new Main();
		main.start(args);
	}
	
	public void start(String[] args) throws ClientProtocolException, IOException{
		context = new GenericXmlApplicationContext("applicationContext.xml");
		
		System.out.println("Start");
		Properties props = context.getBean("config", Properties.class);
		String htmlUrl = props.getProperty("html.url");
		
		IHtmlGetter htmlGetter = context.getBean("htmlCore", IHtmlGetter.class);
		
		String nateHtml = htmlGetter.getHtml(htmlUrl);
		
		System.out.println(nateHtml);
		System.out.println("target : " + htmlUrl);
	}	
	
}
