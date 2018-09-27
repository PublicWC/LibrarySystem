package library.project.Book001;

import java.util.Date;

/**
 * @since 2018/09/10
 * @author GG
 * 
 **         借書: 一、選擇借書，則列出圖書館中所有的書供使用者選擇， 確認借閱書籍後從館藏中找出對應的書本變更借出狀態。
 */
public class BorrowRecord {

    /** 編號 **/
    private int id;

    /** 借出日期 **/
    private Date borrowedDate;

    /** 還書日期 **/
    private Date returnedDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }
}