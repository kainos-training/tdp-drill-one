package com.kainos.drillone;

import com.google.common.collect.Lists;
import com.kainos.drillone.models.Book;
import org.assertj.core.util.Strings;

import java.util.List;

public class DataStore {
	private static List<Book> books = Lists.newArrayList();

	public void initialiseDummyData(){
		Book book = new Book();
		book.setIsbnTen("1234567890");
		book.setIsbnThirteen("1234567890123");
		book.setTitle("programming 101");
		book.setAuthorFirstName("chris");
		book.setAuthorSurname("gill");
		book.setId(1);

		books.add(book);

		book = new Book();
		book.setIsbnTen("1234567540");
		book.setIsbnThirteen("12345as790123");
		book.setTitle("agile 101");
		book.setAuthorFirstName("chris");
		book.setAuthorSurname("gill");
		book.setId(2);

		books.add(book);
		book = new Book();
		book.setIsbnTen("1234567540");
		book.setIsbnThirteen("12345as790123");
		book.setTitle("agile 102");
		book.setAuthorFirstName("chris");
		book.setAuthorSurname("gill");
		book.setId(3);

		books.add(book);

		book = new Book();
		book.setIsbnTen("12345s7540");
		book.setIsbnThirteen("12341as790123");
		book.setTitle("java for dummies");
		book.setAuthorFirstName("chris");
		book.setAuthorSurname("gill");
		book.setId(4);

		books.add(book);
	}

	public List<Book> getBooks() {
		return books;
	}
}
