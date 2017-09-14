package com.zen.autumn.learn.base.common.utils;

public enum EnumExample implements EnumId<Integer,EnumExample> {

	A(1), B(2), C(3);

	private Integer id;

	@SuppressWarnings("unchecked")
	@Override
	public Integer getId() {
		return id;
	}	
	
	private EnumExample(final int id) {
		this.id = id;
	}

	@Override
	public EnumExample[] getValues() {
		return values();
	}

}
