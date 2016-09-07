package com.kainos.drillone;

import com.google.common.collect.Lists;
import com.kainos.drillone.models.Book;
import com.kainos.drillone.models.Person;

import java.util.List;
import java.util.UUID;

public class DataStore {

	public void initialiseDummyData(){
		Book book = new Book();
		book.setIsbnTen("1234567890");
		book.setIsbnThirteen("1234567890123");
		book.setTitle("programming 101");
		book.setAuthorfirstName("chris");
		book.setAuthorSurname("gill");
		book.setId(1);

		books.add(book);

		book = new Book();
		book.setIsbnTen("1234567540");
		book.setIsbnThirteen("12345as790123");
		book.setTitle("agile 101");
		book.setAuthorfirstName("chris");
		book.setAuthorSurname("gill");
		book.setId(2);

		books.add(book);
		book = new Book();
		book.setIsbnTen("1234567540");
		book.setIsbnThirteen("12345as790123");
		book.setTitle("agile 102");
		book.setAuthorfirstName("chris");
		book.setAuthorSurname("gill");
		book.setId(3);

		books.add(book);

		book = new Book();
		book.setIsbnTen("12345s7540");
		book.setIsbnThirteen("12341as790123");
		book.setTitle("java for dummies");
		book.setAuthorfirstName("chris");
		book.setAuthorSurname("gill");
		book.setId(4);

		books.add(book);
	}

	private static List<Person> people = Lists.newArrayList();
	private static List<Book> books = Lists.newArrayList();

	public List<Person> getPeople() {
		return people;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void registerPerson(UUID id, String name, Integer age) {
		Person newPerson = new Person();
		newPerson.setId(id);
		newPerson.setName(name);
		newPerson.setAge(age);
		people.add(newPerson);
	}



}
