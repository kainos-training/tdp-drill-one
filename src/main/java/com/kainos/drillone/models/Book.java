package com.kainos.drillone.models;

public class Book {
    private int Id;

    private String Author;

    private String Title;

    private String ISBNTen;

    private String ISBNThirteen;

    public Book(int id, String author, String title, String isbnTen, String isbnThirteen){
        this.setId(id);
        this.setAuthor(author);
        this.setTitle(title);
        this.setISBNTen(isbnTen);
        this.setISBNThirteen(isbnThirteen);
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getISBNTen() {
        return ISBNTen;
    }

    public void setISBNTen(String ISBNTen) {
        this.ISBNTen = ISBNTen;
    }

    public String getISBNThirteen() {
        return ISBNThirteen;
    }

    public void setISBNThirteen(String ISBNThirteen) {
        this.ISBNThirteen = ISBNThirteen;
    }
}
