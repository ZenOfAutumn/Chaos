package com.zen.autumn.learn;


import org.apache.log4j.Logger;
import org.htmlparser.Parser;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ToutiaoHttpServer {

	private static final String GET_URL = "http://toutiao.com/group/6542883716/";

	private static final Gson GSON = new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
	private static final Logger LOG = Logger.getLogger(ToutiaoHttpServer.class);

//	public static String queryCustomerProtectUnit() {
//
//		HttpState initialState = new HttpState();
//		initialState.addCookies(ToutiaoHttpCookieStore.COOKIE_ARRAY);
//
//		HttpClient httpclient = new HttpClient();
//
//		httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(30000);
//		httpclient.setState(initialState);
//		GetMethod method = new GetMethod(GET_URL);
//		method.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
//		method.setRequestHeader("Accept-Encoding", "gzip, deflate, sdch");
//		method.setRequestHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
//		method.setRequestHeader("Upgrade-Insecure-Requests", "1");
//		method.setRequestHeader("Host", "www.toutiao.com");
//		method.setRequestHeader("Cache-Control", "max-age=0");
//		method.setRequestHeader("Connection", "keep-alive");
//		method.setRequestHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//
//		
//		
//		try {
//			int responseStatus = httpclient.executeMethod(method);
//
//			System.err.println(method.getStatusCode());
//			
//			if (responseStatus != HttpStatus.SC_OK) {
//				System.err.println(responseStatus);
//			}
//
//
//		} catch (HttpException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return StringUtils.EMPTY;
//
//	}

	public static void main(String[] args) throws ParserException {

		Parser parse = new Parser(GET_URL);
		
		NodeList list = parse.parse(null);
		
		System.out.println(list.toHtml());

		
	}

}
