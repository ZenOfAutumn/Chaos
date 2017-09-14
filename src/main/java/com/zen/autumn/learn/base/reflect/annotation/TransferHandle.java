package com.zen.autumn.learn.base.reflect.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.IncompleteAnnotationException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;

import com.zen.autumn.learn.base.reflect.Movie;
import com.zen.autumn.learn.base.reflect.enums.FieldTransferHandle;

public class TransferHandle {
	
	
	private static final String GETTER_PREFIX = "get";
	
	private static final String SETTER_PREFIX = "set";
	
	static void Handle(Object instance) throws NoSuchFieldException, SecurityException, NoSuchMethodException,  IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		
		Class<?> cls = instance.getClass();
		Field[] fields = cls.getDeclaredFields();
		for(Field field:fields){
			Annotation annotation = field.getDeclaredAnnotation(Transfer.class);
			if(annotation == null){
				continue;
			}
			Transfer transfer = (Transfer)annotation;			
			String sourceName = transfer.source();
			if(StringUtils.isBlank(sourceName)){
				throw new IncompleteAnnotationException(Transfer.class,"source");
			}
			
			Field source = cls.getDeclaredField(sourceName);
			
			
			Class<?> enumType = transfer.handle();
			if(enumType == null|| !enumType.isEnum()){
				throw new IncompleteAnnotationException(Transfer.class,"handle");
			}
			
			if(!enumType.getDeclaredField(FieldTransferHandle.ID).getType().equals(source.getType())){
				throw new IncompleteAnnotationException(Transfer.class,"source");
			}
			
			
			@SuppressWarnings({ "rawtypes", "unchecked" })
			FieldTransferHandle<? extends FieldTransferHandle, Object> handle = (FieldTransferHandle) enumType.getEnumConstants()[0];			
				
			
			Method getMethod = cls.getMethod(constructGetterMethod(sourceName));
			Method setMethod = cls.getMethod(constructSetterMethod(field.getName()),field.getType());
			setMethod.invoke(instance, handle.getEnumById(getMethod.invoke(instance, null)).getName());			
			
			
		}
		
	}
	
	
	public static String constructMethod(final String fieldName,final String prefix){
		StringBuilder builder = new StringBuilder(fieldName.length()+prefix.length());
		builder.append(prefix).append(fieldName.substring(0,1).toUpperCase()).append(fieldName.substring(1));
		return builder.toString();		
	}
	
	
	public static String constructGetterMethod(final String fieldName){
		return constructMethod(fieldName,GETTER_PREFIX);	
	}
	
	public static String constructSetterMethod(final String fieldName){
		return constructMethod(fieldName,SETTER_PREFIX);
	}
	
	
	public static void main(String[] args) {
		
		String field = "movie";	
		
		System.out.println(constructGetterMethod(field));
		System.out.println(constructSetterMethod(field));

		
		Movie movie = new Movie();
		movie.setType((byte)1);
		
			try {
				Handle(movie);
			} catch (NoSuchFieldException | SecurityException | NoSuchMethodException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(movie.getTypeTransfer());
		
		
		
		
		
	}

}
