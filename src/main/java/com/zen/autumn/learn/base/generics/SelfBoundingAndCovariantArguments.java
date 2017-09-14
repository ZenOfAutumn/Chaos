package com.zen.autumn.learn.base.generics;


interface SelfBoundSetter<T extends SelfBoundSetter<T>>{
	
	void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter>{
	
}

class SetterImpl implements SelfBoundSetter<SetterImpl>{

	@Override
	public void set(SetterImpl arg) {		
		
	}	
}

public class SelfBoundingAndCovariantArguments {
	
	@SuppressWarnings("rawtypes")
	void test(Setter s,Setter ss,SelfBoundSetter sbs){
		s.set(ss);
		// s.set(sbs); con't apply base class to Setter
	}

}


