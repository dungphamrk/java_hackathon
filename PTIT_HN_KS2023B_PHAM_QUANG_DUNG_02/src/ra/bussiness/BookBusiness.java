package ra.bussiness;

import ra.entity.Book;
import ra.presentation.BookApplication;

import java.util.Scanner;

public class BookBusiness {
    public static void renderBookInfo(){
        if(BookApplication.bookCount==0){
            System.out.println("Danh sách trống");
            return;
        }
        for (int i = 0; i < BookApplication.bookCount; i++) {
            BookApplication.arrBook[i].displayData();
        }
    }
    public static void addBook(Scanner scanner){
        if(BookApplication.bookCount==BookApplication.MAX_SIZE){
            System.out.println("Danh sách đã đầy không thể thêm mới nữa");
            return;
        }
        System.out.println("Nhập số lượng sách muốn thêm mới: ");
        int numberNewBook = scanner.nextInt();
        for (int i = 0; i < numberNewBook; i++) {
            BookApplication.arrBook[BookApplication.bookCount++].inputData(scanner);
        }
        System.out.println("Thêm mới sách thành công");
    }
    public static void editBookById(Scanner  scanner){
        System.out.println("Nhập mã sách cần sửa");
        String findId = scanner.nextLine();
        boolean isFinded=false;
        for (int i = 0; i < BookApplication.bookCount; i++) {
            if(findId == BookApplication.arrBook[i].getBookId()){
                BookApplication.arrBook[i].displayData();
                editMenu(scanner,BookApplication.arrBook[i]);
                isFinded=true;
                break;
            }
        }
        if(!isFinded){
            System.out.println("Không tìm thấy sách");
        }
    }
    private static void editMenu(Scanner scanner, Book book){
        do{
            System.out.println("Vui lòng chọn thuộc tính cần sửa: ");
            System.out.println("1.Mã sách");
            System.out.println("2.Tiêu đề sách");
            System.out.println("3.Tên tác giả");
            System.out.println("4.Nhà xuất bản");
            System.out.println("5.Năm xuất bản");
            System.out.println("6.Thể loại sách");
            System.out.println("7.Giá sách");
            System.out.println("8.Số lượng sách");
            System.out.println("9.Quay lại menu chính");
            System.out.print("Nhập lựa chọn của bạn tại đây: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập mã sách cần mới");
                    book.setBookId(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Nhập tiêu đề sách mới");
                    book.setBookTitle(scanner.nextLine());
                    break;

                case 3:
                    System.out.println("Nhập tên tác giả mới");
                    book.setAuthor(scanner.nextLine());
                    break;

                case 4:
                    System.out.println("Nhập nhà xuất bản mới");
                    book.setPublisher(scanner.nextLine());
                    break;

                case 6:
                    System.out.println("Nhập thể loại sách");
                    book.setCategory(scanner.nextLine());
                    break;

                case 7:
                    System.out.println("Nhập giá sách mới");
                    book.setPrice(scanner.nextDouble());
                    break;

                case 8:
                    System.out.println("Nhập số lượng sách mới");
                    book.setQuantity(scanner.nextInt());
                    break;

                case 5:
                    System.out.println("Nhập năm xuất bản mới");
                    book.setPublicationYear(scanner.nextInt());
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Vui lòng nhập lại ");
                    break;
            }
        }while(true);
    }
    public static void deleteBook(Scanner scanner){
        System.out.println("Nhập mã sách cần xóa");
        String findId = scanner.nextLine();
        int findedCount=0;
        boolean isFinded=false;
        for (int i = 0; i < BookApplication.bookCount; i++) {
            if(findId == BookApplication.arrBook[i].getBookId()){
                BookApplication.arrBook[i].displayData();
                findedCount=i;
                isFinded=true;
                break;
            }
        }
        if(!isFinded){
            System.out.println("Không tìm thấy sách");
            return;
        }
        System.out.println("Bạn có thật sự muốn xóa cuốn sách đó không?");
        System.out.println("1.Có");
        System.out.println("2.Không");
        int choice = scanner.nextInt();
        if(choice==1){
            for (int i = findedCount; i <BookApplication.bookCount ; i++) {
                BookApplication.arrBook[i]=BookApplication.arrBook[i+1];
            }
        }
    }
    public  static void findBook(Scanner scanner){
        do{
            System.out.println("1.Tìm theo tiêu đề sách");
            System.out.println("2.Tìm theo thể loại sách");
            System.out.println("3.Tìm theo khoảng giá");
            System.out.println("4.Trở về menu chính");
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            if(choice ==1){
                System.out.println("Nhập tiêu đề sách: ");
                String findBookTitle = scanner.nextLine();
                for (int i = 0; i < BookApplication.bookCount; i++) {
                    if(BookApplication.arrBook[i].getBookTitle().equals(findBookTitle)){
                        BookApplication.arrBook[i].displayData();
                    }
                }
            }
            if(choice == 2){
                System.out.println("Nhập thể loại sách: ");
                String findCategoryBook = scanner.nextLine();
                for (int i = 0; i < BookApplication.bookCount; i++) {
                    if(BookApplication.arrBook[i].getCategory().equals(findCategoryBook)){
                        BookApplication.arrBook[i].displayData();
                    }
                }
            }
            if(choice == 3){
                System.out.println("Nhập khoảng giá thấp nhất: ");
                double minPrice =scanner.nextDouble();
                System.out.println("Nhập khoảng giá cao nhất: ");
                double maxPrice=scanner.nextDouble();
                for (int i = 0; i < BookApplication.bookCount; i++) {
                    if(BookApplication.arrBook[i].getPrice()>=minPrice&&BookApplication.arrBook[i].getPrice()<=maxPrice){
                        BookApplication.arrBook[i].displayData();
                    }
                }
            }
            if(choice == 4){
                return;
            }
            System.out.println("Vui lòng nhập số từ 1 đến 4");
        }while(true);
    }
    public static void sortBook(Scanner scanner){
        do{
            System.out.println("1.Sắp xếp theo tiêu đề tăng dần/ giảm dần");
            System.out.println("2.Sắp xếp theo giá tăng , giảm dần");
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice  = scanner.nextInt();
            switch (choice){
                case 1:

                    break;
                case 2:

                    break;
                default:
                    System.out.println("Vui lòng chọn từ 1 đến 2 , nhập lại");
                    break;
            }
        }while(true);
    }
}
