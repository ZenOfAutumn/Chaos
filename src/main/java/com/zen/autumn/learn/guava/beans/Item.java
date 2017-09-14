package com.zen.autumn.learn.guava.beans;

import java.util.List;

import com.google.common.collect.Lists;

public class Item {

	private String name;

	private boolean flag;
	
	public static final List<Item> LIST_CASE = Lists.newArrayList(new Item("11", true), new Item("22", false), new Item("", true));

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Item(String name, boolean flag) {
		this.name = name;
		this.flag = flag;
	}

	public static List<Item> generateItems() {
		return Lists.newArrayList(new Item("11", true), new Item("22", false), new Item("", true));
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", flag=" + flag + "]";
	}
	
}
