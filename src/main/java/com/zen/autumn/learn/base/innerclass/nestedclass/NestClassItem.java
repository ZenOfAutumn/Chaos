package com.zen.autumn.learn.base.innerclass.nestedclass;

public class NestClassItem {

	public static class NestClass {

		private String className;

		public NestClass(String className) {
			this.className = className;
		}

		public void Print() {
			System.out.println(className);
		}

	}	
	
}
