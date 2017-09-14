package com.zen.autumn.learn.base.classusecase.Field;

import java.lang.reflect.Field;

import com.zen.autumn.learn.base.classusecase.Case.UninheritedAnnotation;

public class FieldUseCase {

	@UninheritedAnnotation
	private String name;

	public FieldUseCase(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		try {

			FieldUseCase cc = new FieldUseCase("japan");

			Field f = FieldUseCase.class.getDeclaredField("name");

			// getDeclaringClass 返回表示类或接口的 Class 对象，该类或接口声明由此 Field 对象表示的字段。

			System.out.println("declared class: " + f.getDeclaringClass().getSimpleName());
			// getName
			System.out.println(f.getName());

			// getModifiers
			System.out.println(f.getModifiers());

			// isEnumConstant
			System.out.println(f.isEnumConstant());

			// getType
			System.out.println("=======" + f.getType().getName());

			// get 返回指定对象上此 Field 表示的字段的值。如果该值是一个基本类型值，则自动将其包装在一个对象中。

			System.out.println(f.get(cc));

			// getBoolean
			// getByte
			// getChar
			// getShort
			// getInt
			// getLong
			// getFloat
			// getDouble
			
			// set
			f.set(cc, "japanese");
			System.out.println(f.get(cc));
			
			//setBoolean
			//setByte
			//setChar
			//setShort
			//setInt
			//setLong
			//setFloat
			//setDouble
			
			//getAnnotations
			System.out.println(f.getAnnotations()[0].annotationType());

			//getAnnotation 如果存在该元素的指定类型的注释，则返回这些注释，否则返回 null。如果存在该元素的指定类型的注释，则返回这些注释，否则返回 null。
			System.out.println(f.getAnnotation(UninheritedAnnotation.class).annotationType());
			
			//getDeclaredAnnotation
			
			//getDeclaredAnnotations 返回直接存在于此元素上的所有注释。与此接口中的其他方法不同，该方法将忽略继承的注释。
			System.out.println(f.getDeclaredAnnotations()[0].annotationType());

			

		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
