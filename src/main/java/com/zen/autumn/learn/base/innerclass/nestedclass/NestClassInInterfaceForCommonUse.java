package com.zen.autumn.learn.base.innerclass.nestedclass;


// 接口内定义默认函数
public interface NestClassInInterfaceForCommonUse {

	void print();
	
	class DefaultImplements implements NestClassInInterface{
		
		public void print() {
			System.out.println("this is a default implements.");
			
		}
		
	}
	
	
}
