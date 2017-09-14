package com.zen.autumn.learn.base.classusecase.Method;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.zen.autumn.learn.base.classusecase.Case.UninheritedAnnotation;

public class MethodUseCase {

	/**
	 * 
	 * @param hello
	 * @param world
	 * @throws IllegalArgumentException
	 */
	@UninheritedAnnotation
	public static void staticMethod(@UninheritedAnnotation String hello, @UninheritedAnnotation String world) {
		System.out.println("static methods");
		if (hello == null) {
			throw new IllegalArgumentException();
		}
	}

	public static void main(String[] args) {
		try {

			Method m = MethodUseCase.class.getDeclaredMethod("staticMethod", String.class, String.class);

			// getName
			System.out.println(m.getName());

			// getDeclaringClass
			System.out.println(m.getDeclaringClass().getName());

			// getModifiers

			// getReturnType 返回一个 Class 对象，该对象描述了此 Method 对象所表示的方法的正式返回类型。
			System.out.println(m.getReturnType().getSimpleName());

			// getParameterTypes 按照声明顺序返回 Class 对象的数组，这些对象描述了此 Method
			// 对象所表示的方法的形参类型。如果底层方法不带参数，则返回长度为 0 的数组。
			System.out.println(m.getParameterTypes());

			// getExceptionTypes 返回 Class 对象的数组，这些对象描述了声明将此 Method
			// 对象表示的底层方法抛出的异常类型。
			System.out.println(m.getExceptionTypes());

			// invoke 对带有指定参数的指定对象调用由此 Method
			// 对象表示的底层方法。个别参数被自动解包，以便与基本形参相匹配，基本参数和引用参数都随需服从方法调用转换。
			try {
				m.invoke(null, "11", "22");

				// isVarArgs 如果将此方法声明为带有可变数量的参数，则返回 true；否则，返回 false。
				System.out.println(m.isVarArgs());
				// getDefaultValue 返回由此 Method
				// 实例表示的注释成员的默认值。如果该成员为基本类型，则返回相应包装器类型的实例。如果不存在与该成员关联的默认值或者该成员实例不表示注释类型的声明成员，则返回
				// null。
				Method mm = UninheritedAnnotation.class.getDeclaredMethod("value", null);
				System.out.println(mm.getDefaultValue());

				// getParameterAnnotations 返回表示按照声明顺序对此 Method
				// 对象所表示方法的形参进行注释的那个数组的数组。

				for (Annotation[] aa : m.getParameterAnnotations()) {
					for (Annotation a : aa) {
						System.out.println(a);
					}
				}

			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SecurityException | NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
