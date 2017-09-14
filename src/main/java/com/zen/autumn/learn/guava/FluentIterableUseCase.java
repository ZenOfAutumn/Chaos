package com.zen.autumn.learn.guava;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.zen.autumn.learn.guava.beans.Item;

public class FluentIterableUseCase {
	
	public static void main(String[] args) {
		
		System.out.println(FluentIterable.from(Item.LIST_CASE).filter(new Predicate<Item>() {
			@Override
			public boolean apply(Item input) {
				return input.isFlag();
			}
		}).toList());
		
	}

}
