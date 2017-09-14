package com.zen.autumn.learn.base.classusecase.Case;

import java.util.Date;
import java.util.List;


@InheritedAnnotation
@UninheritedAnnotation
public class Song extends Address implements Market, AnotherInterface {

	protected String name;

	String author;

	Double price;

	List<String> buyerList;

	Date publishTime;

	String[] ArrayString;

	public Song(){
		
	}
	
	public Song(Double price) {
		this.price = price;
	}

	public interface OuterInterface {

	}

	private static class Inner {

	}

	public static class Outer {

	}

	public static final class InnerClass {

	}

	Market local = new Market() {

		@Override
		public void sale() {
			System.out.println("local");

		}
	};

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<String> getBuyerList() {
		return buyerList;
	}

	public void setBuyerList(List<String> buyerList) {
		this.buyerList = buyerList;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	@Override
	public void sale() {
		System.out.println("sale out");
	}

	@Override
	public void modify() {
		// TODO Auto-generated method stub

	}

}
