package com.zen.autumn.learn.designPattern.prototype;


class C implements Cloneable{
	public  String ll;
	
	public C(final String ll){
		this.ll = ll;
	}

	@Override
	protected C clone()  {
		try{
			C result = (C) super.clone();
			result.ll = ll;
			return result;
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return null;
	}
//	@Override
//	public String toString() {
//		return "C [ll=" + ll + "]";
//	}
//	
	
}

class B implements Cloneable{
	public  C cc;
	
	public B(final C cc) {
		this.cc = cc;
	}
//
//	@Override
//	public String toString() {
//		return "B [cc=" + cc + "]";
//	}
//	
//	
	
	@Override
	protected B clone(){
		try{
			B result = (B) super.clone();
			result.cc = cc.clone();
			return result;
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return null;
	}
	
}

public class A implements Cloneable {
	
	public B b;
	
	public A(final B b) {
		this.b = b;
	}
	
	@Override
	protected  A clone() {
       try{
    	   A result = (A)super.clone();
    	   result.b = b.clone();
    	   return result;
       }catch(CloneNotSupportedException e){
    	   e.printStackTrace();
       }
	return null;
	}
	
//	@Override
//	public String toString() {
//		return "A [b=" + b + "]";
//	}




	public static void main(String[] args) throws CloneNotSupportedException {
		A a = new A(new B(new C("11")));
		A b = (A) a.clone();
		
		System.out.println(b.b);
		System.out.println(a.b);
		
		System.out.println(b.b.cc);
		System.out.println(a.b.cc);
		
		System.out.println(b.b.cc.ll);
		System.out.println(a.b.cc.ll);
		
		
		
		System.out.println(a);
		System.out.println(b);
		
		

		print(A.class.getMethods());
	}
	
	
	 public static <T> void print(T[] a){
		for(T aa:a){
			System.out.println(aa);
		}
	}

}
