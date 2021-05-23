package model;

public class Quote {
    String saying;
    String author;

    public Quote(String saying, String author) {
        this.saying = saying;
        this.author = author;
    }

    public String getSaying() {
        return saying;
    }

    public String getAuthor() {
        return author;
    }
}
