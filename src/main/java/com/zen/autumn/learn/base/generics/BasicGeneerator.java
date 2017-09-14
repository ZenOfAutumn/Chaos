package com.zen.autumn.learn.base.generics;

public class BasicGeneerator<T> implements Generator<T> {

	private Class<T> type;

	public BasicGeneerator(Class<T> type) {
		this.type = type;
	}

	@Override
	public T next() {

		try {
			return type.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> Generator<T> create(Class<T> type) {
		return new BasicGeneerator<T>(type);
	}

}
