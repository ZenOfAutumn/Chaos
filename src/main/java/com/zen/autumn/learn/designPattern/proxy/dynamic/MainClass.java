package com.zen.autumn.learn.designPattern.proxy.dynamic;

import java.lang.reflect.Proxy;

public class MainClass {

	static void processService(Service service) {

		service.getAge(1);
		service.getName(1);
	}

	public static void main(String[] args) {
//		Service userService = new ServiceImpl();
		Service anotherUserService = new AnotherServiceImpl();

		InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(anotherUserService);
//		Service userServiceProxy = (Service) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
//				userService.getClass().getInterfaces(), invocationHandler);

		Service anotherProxy = (Service) Proxy.newProxyInstance(anotherUserService.getClass().getClassLoader(),
				anotherUserService.getClass().getInterfaces(), invocationHandler);

//		processService(userServiceProxy);
		processService(anotherProxy);

	}

}
