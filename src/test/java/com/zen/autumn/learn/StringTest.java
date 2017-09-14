package com.zen.autumn.learn;

public class StringTest {

	
	public static void main(String[] args) {
		
		String a= "郑州创兴财税咨询有限公司经营郑州创兴财税咨询有限公司经营范围如下郑州创兴财税咨询有限公司经营范围如下郑州创兴财税咨询有限公司";
		
		String b="郑州创兴财税咨询有限公司";
		
		Long start = System.currentTimeMillis();
		
		
		for(int i=0;i<3382268;i++){
			a.contains(b);
		}
		
		System.err.println(System.currentTimeMillis()-start);
		
		
		
	}
}
