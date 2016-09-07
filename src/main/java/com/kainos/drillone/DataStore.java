package com.kainos.drillone;

import com.google.common.collect.Lists;
import com.kainos.drillone.models.Book;
import com.kainos.drillone.models.Person;

import java.util.List;
import java.util.UUID;

public class DataStore {

	public static int bookCount = 0;
	private static List<Person> people = Lists.newArrayList();
	private static List<Book> books = Lists.newArrayList();

	public List<Person> getPeople() {
		return people;
	}

	public List<Book> getBooks() {
		return books;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void incrementBookCount(){
		bookCount++;
	}

	public void registerPerson(UUID id, String name, Integer age) {
		Person newPerson = new Person();
		newPerson.setId(id);
		newPerson.setName(name);
		newPerson.setAge(age);
		people.add(newPerson);
	}


	public void addBook(String title, String authorFirstName, String authorLastName, String ISBNTen, String ISBNThirteen) {
		incrementBookCount();
		Book book = new Book(getBookCount(), title, authorFirstName, authorLastName, ISBNTen, ISBNThirteen);
		books.add(book);
	}
}
