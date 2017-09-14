package com.zen.autumn.learn.crawl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TecentAdCrawlServer {

	private static final String POST_URL = "http://news.l.qq.com/app";

	private static final String GET_URL = "http://g1.163.com/madrs?app=7A16FBB6&platform=android&category=FOCUS2&location=1%2C2%2C10%2C20%2C21%2C22%2C23%2C24%2C25%2C26%2C27%2C28%2C29%2C30%2C31&timestamp=1481806805530&uid=EZ3bZWDXmKdsK4nvCc35n0JkyjzYeO0CqopHlF8QI8dIPiCtnU4lpL4d3eYyRCla%2FZT%2FTj%2BDlBoFes1YsG1tbTpHSYi%2F96hfJqny6geengm5%2Bj6HyUVnElDd0wqIW3i0hH4wa4VqQpxNQuwLRM49BylHzSSVBssRkAoZJ1qj4btl%2BN9M%2BGdxZNA0K9uRbTqXANJW%2F0K77QqzkP1hCb%2BRJz%2FS%2BzWCjQlV4nieqA5gzLTT%2Bqhw6vomGra336XaH%2F4OYl5QsKl2YBcC7V6sIr7pV4Xij3Pg95JEDraR5i4K9r%2FiU0%2BX3DRQAPe0uyHkYa0jG17RMNGMEYqvgF0LFcY0L%2ByyG1M0WLa3bUIOaIkFqRbAivvzjf86kbVqs6TkTr%2BQSLpGK1M7jekl%2B3teyq2Uh933zV%2FempCqRt7DDZ8JyzdO%2BTXuRzN1WEDFTcTpgvl5G5QMV7TqoBLXmyQ%2BJ9NkzZoUTcpPcFgFDJ6lQ0obY3JwlwullQblqdxrUnITZTZg8wQjccrQjqi1hO7EyO2HCxJoc0%2BSbyUxwyujR4w%2FoSYHVWYrn37Q%2FTr3FO82mfgWJRu301xaC2x6DOY9dHhyuxK5bpUs3eYGi4TS4%2FwSBM4Rr5C5XfSegvRpCe8K%2BMg%2BZTxc4tQT8RWGAIihbgroLISbI5qb1Z6Gbm8F2Xd7XVgAmFahwjMc6WQtRfNBIri8KcKu6fOgcDdHEgGpm5Jiz4jQUEX3lJcxXVttfMKtjQHP5bQ9RNm%2B4AxMHiDkhpQXcjk4B0oXv7VKAXa8On5CUSXiUsUOpD6M1X4kxi%2B6324H5L5tElGryOpaoUiGihRv32xT8MgQXnAT02SE6CTM31Pt5GautdACE8U5uSTbjm3v9sW38ygqW17OSYaGE%2Byh2BMh3TSJXXauih4MCJ4qtYEaQLL%2BIAs5uutC13C0%2F8ocjPwhuv6rTvabV9xtkPILmTdjOOfWp4U1oJ41YeXdEuxMOjdZvm4IOHI67uK7%2FSkg0yzT25iYzo45x7rPlliDPHJQH5N9SGFYM%2Fed5Sy%2BBaaANh0h2EC%2Fdx07K%2Bog9v6hm9ElOusryDodQ6QKzyRsC1ZMgc5YTAC5ZhrT2e%2BCmeGIvvIHPDCcQw%2F%2Fpjd0TB8ocG20JnZhHMPLk3CrvgK3xZLyI%2F9dLqS1iwTq%2Bg1HfyTmX%2Fy6g4RJjyG%2BOzcbEk633Gk0NcPq95M88n3DBL11FsTpmngWeAQO3Hg3%2Fui02tC%2Fe%2B%2B62vNTTYA1IsrwlpbN5xLpqN3vDhZD4%2BSGOL8%2FSLhb09zccX0875NUJ1hTsvYFXasRfsQbFafP8t6tQBA7nCJ6vPer9EMRIR%2FBvP9Kjs5ua86g1UvX7a5u%2BC3YB%2FlD8tCtLNcNj8wLaR9zAj8BIzYyvU9Q0bnoz0Wsmavx";

	private static final Gson GSON = new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
	private static final Logger LOG = Logger.getLogger(TecentAdCrawlServer.class);

	public static String queryCustomerProtectUnit() throws UnsupportedEncodingException {

//		HttpState initialState = new HttpState();
//		initialState.addCookies(TencentHttpCookieStore.COOKIE_ARRAY);

		HttpClient httpclient = new HttpClient();
		HostConfiguration hostConfig = new HostConfiguration();
		hostConfig.setProxy("127.0.0.1", 8888);
		httpclient.setHostConfiguration(hostConfig);
//		httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(30000);
//		httpclient.setState(initialState);
		
		
		PostMethod postMethod = new PostMethod(POST_URL);
//		GetMethod postMethod = new GetMethod(GET_URL);

		
		System.err.println(TencentHttpPostParamString.PARAM_STRING);
//		RequestEntity requestEntity = new StringRequestEntity(TencentHttpPostParamString.PARAM_STRING, "application/json", "UTF-8");
//		
//		postMethod.setRequestEntity(requestEntity);
		
//		postMethod.setQueryString(TencentHttpPostParamString.PARAM_STRING);
		
		for (Header header : TencentHttpHeadersStore.HEADER_STORE) {
			postMethod.setRequestHeader(header);
		}
		
		postMethod.setParams(TencentHttpPostParam.HTTP_METHOD_PARAMS);
		
		NameValuePair param = new NameValuePair("test","1");
		
		postMethod.setRequestBody(TencentHttpPostParamString.PARAM_STRING);
//		postMethod.setRequestBody(new NameValuePair[]{param});

		try {
			int responseStatus = httpclient.executeMethod(postMethod);

			if (responseStatus != HttpStatus.SC_OK) {
				System.err.println(responseStatus);

			}

			System.out.println("" + postMethod.getResponseBodyAsString());

		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";

	}

	public static void main(String[] args) throws UnsupportedEncodingException {

		queryCustomerProtectUnit();

	}

}
