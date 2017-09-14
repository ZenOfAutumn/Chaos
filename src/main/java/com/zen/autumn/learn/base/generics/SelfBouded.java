package com.zen.autumn.learn.base.generics;



class Another{
	
	void get(){
		System.out.println("get");
	}
}

@SuppressWarnings("hiding")
public class SelfBouded<Another> {
	
	Another item;
	
	void test(){
	}
}


class Fellow{
	
}

class Son extends SelfBouded<Fellow>{
	
	
}