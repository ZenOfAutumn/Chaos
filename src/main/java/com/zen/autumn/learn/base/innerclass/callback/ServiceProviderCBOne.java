package com.zen.autumn.learn.base.innerclass.callback;

public class ServiceProviderCBOne implements ServiceProviderCallback {

	private ServiceProvider serviceProvider;
	
	@Override
	public void customHint() {
		System.out.println("This is one Service Provider CallBack");
	}
	
	public void init(){
		serviceProvider = new ServiceProvider();
		serviceProvider.setCallBack(this);
		serviceProvider.init();		
	}
	
	public static void main(String[] args){
		ServiceProviderCBOne cb = new ServiceProviderCBOne();
		cb.init();
	}

}
