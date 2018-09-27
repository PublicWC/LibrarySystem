/**圖書館借閱系統: 
 * 
 * 一.使用者透過命令提示字元操作系統
 * 二. 輸入 1.借書2.還書3.捐書4.離開
 *  1.借書，列出圖書中所有書供使用者選擇，確認借閱書籍從館書中找出對應書籍，使用者狀態"XX使用者已成功借出"。
 *  2.還書，列出使用者身上目前所借閱的書籍供選擇，確認還回的書本則變更書本的借出狀態，並更新使用者的借閱清單。 
 *  3.捐書，則需輸入書籍資訊(以分號隔開)，
      例：哈利波特;Harry Potter;ABCD123456;450; 
          (中文書名;英文書名;ISBN;價格) ，確認輸入後，將書本加入館藏。 
 *  4.離開，則跳結束程式。
 * 三. 
 * 圖書館中本來就有十「種」書(書可重覆)， 
    每一本書要記錄的資訊如下: 
    a.編號 
    b.中文書名 
    c.英文書名(可選) 
    d.ISBN 
    e.價格 
    f.借／還記錄 
    g.借出與否
 * 
 */

/**
 * ===============================================================================================================================================================
 * 問題: 
 * 	1.我知道我寫java程式很糟糕，可以請大神們說說我需改進地方在哪邊? 
 * 	2.我現在print出來東西邏輯都不是很對，但我也想了三個禮拜，就是到頂了，無法完成，寫了又改改了又寫，
 * 		9/9號日期是我已經寫了第三遍了，可以引領初學者我嗎?給點方向了(跪求)
 * 	3.如果內文寫的不完整再次跟我說，我隨時改正自己缺陷。 
 * 	4.總之借閱、捐書、還書部分都是有問題的，可以修正我寫出東西嗎(ps:
 * 雖然都靠google大神完成但畢竟題目不同還是很多撰寫不出來甚至錯誤)? 最後 ps:
 * 學java時間是從2018/07底到現在，沒任何程式相關經驗，如果寫不好，可以噴小力一點嗎，拜託了(我蠻笨的)!
 * =====================================================================================================================================================================
 */
package library.project.Book001;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * @since 2018/09/09
 * @author GG 
 * 	一.使用者透過命令提示字元操作系統 
 * 	二.輸入 1.借書2.還書3.捐書4.離開
 *         1.借書，列出圖書中所有書供使用者選擇，確認借閱書籍從館書中找出對應書籍，使用者狀態"XX使用者已成功借出"。
 *         2.還書，列出使用者身上目前所借閱的書籍供選擇，確認還回的書本則變更書本的借出狀態，並更新使用者的借閱清單。
 *         3.捐書，則需輸入書籍資訊(以分號隔開)， 例：哈利波特;Harry Potter;ABCD123456;450;
 *         (中文書名;英文書名;ISBN;價格) ，確認輸入後，將書本加入館藏。
 *         4.離開，則跳結束程式。 
 *  三.圖書館中本來就有十「種」書(書可重覆)， 每一本書要記錄的資訊如下: 
 *  	a.編號 
 *  	b.中文書名 
 *  	c.英文書名(可選) 
 *  	d.ISBN 
 *  	e.價格
 *      f.借／還記錄 
 *      g.借出與否
 * 
 */
public class Main {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Book> booklist = new ArrayList<Book>();
    public static int count = 0;

    // 圖書搜索類型
    private int type = 0;
    // 圖書名稱
    private static String name = "";

    public Main() {
        printMenu();
        while (true) {
            // 讀取用戶輸入
            int choice = scanner.nextInt();
            if (choice == 6) {
                System.out.println("成功退出系統，歡迎再次光臨!!");
                break;
            }
            switch (choice) {
            case 5:
                borrowBook();
                break;// 借書
            // case 5: returnBook(); break;//還書
            case 1:
                addBook(null, null, null, null);
                break;// 函數裡面帶有4個參數值
            case 2:
                delBook();
                break;
            case 3:
                changeBook(choice);
                break;// 函數裡面帶有物件參數值
            case 4:
                findBook();
                break;
            default:
                System.out.println("輸入錯誤，請重新輸入。");
                printMenu();
                continue;
            }
        }
    }// Main

    // print
    public void printMenu() {
        // 打印選單菜單
        System.out.println("歡迎蒞臨圖書館XD");

        System.out.println("1. 新增 / 捐書(功能)書籍");
        System.out.println("2. 刪除(功能)書籍");
        System.out.println("3. 修改(功能)書籍");
        System.out.println("4. 查詢(功能)書籍");
        System.out.println("5. 借書功能書籍");
        System.out.println("6. 退出(功能)系統");
    }

    /** * 借書類型 */
    public void borrowBook() {
        String[] borrowbooks = { "外國史", "人命關天", "三紹空", "JAVA入門到放棄", "Mysql學到到跑路", "黑客攻心防" };
        Main a = new Main();
        a.book_list(borrowbooks);
        // 圖書列表
        a.book_list(borrowbooks);
        // 選擇搜尋類型
        a.search_type();
        // 搜尋書籍
        a.search_book(borrowbooks);
        // 顯示圖書(書籍)
        System.out.println("您選擇書籍為:" + a.name);
    }

    public void borrowBook(String chineseBook) {
        int found = 0;
        for (Book b : booklist) {
            if (b.getChineseBook().equals(chineseBook)) {
                if (found == 0) {
                    found = 1;
                }
                if (!b.isBorrowedOut()) {
                    b.borrowed = true;
                    found = 2;
                    break;
                }
            }
        }
        if (found == 0) {
            System.out.println("對不起，這本書不在我們的目錄中");
        } else if (found == 1) {
            System.out.println("對不起，這本書已經借出了.");
        } else if (found == 2) {
            System.out.println("你成功借出了 " + chineseBook + "書本!");
        }
    }

    public void book_list(String[] books) {
        System.out.println("序號名稱:　");
        for (String book : books) {
            System.out.println(book);
        }
    }

    /** * 設計搜尋類型 */
    public void search_type() {
        Scanner type_number = new Scanner(System.in);
        while (true) {
            try {
                // System.out.println("輸入: 1.名稱查詢 ; 2.序號查詢 " );
                int number = type_number.nextInt();
                if (number == 1 || number == 2) {
                    this.type = number;
                    break;
                } else {
                    throw new Exception();
                }
            } catch (InputMismatchException e) {
                System.out.println("命令輸入錯誤!請根據提示輸入數字命令!");
                type_number.nextLine();
            } catch (Exception e) {
                System.out.println("命令輸入錯誤!請根據提示輸入數字命令!");
            }
        }
    }

    /** * 搜尋書本 * @param books */
    public void search_book(String[] books) {
        while (true) {
            try {
                Scanner search = new Scanner(System.in);
                if (this.type == 1) {
                    System.out.println("輸入書名稱:");
                    String book_name = search.nextLine();
                    // 初始化
                    boolean is_true = false;
                    // 循環判斷圖書名稱是否存在
                    for (String book : books) {
                        if (book.equals(book_name)) {
                            is_true = true;
                        }
                    }
                    if (is_true == false) {
                        throw new Exception();
                    }
                    this.name = book_name;
                    break;
                } else if (this.type == 2) {
                    System.out.println("輸入書序號:");
                    int book_number = search.nextInt();
                    if (book_number < 1 || book_number > books.length) {
                        throw new Exception();
                    }
                    //
                    this.name = books[book_number - 1];
                    break;
                    //
                } else {
                    System.out.println("系統輸入錯誤!");
                    System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("書本不存在");
            }
        }
    }
    // 借書end

    // 新增
    public void addBook(String chineseBook, String engBook, String isbn, String price) {
        if (count < booklist.size() - 1) {// A+
            System.out.println("當前共有: " + count + "本書! ");
            Scanner scanner = new Scanner(System.in);

            System.out.println("中文書名: " + chineseBook + "書本 ! ");
            System.out.println("請輸入中文書名:");
            String bookNameChinese = scanner.nextLine();

            System.out.println("英文書名:  " + engBook + "書本 ! ");
            System.out.println("請輸入英文書名:");
            String bookNameEng = scanner.nextLine();

            System.out.println("ISBN: " + isbn + "號 ! ");
            System.out.println("請輸入ISBN碼:");
            String bookIsbn = scanner.nextLine();

            System.out.println("價格:  " + price + "元 ! ");
            System.out.println("請輸入價格:");
            double bookPrice = scanner.nextDouble();

            Book book = new Book(chineseBook, engBook, isbn, price, bookPrice, null, false);
            // booklist[count] = book;//A-
            booklist.add(book);// A+
            count++;
            System.out.println("新增書本成功XD");
            printAllBook();
        } else {
            System.out.println("圖書倉庫已滿RRRRRRRRRRR!");
        }
    }// 新增end
     // 刪除

    public void delBook() {
        while (true) {
            System.out.println("請輸入要按哪種方式刪除書籍: 1. 編號\t 2.書名\t 3.返回助選單\t");
            int delB = scanner.nextInt();

            if (delB == 1) {
                System.out.println("請問要刪除第幾本: ");
                int id = scanner.nextInt();
                id = orderFind(id);
                System.out.println(id);

                if (id > -1) {
                    // for(int i = id; i < count-1; i++) {
                    // booklist[i] = booklist[i+1];
                    // }//A-
                    booklist.remove(id);// A+
                    count--;
                    System.out.println("刪除成功");
                    printAllBook();
                } else {
                    System.out.println("輸入錯誤!!!");
                }
            } // 1
            if (delB == 2) {
                System.out.println("請輸入您要刪除書名： ");
                String name = scanner.next();
                int id = nameFind(name);
                if (id > -1) {
                    // for(int j = id; j < count-1; j++) {
                    // booklist[j] = booklist[j+1];
                    // }//A-
                    booklist.remove(id);// A+
                    count--;
                    System.out.println("刪除成功!");
                    printAllBook();
                } else {
                    System.out.println("為查找到您想要書名!!");
                }
            } else if (delB == 3) {
                printMenu();
                break;
            } else {
                System.out.println("輸入不正確，請再次輸入正確數。");
            } // 2
        }
    }// 刪除end
     // 修改

    public void changeBook(Object books) {
        while (true) {
            System.out.println("請輸入哪種方法修改書籍: 1.編號\t2.書名\t3.返回主選單\t");
            int change = scanner.nextInt();
            if (change == 1) {
                System.out.println("請輸入要修改幾本書： ");
                int number = scanner.nextInt();
                int id = orderFind(number);
                if (id > -1) {
                    // System.out.println("中文原書名為： "+booklist[id].getChineseBook()+" 請輸入你要修改中文書名：
                    // ");
                    System.out.println("中文原書名為：" + ((Book) books).getChineseBook() + " 請輸入你要修改中文書名：");// A+
                    String str = scanner.next();
                    System.out.println("請輸入作者：");
                    String author = scanner.next();
                    System.out.println("請輸入單價：");
                    float price = scanner.nextFloat();
                    // booklist[id].setChineseBook(str);//A-
                    System.out.println("修改成功！");
                    printAllBook();
                } else {
                    System.out.println("輸入有錯誤，請更正!");
                }
            } // 1
            else if (change == 2) {
                System.out.println("請輸入您要修改的書名： ");
                String name = scanner.next();
                int id = nameFind(name);
                if (id > -1) {
                    Book book = (Book) booklist.get(id);
                    // System.out.println("原書名為："+booklist[id].getChineseBook()+" 請輸入你要修改書名：");
                    String str = scanner.next();
                    System.out.println("請輸入作者：");
                    String author = scanner.next();
                    System.out.println("請輸入單價：");
                    float price = scanner.nextFloat();

                    // booklist[id].setChineseBook(str);//A-
                    System.out.println("修改成功！");
                    printAllBook();
                }
            } else if (change == 3) {
                printMenu();
                break;
            } else {
                System.out.println("輸入錯誤！");
            } // 2
        }
    }

    // 修改end
    // 查詢尋找
    public void findBook() {
        while (true) {
            System.out.println("請輸入按哪種方法查詢書籍：1、編號/2、書名/3、返回主選單");
            int choose = scanner.nextInt();
            if (choose == 1) {
                System.out.println("請輸入您要查詢第幾本書： ");
                int number = scanner.nextInt();
                int id = orderFind(number);
                if (id > -1) {
                    Book book = (Book) booklist.get(id);// ArrayList獲取指定元素的方法
                    // System.out.println("你要查詢書名為："+booklist[id].getChineseBook()+"
                    // 作者："+booklist[id].getIsbn()+" 單價："+booklist[id].getPrice()+"元/本");
                } else {
                    System.out.println("輸入錯誤！");
                }
            } else if (choose == 2) {
                System.out.println("請輸入您要查詢的書名： ");
                String name = scanner.next();
                int id = nameFind(name);
                if (id > -1) {
                    Book book = (Book) booklist.get(id);// (Book)booklist強制轉型
                    // System.out.println("查找成功，您查詢到的書為第"+(id+1)+"本书！"+"書名為："+booklist[id].getChineseBook()+"
                    // 作者："+booklist[id].getIsbn()+" 單價："+booklist[id].getPrice()+"元/本");
                }
            } else if (choose == 3) {
                printMenu();
                break;
            } else {
                System.out.println("輸入錯誤，請更新！");
            }
        }
    }// 查詢尋找end

    public void printAllBook() { // 循環重複打印出所有的書籍
        for (int i = 0; i < count; i++) {
            Book book = (Book) booklist.get(i);
            // System.out.println("第"+(i+1)+"本书名："+booklist[i].getChineseBook()+"
            // 作者："+booklist[i].getIsbn()+" 单价："+booklist[i].getPrice()+"元/本");
        }
    }

    public int orderFind(int number) {// 按編號查找，返回id
        // System.out.println(number);
        if (number <= count) {
            int id = number - 1;
            return id;
        } else {
            return -1;
        }
    }

    public int nameFind(String name) {// 按照書名尋找，返回id
        int id = -1;
        for (int i = 0; i < count; i++) {
            Book book = (Book) booklist.get(i);
            // if(booklist[i].getChineseBook().equals(name)){
            if (book.getChineseBook().equals(name)) {
                id = i;
                break;
            } else if (i < count) {
                continue;
            } else {
                System.out.println("尚未查詢到您想要書名! ");
                break;
            }
        }
        return id;
    }

    //
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Main startmenu = new Main();
        startmenu.borrowBook();
        Book books = new Book();

        //
        books.setNo("123");
        books.setChineseBook("java入門到放棄");
        books.setEngBook(name);
        books.setIsbn(name);
        books.setPrice(count);
        books.setBorrowRecord(null);
    }
}
