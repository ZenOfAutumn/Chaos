package com.zen.autumn.learn.jvm.resolution;

interface I1{
	int A = 0;
}

interface I2 extends I1{
 //	int A = 0;
}


class C1{
	public int C = 1;
}

class C2 extends C1 implements I2,I1{
	
	int B = A;
	public int C = 3;
	
}



public class FieldResolution {
	
	public static void main(String[] args) {
		C2 c2 = new C2();
		C1 c1  = new C2();
		System.out.println(c2.C);
		System.out.println(c1.C);
	}
	
	
	

}
