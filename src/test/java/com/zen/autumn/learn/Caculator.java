package com.zen.autumn.learn;

public class Caculator {

	static void cal(double a, double b) {

		double r1 = 0.15 * 0.15 * a * a;
		double r2 = 0.2 * 0.2 * (1 - a) * (1 - a);
		double r3 = 2 * 0.2 * 0.15 * a * (1 - a) * b;
		System.out.println(Math.sqrt(r1 + r2 + r3));

	}
	
	static void calE(double a) {

		double r1 = a*0.1;
		double r2 = (1-a)*0.15;
		System.out.println(r1 + r2);

	}

	public static void main(String[] args) {

		cal(0.0672, -1);
		cal(0.6281, 0);
		cal(1, 0.5);
		cal(1, 1);
		calE(0.0672);
		calE(0.6281);
		calE(1);
		calE(1);
		

	}

}
