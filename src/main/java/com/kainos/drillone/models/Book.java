package com.kainos.drillone.models;

import org.assertj.core.util.Strings;

public class Book {
    private int id;

    private String authorFirstName;

    private String authorSurname;

    private String title;

    private String isbnTen;

    private String isbnThirteen;

    private String bookImageLink;

    private String defaultBookImageLink="/assets/images/default.png";

    public Book(){};

    public Book(int id, String authorFirstName, String authorSurname, String title, String isbnTen, String isbnThirteen,
                String bookImageLink){
        this.setId(id);
        this.setAuthorFirstName(authorFirstName);
        this.setAuthorSurname(authorSurname);
        this.setTitle(title);
        this.setIsbnTen(isbnTen);
        this.setIsbnThirteen(isbnThirteen);
        if(Strings.isNullOrEmpty(bookImageLink)){
            this.setBookImageLink(defaultBookImageLink);
        }
        else{
            this.setBookImageLink(bookImageLink);
        }
    }


    public Book(int id, String authorFirstName, String authorSurname, String title, String isbnTen, String isbnThirteen){
        this.setId(id);
        this.setAuthorFirstName(authorFirstName);
        this.setAuthorSurname(authorSurname);
        this.setTitle(title);
        this.setIsbnTen(isbnTen);
        this.setIsbnThirteen(isbnThirteen);

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbnTen() {
        return isbnTen;
    }

    public void setIsbnTen(String isbnTen) {
        this.isbnTen = isbnTen;
    }

    public String getIsbnThirteen() {
        return isbnThirteen;
    }

    public void setIsbnThirteen(String isbnThirteen) {
        this.isbnThirteen = isbnThirteen;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public String getBookImageLink() {
            return this.bookImageLink;
    }

    public void setBookImageLink(String bookLink) {this.bookImageLink = bookLink;}
}
