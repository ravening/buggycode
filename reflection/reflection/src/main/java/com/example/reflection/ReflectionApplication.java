package com.example.reflection;

import com.example.reflection.models.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

@SpringBootApplication
public class ReflectionApplication {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
		SpringApplication.run(ReflectionApplication.class, args);

		Class<?> stringClass = "Hello".getClass();
		System.out.println(stringClass);

		String className = "java.lang.String";
		stringClass = Class.forName(className);
		System.out.println(stringClass);

		Class<?> personClass = Person.class;

		// this gives only the public fields
		Field field = personClass.getField("publicAge");
		System.out.println(field.toString());

		// this gets all fields of a class
		Field[] declaredFields = personClass.getDeclaredFields();
		Arrays.stream(declaredFields).forEach(System.out::println);

		System.out.println("======");
		// this gets only public fields and inherited fields
		declaredFields = personClass.getFields();
		Arrays.stream(declaredFields).forEach(System.out::println);

		System.out.println("===getting methods===");

		Method[] methods = personClass.getDeclaredMethods();
		Arrays.stream(methods).forEach(System.out::println);

		System.out.println("=====Displaying all static methods=====");
		Arrays.stream(methods)
				.filter(m -> Modifier.isStatic(m.getModifiers()))
				.forEach(System.out::println);

		System.out.println("===getting constructors===");
		Constructor[] declaredConstructors = personClass.getDeclaredConstructors();
		Arrays.stream(declaredConstructors).forEach(System.out::println);

		// modifiers. first bit - public, second - private, 3 - protected, 4 - static
		field = personClass.getField("publicAge");
		System.out.println("=Modifier is " + field.getModifiers());
		int isPublic = field.getModifiers() & 0x00000001;
		System.out.println("isPublic ? " + isPublic);

		boolean isPublicField = Modifier.isPublic(field.getModifiers());
		System.out.println("isPublicField ? " + isPublicField);


		field = personClass.getDeclaredField("age");
		System.out.println("Modifier is " + field.getModifiers());
		System.out.println(Modifier.isPrivate(field.getModifiers()));

		field = personClass.getDeclaredField("firstName");
		System.out.println("firstName modifier is " + field.getModifiers());
		System.out.println("is protected ? " + Modifier.isProtected(field.getModifiers()));
	}

}
