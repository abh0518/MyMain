package net.abh0518.http;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

import net.abh0518.http.test.IHtmlGetter;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Main {
	
	static Logger logger = LoggerFactory.getLogger(Main.class);
	static Logger errorLogger = LoggerFactory.getLogger("ERROR_LOGGER");
	
	ApplicationContext context;
	
	public static void main(String args[]) throws ClientProtocolException, IOException {
		Main main = new Main();
		main.start(args);
	}
	
	public void start(String[] args) throws ClientProtocolException, IOException{
		
		try{
			context = new GenericXmlApplicationContext("applicationContext.xml");
			
			logger.info("Start");
			Properties props = context.getBean("config", Properties.class);
			String htmlUrl = props.getProperty("html.url");
			
			IHtmlGetter htmlGetter = context.getBean("htmlCore", IHtmlGetter.class);
			
			String nateHtml = htmlGetter.getHtml(htmlUrl);
			System.out.println(nateHtml);
			logger.info("end, tartget : " + htmlUrl);
		}
		catch(Throwable e){
			errorHandle(e);
		}
	}	
	
	private void errorHandle(Throwable e){
		System.err.print("에러가 발생했습니다. 관리자에게 문의 바람");
		errorLogger.error(extractStackTrace(e));
		logger.error(extractStackTrace(e));
	}
	
	private static String extractStackTrace(Throwable e){
		if (e == null) {
	        return "";
	    }
	    StringWriter sw = new StringWriter();
	    e.printStackTrace(new PrintWriter(sw));
	    return sw.toString();
	}
	
	
}
