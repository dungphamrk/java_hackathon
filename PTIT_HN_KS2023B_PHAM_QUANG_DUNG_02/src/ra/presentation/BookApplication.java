package ra.presentation;

import ra.bussiness.BookBusiness;
import ra.entity.Book;

import java.util.Scanner;

public class BookApplication {
    public static final int MAX_SIZE=100;
    public static int bookCount=0;
    public static Book[] arrBook=new  Book[MAX_SIZE];
    public static void main(String[] args) {
    }
    public static void bookMenu(){
        System.out.println("----------------------------Book Menu----------------------------");
        System.out.println("1. Hiển thị danh sách các cuốn sách");
        System.out.println("2. Thêm mới sách");
        System.out.println("3. Chỉnh sửa thông tin sách");
        System.out.println("4. Xóa sách");
        System.out.println("5. Tìm kiếm sách");
        System.out.println("6. Sắp xếp ");
        System.out.println("0. Thoát chương trình");
        System.out.println(" ------------------------------------------------------------------------");
        int choice ;
        Scanner scanner =new  Scanner(System.in);
        do{
            choice  = scanner.nextInt();
            switch  (choice){
                case 1:
                    BookBusiness.renderBookInfo();
                case 2:
                    BookBusiness.addBook(scanner);
                case 3:
                    BookBusiness.editBookById(scanner);
                case 4:
                    BookBusiness.deleteBook(scanner);
                case 5:
                    BookBusiness.findBook(scanner);
                case 6:
                    BookBusiness.sortBook(scanner);
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng nhập đúng từ 0 đên 6");
            }
        }while(true);
    }
}
