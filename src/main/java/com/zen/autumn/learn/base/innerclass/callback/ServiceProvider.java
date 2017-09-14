package com.zen.autumn.learn.base.innerclass.callback;

public class ServiceProvider {

	private ServiceProviderCallback callBack;

	public ServiceProviderCallback getCallBack() {
		return callBack;
	}

	public void setCallBack(ServiceProviderCallback callBack) {
		this.callBack = callBack;
	}

	public void init() {
		System.out.println("Service Provider");
		callBack.customHint();

	}

}
