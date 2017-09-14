package com.zen.autumn.learn.search;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.apache.log4j.Logger;

import com.google.common.collect.Lists;

public class BaiduHttpHeadersStore {

	private static final Logger LOG = Logger.getLogger(BaiduHttpHeadersStore.class);

	public static final Properties PROPERTIES = new Properties();

	public static final List<Header> HEADER_STORE = Lists.newArrayList();

	static {

		init();

	}

	private static void init() {
		try {
			PROPERTIES.load(new FileInputStream(new File("./BaiduAdvancedSearchHeader.properties")));
			Set<Map.Entry<Object, Object>> entrySet = PROPERTIES.entrySet();
			for (Entry<Object, Object> entry : PROPERTIES.entrySet()) {
				Header header = new BasicHeader(entry.getKey().toString(), entry.getValue().toString());
				HEADER_STORE.add(header);
			}

		} catch (FileNotFoundException e) {
			LOG.error("can't find cookie file.");
		} catch (IOException e) {
			LOG.error("read cookie file failed.");
		}
	}

}
