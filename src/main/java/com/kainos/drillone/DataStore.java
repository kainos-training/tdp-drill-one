package com.kainos.drillone;

import com.google.common.collect.Lists;
import com.kainos.drillone.models.Book;
import com.kainos.drillone.models.Person;

import java.util.List;
import java.util.UUID;

public class DataStore {

	private static List<Person> people = Lists.newArrayList();
	private static List<Book> books = Lists.newArrayList();

	public List<Person> getPeople() {
		return people;
	}

	public List<Book> getBooks() {
		Book book = new Book();
		book.setIsbnTen("test");
		book.setIsbnThirteen("t est asd");
		book.setTitle("programming 101");
		book.setAuthorfirstName("chris");
		book.setAuthorSurname("gill");
		book.setId(1);

		books.add(book);

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
