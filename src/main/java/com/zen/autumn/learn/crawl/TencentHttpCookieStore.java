package com.zen.autumn.learn.crawl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.httpclient.Cookie;
import org.apache.log4j.Logger;

import com.google.common.collect.Lists;

public class TencentHttpCookieStore {

	private static final Logger LOG = Logger.getLogger(TencentHttpCookieStore.class);

	public static final Properties PROPERTIES = new Properties();

	public static final List<Cookie> COOKIE_STORE = Lists.newArrayList();

	public static Cookie[] COOKIE_ARRAY;

	public static final String DOMAIN = "news.l.qq.com";

	static {

		init();

	}

	private static void init() {
		try {
			PROPERTIES.load(new FileInputStream(new File("./resources/tencentCookie.properties")));
			Set<Map.Entry<Object, Object>> entrySet = PROPERTIES.entrySet();
			COOKIE_ARRAY = new Cookie[entrySet.size()];
			int index = 0;
			for (Entry<Object, Object> entry : PROPERTIES.entrySet()) {
				Cookie cookie = new Cookie(DOMAIN, entry.getKey().toString(), entry.getValue().toString());
				cookie.setPath("/");
				COOKIE_STORE.add(cookie);
				COOKIE_ARRAY[index] = cookie;
				index++;
			}

		} catch (FileNotFoundException e) {
			LOG.error("can't find cookie file.");
		} catch (IOException e) {
			LOG.error("read cookie file failed.");
		}
	}

}
