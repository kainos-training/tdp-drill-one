package com.kainos.drillone.models;

public class Book {
    private int Id;

    private String authorFirstName;

    private String authorSurname;

    private String title;

    private String isbnTen;

    private String isbnThirteen;

    private boolean borrowed;

    private String borrower;

    public Book(){};

    public Book(int id, String authorFirstName, String authorSurname, String title, String isbnTen, String isbnThirteen){
        this.setId(id);
        this.setAuthorFirstName(authorFirstName);
        this.setAuthorSurname(authorSurname);
        this.setTitle(title);
        this.setIsbnTen(isbnTen);
        this.setIsbnThirteen(isbnThirteen);
        this.setBorrower("");
        this.setBorrowed(false);
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) { this.authorFirstName = authorFirstName; }

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

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public boolean isBorrowed() { return borrowed; }

    public void setBorrowed(boolean borrowed) {this.borrowed=borrowed;}
}
