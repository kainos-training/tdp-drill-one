package com.kainos.drillone;

import com.google.common.collect.Lists;
import com.kainos.drillone.models.Book;
import com.kainos.drillone.models.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DataStore {

	private static List<Person> people = Lists.newArrayList();
	private static List<Book> books = Lists.newArrayList();

	public List<Person> getPeople() {
		return people;
	}

	public List<Book> getBooks() { return books; }

	public void registerPerson(UUID id, String name, Integer age) {
		Person newPerson = new Person();
		newPerson.setId(id);
		newPerson.setName(name);
		newPerson.setAge(age);
		people.add(newPerson);
	}

	public Book getBookById(int id){
		List<Book> bookList = getBooks();
		Book book = bookList.stream().filter(theBook -> theBook.getId() == id ).findFirst().get();

		return book;
	}

	public void mockList(){
		Book booklet1 = new Book(1, "Jer", "lol", "haha", "143");
		books.add(booklet1);
	}

	public void updateBook(int id, String author, String title, String ISBNTen, String ISBNThirteen) {
		Book book = getBookById(id);
		book.setAuthor(author);
		book.setTitle(title);
		book.setISBNTen(ISBNTen);
		book.setISBNThirteen(ISBNThirteen);
	}
}
