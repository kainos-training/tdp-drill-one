package com.kainos.drillone;

import com.google.common.collect.Lists;
import com.kainos.drillone.models.Book;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class DataStore {

	public static int bookCount = 0;

	private static List<Book> books = Lists.newArrayList();

	public List<Book> getBooks() {
		return books;
	}

	public void addBook(String title, String authorFirstName, String authorLastName, String ISBNTen, String ISBNThirteen) {
		bookCount++;
		Book book = new Book(bookCount, title, authorFirstName, authorLastName, ISBNTen, ISBNThirteen);
		books.add(book);

	}
}
