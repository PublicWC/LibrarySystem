package library.project.Book001;

import java.util.Scanner;

/**
 * @since 2018/09/09
 * @author GG 書本紀錄
 */
public class Book {
    /** 屬性編號 **/
    private String no;
    /** 屬性中文書名 **/
    private String chineseBook;
    /** 屬性英文書名 **/
    private String engBook;
    /** 屬性ISBN **/
    private String isbn;
    /** 屬性價格 **/
    private double price;
    /** 借還記錄 **/
    private BorrowRecord borrowRecord;
    /** 借出與否 **/
    private boolean borrowedOut;
    boolean borrowed;

    public Book(String no, String chineseBook, String engBook, String isbn, double price, BorrowRecord borrowRecord,
            boolean borrowedOut) {
        this.no = no;
        this.chineseBook = chineseBook;
        this.engBook = engBook;
        this.isbn = isbn;
        this.price = price;
        this.borrowRecord = borrowRecord;
        this.borrowedOut = borrowedOut;
    }

    /**
     ** 這邊建構式好像不確定為何需要可能需要問問看吧
     */
    public Book() {
        // TODO 自動產生的建構子 Stub
    }

    @Override
    public String toString() {
        return "/nNo: " + no + "\nISBN: " + isbn + "\nChineseBook" + "chineseBook" + "\nPrice: " + price + "\n";
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getChineseBook() {
        return chineseBook;
    }

    public void setChineseBook(String chineseBook) {
        this.chineseBook = chineseBook;
    }

    public String getEngBook() {
        return engBook;
    }

    public void setEngBook(String engBook) {
        this.engBook = engBook;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // 借出紀錄 : 借閱總次
    public BorrowRecord getBorrowRecord() {
        return borrowRecord;
    }

    public void setBorrowRecord(BorrowRecord borrowRecord) {
        this.borrowRecord = borrowRecord;
    }

    // 借閱狀態: 借出與否
    public boolean isBorrowedOut() {
        return borrowedOut;
    }

    public void setBorrowedOut(boolean borrowedOut) {
        this.borrowedOut = borrowedOut;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
}