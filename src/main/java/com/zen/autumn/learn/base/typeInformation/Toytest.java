package com.zen.autumn.learn.base.typeInformation;

interface HasBatteries{}
interface Waterproof{}
interface Shoots{}

class Toy{
//	public Toy() {
//		// TODO Auto-generated constructor stub
//	}
	
	Toy(int i){}
}

class FancyToy extends Toy implements HasBatteries,Waterproof,Shoots{
	
	public FancyToy() {
	super(1);	// TODO Auto-generated constructor stub
	}
}

public class Toytest {
	static void printInfo(Class cc){
		System.out.println("Class Name:"+cc.getName());
		System.out.println("is Interface:"+cc.isInterface());
		System.out.println("Simple Name:"+cc.getSimpleName());
		System.out.println("Canonical Name:"+cc.getCanonicalName());
		
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args){
		Class c = null;
		try{
			c = Class.forName("com.zen.autumn.learn.base.typeInformation.FancyToy");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		printInfo(c);
		
		for(Class face:c.getInterfaces()){
			printInfo(face);
		}
		
		Class up = c.getSuperclass();
		Object obj = null;
		
		try{
			obj = up.newInstance();
		}catch(InstantiationException e){
			e.printStackTrace();
		}catch(IllegalAccessException e){
			e.printStackTrace();
		}
		
		printInfo(obj.getClass());
		
		
		try {
			Class<?> util = Class.forName("com.zen.autumn.learn.base.typeInformation.UtilTest");
			UtilTest instance = null;
			try {
				instance = (UtilTest)util.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(instance.getHello());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
