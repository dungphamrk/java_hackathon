package ra.entity;

import java.util.Scanner;

public class Book implements IApp{
    private String bookId;
    private String bookTitle;
    private String author;
    private String publisher;
    private int publicationYear;
    private String category;
    private double price;
    private int quantity;

    public Book() {
    }

    public Book(String bookId, String bookTitle, String publisher, String author, int publicationYear, double price, String category, int quantity) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.publisher = publisher;
        this.author = author;
        this.publicationYear = publicationYear;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public void inputData(Scanner sc) {
        System.out.println("Nhập mã sách");
        this.bookId = sc.nextLine();
        System.out.println("Nhập tiêu đề sách");
        this.bookTitle = sc.nextLine();
        System.out.println("Nhập tác giả của cuốn sách");
        this.author = sc.nextLine();
        System.out.println("Nhập nhà xuất bản của cuốn sách");
        this.publisher = sc.nextLine();
        System.out.println("Nhập năm xuất bản");
        this.publicationYear = sc.nextInt();
        System.out.println("nhập thể loại sách");
        this.category = sc.nextLine();
        System.out.println("Nhập giá bán sách");
        this.price = sc.nextDouble();
        System.out.println("Nhập số lượng cuốn sách");
        this.quantity = sc.nextInt();
    }

    @Override
    public void displayData() {
        System.out.println("Mã sách:"+bookId + "Tiêu đề sách :"+bookTitle );
        System.out.println("Tác giả:"+author + "Nhà xuất bản :"+publisher+" Năm xuất bản:"+publicationYear  );
        System.out.println("Thể loại sách: "+category + " Giá tiền: "+price+" Số lượng sách: "+quantity);
    }
}
