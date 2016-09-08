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

	public void borrowBook(int Id, String borrower, boolean borrowed){
		for (Book book: books) {
			if(book.getId()==Id){
				book.setBorrowed(borrowed);
				book.setBorrower(borrower);
			}
		}
	}
}
