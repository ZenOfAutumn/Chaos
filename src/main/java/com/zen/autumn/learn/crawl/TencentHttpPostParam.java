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
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TencentHttpPostParam {

	private static final Logger LOG = Logger.getLogger(TencentHttpPostParam.class);

	private static final Gson GSON = new GsonBuilder().serializeNulls().disableHtmlEscaping().create();

	public static final Properties PROPERTIES = new Properties();

	public static final List<Cookie> COOKIE_STORE = Lists.newArrayList();

	public static Cookie[] COOKIE_ARRAY;

	public static final String DOMAIN = "news.l.qq.com";

	public static final HttpMethodParams HTTP_METHOD_PARAMS = new HttpMethodParams();

	static {

		init();

	}

	private static void init() {
		try {
			PROPERTIES.load(new FileInputStream(new File("./resources/tencentParams.properties")));
			Set<Map.Entry<Object, Object>> entrySet = PROPERTIES.entrySet();

			for (Entry<Object, Object> entry : PROPERTIES.entrySet()) {
				HTTP_METHOD_PARAMS.setParameter(entry.getKey().toString(), entry.getValue().toString());
			}

		} catch (FileNotFoundException e) {
			LOG.error("can't find cookie file.");
		} catch (IOException e) {
			LOG.error("read cookie file failed.");
		}
	}

}
