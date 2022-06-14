package Validate;

import Models.Product;

import java.util.List;
import java.util.Scanner;

public class Validate {
    Scanner scanner = new Scanner(System.in);
    public String validateString(String str){
        while (true) {
            System.out.println("Nhập " + str);
            String checkstr = scanner.nextLine();
            if (checkstr.equals("")) {
                System.out.println("Mời nhập " + str + " sản phẩm!!!");
                continue;
            } else {
                return checkstr;
            }
        }
    }

    public double validatePrice(){
        while (true){
            try {
                System.out.println("Nhập giá sản phẩm");
                double price = Double.parseDouble(scanner.nextLine());
                return price;
            }catch (Exception e){
                System.err.println("Nhập sai giá, nhập lại số");
            }
        }
    }

    public int validateAmount(){
        while (true){
            try {
                System.out.println("Nhập số lượng sản phẩm");
                int total = Integer.parseInt(scanner.nextLine());
                return total;
            }catch (Exception e){
                System.err.println("Nhập sai số lượng, nhập lại số ");
            }
        }
    }

}










