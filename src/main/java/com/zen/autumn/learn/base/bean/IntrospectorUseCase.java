package com.zen.autumn.learn.base.bean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class IntrospectorUseCase {

	public static void main(String[] args) throws IntrospectionException {

		BeanInfo beanInfo = Introspector.getBeanInfo(Object.class);

		PropertyDescriptor[] des = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor de : des) {
			print(de);

		}

	}

	static void print(PropertyDescriptor des) {

		StringBuilder stringcom = new StringBuilder();
		String name = des.getName();
		String displayName = des.getDisplayName();
		stringcom.append(name + "|");
		stringcom.append(displayName + "|");

		Method get = des.getReadMethod();
		Method set = des.getWriteMethod();
		if (get != null) {
			stringcom.append(get.getName() + "|");
			stringcom.append(set.getName() + "|");
		}

		System.err.println(stringcom.toString());
	}

}
