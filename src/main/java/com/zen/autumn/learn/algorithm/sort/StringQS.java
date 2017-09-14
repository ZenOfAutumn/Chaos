package com.zen.autumn.learn.algorithm.sort;

import java.util.Arrays;

public class StringQS {
	
	public static void per(char[] group){
		
		perHelper(group, 0);
		
	}
	
	
	public static void swap(char[] group, int i,int j){
		char t = group[i];
		group[i] = group[j];
		group[j] = t;
	}
	
	
	public static void perHelper(char[] group,int i){
		if(i == group.length-1){
			System.out.println(Arrays.toString(group));
		}
		
		int k = i;
		for(int j = i;j<group.length;j++ ){
			swap(group,k,j);
			perHelper(group, i+1);
			swap(group,k,j);
		}
		
	}
	
	public static void main(String[] args) {
		per(new char[]{'a','b','c'});
	}


}
