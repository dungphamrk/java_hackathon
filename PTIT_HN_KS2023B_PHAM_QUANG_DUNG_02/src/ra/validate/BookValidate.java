package ra.validate;

import java.util.Scanner;

public class BookValidate {
    public String validateStringInput(Scanner scanner, StringRule rule,String message ) {
        do{
            System.out.println(message);
            String newInput = scanner.nextLine();
            if(rule.validateStringLengthInput(newInput) && !newInput.isEmpty()) {
                return  newInput;
            }
            System.err.println("Dữ liệu đưa vào sai, vui lòng nhập lại");
        }
        while(true);
    }
    public int validateIntInput(Scanner scanner,String message ) {
        do{
            System.out.println(message);
            if(!scanner.hasNextInt()) {
                System.err.println("Dữ liệu đưa vào không phải số nguyên!Vui lòng nhập lại");
                continue;
            }
            int newInput = scanner.nextInt();
            if(newInput > 0 ){
                return  newInput;
            }
            System.err.println("Số nhập vào phải lớn hơn 0");
        }while(true);
    }

}

