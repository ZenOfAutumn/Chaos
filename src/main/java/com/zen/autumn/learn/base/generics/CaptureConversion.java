package com.zen.autumn.learn.base.generics;

class Holder<T> {

	T item;

	public Holder(T item) {
		this.item = item;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
}

public class CaptureConversion {

	static <T> void f1(Holder<T> holder) {
		T t = holder.getItem();
		System.out.println(t.getClass().getSimpleName());
	}

	static void f2(Holder<?> holder) {
		f1(holder);
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		Holder raw = new Holder<Integer>(1);
		
		f1(raw);
		f2(raw);

	}

}
