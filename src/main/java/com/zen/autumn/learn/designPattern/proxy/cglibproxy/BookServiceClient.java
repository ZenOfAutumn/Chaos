package com.zen.autumn.learn.designPattern.proxy.cglibproxy;

public class BookServiceClient {

	public static void main(String[] args) {
		BookServiceBean service = (BookServiceBean) BookServiceFactory.getInstance(BookServiceBean.class,
				new AuthCheckInterceptor("wuliang07"), new ProxyFilter());
		doMethod(service);
	}

	public static void doMethod(BookServiceBean service) {
		service.create();
		service.update();
		service.query();
		service.delete();
	}

}
