package com.kainos.drillone.models;

public class Book {
    private int Id;

    private String AuthorFirstName;

    private String AuthorSurname;

    private String Title;

    private String ISBNTen;

    private String ISBNThirteen;

    public Book(int id, String authorFirstName, String authorSurname, String title, String isbnTen, String isbnThirteen){
        this.setId(id);
        this.setAuthorFirstName(authorFirstName);
        this.setAuthorSurname(authorSurname);
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

    public String getAuthorFirstName() {
        return AuthorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        AuthorFirstName = authorFirstName;
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

    public String getAuthorSurname() {
        return AuthorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        AuthorSurname = authorSurname;
    }
}
