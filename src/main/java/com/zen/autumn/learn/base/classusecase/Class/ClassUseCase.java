package com.zen.autumn.learn.base.classusecase.Class;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.zen.autumn.learn.base.classusecase.Case.Address;
import com.zen.autumn.learn.base.classusecase.Case.ChinaSong;
import com.zen.autumn.learn.base.classusecase.Case.Market;
import com.zen.autumn.learn.base.classusecase.Case.Song;
import com.zen.autumn.learn.base.classusecase.Case.Song.InnerClass;
import com.zen.autumn.learn.base.classusecase.Case.UninheritedAnnotation;

public class ClassUseCase {

	static void printArray(Object[] objectArray) {
		for (Object o : objectArray) {
			System.out.println(o.toString());
		}
	}

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {

			// forName
			Class<?> song = Class.forName("com.zen.autumn.learn.base.classusecase.Case.Song");

			// newInstance
			Song instance = (Song) song.newInstance();

			// isInstance
			System.out.println("isInstance" + " " + song.isInstance(instance));

			// isAssignableFrom
			System.out.println("isAssignbaleFrom " + (Market.class.isAssignableFrom(Song.class)));
			System.out.println("isAssignbaleFrom " + Song.class.isAssignableFrom(Address.class));

			// isEnum
			// isInterface
			// isArray
			// isPrimitive 是否表示一个基本类型
			System.out.println("isPrimitive " + Song.class.isPrimitive());
			System.out.println("Integer isPrimitive " + Integer.TYPE.isPrimitive());

			// isAnnotation

			// isSynthetic 是否为复合类
			System.out.println("isSynthetic " + Song.class.isSynthetic());

			// getName
			System.out.println("name " + Song.class.getName());

			// getCanonicalName
			System.out.println("CanonicalName " + Song.class.getCanonicalName());

			// getSimpleName
			System.out.println("SimpleName " + Song.class.getSimpleName());

			// getSuperClass
			System.out.println("SuperClass " + Song.class.getSuperclass().getSimpleName());

			// getPackage
			System.out.println("Package " + Song.class.getPackage().getName());

			// getInterfaces
			for (Class<?> interfaces : song.getInterfaces()) {
				System.out.println(interfaces.getSimpleName());
			}

			// 获得内部类的外围类
			System.out.println("======================");
			System.out.println(InnerClass.class.getDeclaringClass().getSimpleName());

			// isAnnoymousClass

			// isLocalClass
			System.out.println("======================");
			System.out.println(Song.class.getClass().getSimpleName());

			// getClasses 返回一个包含某些 Class 对象的数组，这些对象表示属于此 Class
			// 对象所表示的类的成员的所有公共类和接口。包括从超类继承的公共类和接口成员以及该类声明的公共类和接口成员。
			for (Class<?> cls : Song.class.getClasses()) {
				System.out.println(cls.getSimpleName());
			}

			// getFields返回一个包含某些 Field 对象的数组，这些对象反映此 Class 对象所表示的类或接口的所有可访问公共字段。
			for (Field field : Song.class.getFields()) {
				System.out.println(field.getName());
			}

			// getMethods 返回一个包含某些 Method 对象的数组，这些对象反映此 Class
			// 对象所表示的类或接口（包括那些由该类或接口声明的以及从超类和超接口继承的那些的类或接口）的公共 member 方法。
			System.out.println("public method: ");
			for (Method method : song.getMethods()) {
				System.out.println(method.getName());
			}

			// getConstructors 返回一个包含某些 Constructor 对象的数组，这些对象反映此 Class
			// 对象所表示的类的所有公共构造方法。
			System.out.println("public constructors:");
			for (Constructor cons : song.getConstructors()) {
				System.out.println(cons.getName());
			}

			// getDeclaredClasses 返回 Class 对象的一个数组，这些对象反映声明为此 Class
			// 对象所表示的类的成员的所有类和接口。包括该类所声明的公共、保护、默认（包）访问及私有类和接口，但不包括继承的类和接口。
			System.out.println("All classes: ");
			for (Class<?> cls : song.getDeclaredClasses()) {
				System.out.println(cls.getSimpleName());
			}

			// getDeclaredFields 返回 Field 对象的一个数组，这些对象反映此 Class
			// 对象所表示的类或接口所声明的所有字段。包括公共、保护、默认（包）访问和私有字段，但不包括继承的字段。
			System.out.println("All fields: ");
			for (Field field : song.getDeclaredFields()) {
				System.out.println(field.getName());
			}

			// getDeclaredMethods 返回 Method 对象的一个数组，这些对象反映此 Class
			// 对象表示的类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。
			System.out.println("All Methods: ");
			for (Method method : song.getDeclaredMethods()) {
				System.out.println(method.getName());
			}

			// getDeclaredConstructors 返回 Constructor 对象的一个数组，这些对象反映此 Class
			// 对象表示的类声明的所有构造方法。它们是公共、保护、默认（包）访问和私有构造方法。

			System.out.println("All Constructors: ");
			for (Constructor cons : song.getDeclaredConstructors()) {
				System.out.println(cons.getName());
			}
			System.out.println("==========================");

			// getAnnotation 如果存在该元素的指定类型的注释，则返回这些注释，否则返回 null。
			System.out.println(song.getAnnotation(UninheritedAnnotation.class).annotationType());

			// isAnnotationPresent 如果指定类型的注释存在于此元素上，则返回 true，否则返回
			// false。此方法主要是为了便于访问标记注释而设计的。
			System.out.println(song.isAnnotationPresent(Deprecated.class));

			// getAnnotations 返回此元素上存在的所有注释。
			System.out.println(ChinaSong.class.getAnnotations()[0].annotationType());

			// getDeclaredAnnotations 返回直接存在于此元素上的所有注释。
			System.out.println(ChinaSong.class.getDeclaredAnnotations().length);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
