package com.zen.autumn.learn.base.typeInformation;

public class ReflectorTest {

	private ReflectorTest() {

	}

	public void test() {
		System.out.println("test");
	}

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> classType = Class.forName("com.zen.autumn.learn.base.typeInformation.ReflectorTest");
		ReflectorTest re = (ReflectorTest) classType.newInstance();
		re.test();
	}
}
