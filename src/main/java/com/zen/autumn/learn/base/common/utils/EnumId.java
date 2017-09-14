package com.zen.autumn.learn.base.common.utils;

@SuppressWarnings("rawtypes")
public interface EnumId<T,E extends EnumId> {

	T getId();

	E[] getValues();

}
