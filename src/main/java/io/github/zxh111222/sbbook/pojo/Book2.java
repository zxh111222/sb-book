package io.github.zxh111222.sbbook.pojo;

public class Book2 {
    private String title;
    private String isbn;
    private String cip;
    private String isbn13;
    private String isbn10;
    private String author;
    private String binding;
    private String publisher;
    private String publishedYear;
    private String publicationPlace;
    private String price;
    private String imageURl;
    private String message;

    public Book2() {
    }

//    public IsbnInfo(String title, String isbn13, String isbn10, String author, String binding, String publisher, String publishedYear, String imageURl) {
//        this.title = title;
//        this.isbn13 = isbn13;
//        this.isbn10 = isbn10;
//        this.author = author;
//        this.binding = binding;
//        this.publisher = publisher;
//        this.publishedYear = publishedYear;
//        this.imageURl = imageURl;
//    }

        public Book2(String title, String isbn, String cip, String publisher, String publicationPlace, String publishedYear, String price, String imageUrl) {
            this.title = title;
            this.isbn = isbn;
            this.cip = cip;
            this.publisher = publisher;
            this.publicationPlace = publicationPlace;
            this.publishedYear = publishedYear;
            this.price = price;
            this.imageURl = imageUrl;
        }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImageURl() {
        return imageURl;
    }

    public void setImageURl(String imageURl) {
        this.imageURl = imageURl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public String getPublicationPlace() {
        return publicationPlace;
    }

    public void setPublicationPlace(String publicationPlace) {
        this.publicationPlace = publicationPlace;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "IsbnInfo{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", cip='" + cip + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                ", isbn10='" + isbn10 + '\'' +
                ", author='" + author + '\'' +
                ", binding='" + binding + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishedYear='" + publishedYear + '\'' +
                ", publicationPlace='" + publicationPlace + '\'' +
                ", price='" + price + '\'' +
                ", imageURl='" + imageURl + '\'' +
                '}';
    }
}
