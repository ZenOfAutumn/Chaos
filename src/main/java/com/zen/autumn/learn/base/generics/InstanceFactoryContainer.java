package com.zen.autumn.learn.base.generics;

public class InstanceFactoryContainer<T> {
	
	private T x;
	
	public <F extends InstanceFacotory<T>> InstanceFactoryContainer(F factory){
		x = factory.create();
	}
	
	public static void main(String[] args) {
		new InstanceFactoryContainer<Integer>(new IntegerFactory());
		new InstanceFactoryContainer<Widget>(new Widget.Factory());
	}

}



class IntegerFactory implements InstanceFacotory<Integer>{

	@Override
	public Integer create() {
		return new Integer(0);
	}
	
}

class Widget{
	public static class Factory implements InstanceFacotory<Widget>{
		@Override
		public Widget create(){
			return new Widget();
		}
	}
}