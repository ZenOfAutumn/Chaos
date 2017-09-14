package com.zen.autumn.learn.base.reflect;

import com.zen.autumn.learn.base.reflect.annotation.Transfer;
import com.zen.autumn.learn.base.reflect.enums.Type;

public class Movie {

	private Byte type;
	
	@Transfer(source = "type",handle = Type.class)
	private String typeTransfer;
	
	private Integer country;

	public Byte getType() {
		return type;
	}

	public String getTypeTransfer() {
		return typeTransfer;
	}

	public Integer getCountry() {
		return country;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public void setTypeTransfer(String typeTransfer) {
		this.typeTransfer = typeTransfer;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}
	
	
	
	
	
	
	
}
