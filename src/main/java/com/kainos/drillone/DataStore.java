package com.kainos.drillone;

import com.google.common.collect.Lists;
import com.kainos.drillone.models.Book;

import java.util.List;

public class DataStore {

	public static int bookCount = 0;

	private static List<Book> books = Lists.newArrayList();

	public List<Book> getBooks() {
		return books;
	}

	public void addBook(String title, String authorFirstName, String authorLastName, String ISBNTen, String ISBNThirteen) {
		bookCount++;
		Book book = new Book(bookCount, authorFirstName, authorLastName, title, ISBNTen, ISBNThirteen);
		books.add(book);
	}

	public Book getBookById(int id){
		List<Book> bookList = getBooks();
		Book book = bookList.stream().filter(theBook -> theBook.getId() == id ).findFirst().get();
		return book;
	}
}
