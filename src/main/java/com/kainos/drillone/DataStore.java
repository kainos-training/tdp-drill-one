package com.kainos.drillone;

import com.google.common.collect.Lists;
import com.kainos.drillone.models.Book;

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

	public Book getBookById(int id){
		List<Book> bookList = getBooks();
		System.out.println("=== id" + id);
		Book book = bookList.stream().filter(theBook -> theBook.getId() == id ).findFirst().get();

		return book;
	}

	public void mockList(){
		Book booklet1 = new Book(1, "Jer", "person", "lol", "haha", "143");
		Book booklet2 = new Book(2, "Laddy", "McSass", "A Good Day on the Beach", "10374123423", "1430723409723");
		Book booklet3 = new Book(3, "Franco","Manca", "Dank Kush: a Love Story", "103741234345", "1435289362923");


		books.add(booklet1);
		books.add(booklet2);
		books.add(booklet3);
	}

	public void updateBook(int id, String author, String title, String ISBNTen, String ISBNThirteen) {
		Book book = getBookById(id);
		book.setAuthorFirstName(author);
		book.setTitle(title);
		book.setIsbnTen(ISBNTen);
		book.setIsbnThirteen(ISBNThirteen);
	}
}
