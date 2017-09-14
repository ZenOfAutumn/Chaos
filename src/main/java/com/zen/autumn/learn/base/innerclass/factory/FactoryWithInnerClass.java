package com.zen.autumn.learn.base.innerclass.factory;




enum FactoryAssembly{
	
	FACTORY_A{
		@Override
		ServiceFactory getFactory(int param) {
			return new ServiceFactory() {				
				@Override
				public Service getService() {
					return new Service() {
						private int q = param;

						@Override
						public void foo() {
							// TODO Auto-generated method stub
							
						}
					};
				}
			};
		}
	};
	
	
	abstract ServiceFactory getFactory(int param);
	
	
	
}

interface Service{

	void foo();
}

interface ServiceFactory{
	Service getService();
}
	


class ServiceA implements Service{
	
	@Override
	public void foo() {
		// TODO Auto-generated method stub		
	}
	
	public static final ServiceFactory FACTORY =  new ServiceFactory() {		
		@Override
		public Service getService() {
			return new ServiceA();
		}
	};
}




public class FactoryWithInnerClass {

	class Inner{
		private int i = 0;
		
		
		
		
		
	}
	
	
}
