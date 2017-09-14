interface face{
	
	 String A = "a";
	
	 void foo();
	
	 void bar();
	
}

class faceface implements face{
	
	
	public void foo() {
		System.err.println(face.A);
	}

	
	 public void bar() {
		// TODO Auto-generated method stub
		
	};
}

interface I1{
	
	void foo();
	
	void bar();
}

interface I2{
	
	void foo();
	
	int bar(int i);
}

class C{
	
	public void foo(){
	
	}
}

class C1 implements I1,I2{
	
	@Override
	public void bar() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int bar(int i) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void foo() {
		// TODO Auto-generated method stub
		
	}
}

class C5 extends C implements I1{

	@Override
	public void bar() {
		// TODO Auto-generated method stub
		
	}
	
	
}



public class Interface {

	public static void main(String[] args) {
		
		face f = new faceface();
		
		f.foo();
	}
	
}
