package com.ayowole.reflectionproject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectionProject {
	
	
	public static void main(String[] args) {
		Class<?> clazz = null;
		
		try {
			clazz = Class.forName("com.ayowole.reflectionproject.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Constructor<?> constructor = null;
		try {
			constructor = clazz.getConstructor();
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		Object object = null;
		try {
			object = constructor.newInstance();
		} catch (InstantiationException 
				| IllegalAccessException 
				| IllegalArgumentException
				| InvocationTargetException e) {
			
			e.printStackTrace();
		}
		
		Person person = null;
		if (object instanceof Person) {
			person = (Person) object;
		}
		
		Field fieldName = null;
		Field fieldAge = null;
		try {
			fieldName = clazz.getDeclaredField("name");
			fieldAge = clazz.getDeclaredField("age");
		} catch (NoSuchFieldException 
				| SecurityException e) {
			e.printStackTrace();
		}
		
		fieldName.setAccessible(true);
		fieldAge.setAccessible(true);
		try {
			fieldName.set(person, "John Doe");
			fieldAge.set(person, 20);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		System.out.println(person.getName());
		System.out.println(person.getAge());
	}
	
	
}
