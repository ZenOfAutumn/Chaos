package com.zen.autumn.learn.jvm.order;

interface Face{
	void iM();
}


class Father{
	void fM() {
	}
}

class FaceImpl implements Face {

	@Override
	public void iM() {
		
	}
	
}


class InvokeInterface{
	
	
	void invoke(){
		FaceImpl f = new FaceImpl();
		f.iM();
	}
	
	
}

public class InvokeType extends FaceImpl implements Face {
	
	public InvokeType() {

	}

	private void pM(){
		
	}

	
	static void sM(){
		
	}
	

	public void invoke(){
		iM();
	}
	
}
