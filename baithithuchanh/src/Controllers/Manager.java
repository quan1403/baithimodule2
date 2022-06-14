package Controllers;

import Models.Product;
import Models.SortGiamDan;
import Models.SortTangDan;
import Validate.Validate;
import io.WriteAndReader;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    WriteAndReader writeAndReader = new WriteAndReader();
    Validate validate = new Validate();
    ArrayList<Product> arr = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public void Menu() {
        System.out.println("Menu");
        System.out.println("1.Xem danh sách");
        System.out.println("2.Thêm mới");
        System.out.println("3.Cập nhật");
        System.out.println("4.Xóa");
        System.out.println("5.Sắp xếp");
        System.out.println("6.Sản phẩm đắt giá nhất");
        System.out.println("7.Đọc từ file");
        System.out.println("8.Ghi vào file");
        System.out.println("9.Thoát");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                Show();
                break;
            case 2:
                Add();
                break;
            case 3:
                Edit();
                break;
            case 4:
                Deleted();
                break;
            case 5:
                Sort();
                break;
            case 6:
                Max();
                break;

            case 7:
                arr = writeAndReader.Reader();
                Show();
                break;
            case 8:
                writeAndReader.write(arr);
                break;
            case 9:
                System.exit(0);
        }
    }

    public void Show() {
        for (Product p : arr) {
            System.out.println(p);

        }
    }

    public Product Creat() {
        String id ;
        String name ;
        double price ;
        int amount ;
        String describe ;
        while (true) {
            try {
                id = validate.validateString("Nhập mã sản phẩm");
                name = validate.validateString("tên sản phẩm");
                price = validate.validatePrice();
                amount = validate.validateAmount();
                System.out.println("Nhập mô tả:");
                describe = sc.nextLine();
                return new Product(id, name, price, amount, describe);
            } catch (NumberFormatException e) {
                System.out.println("lỗi rồi nhập lại đi");
                ;
            }
        }

    }

    public void Add() {
        arr.add(Creat());

    }

    public void Edit() {
        System.out.println("Nhập mã sản phẩm cần sửa:");
        int id = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getId().equals(id)) {
                arr.set(i, Creat());
            } else {
                System.out.println("id ko ton tai");
                sc.next();
                Menu();
            }


        }
    }

    public void Deleted() {
        System.out.println("Nhập mã sản phẩm cần xóa:");
        int id = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getId().equals(id)) {
                System.out.println("nhan y de xoa:");
                String a = sc.nextLine();
                if (a.equals("y")) {
                    arr.remove(i);
                }

            }else break;

        }
    }


    public void Sort(){
        System.out.println("1.Sắp xếp theo giá tăng dần:");
        System.out.println("2.Sắp xếp theo giá giảm dần:");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice){
            case 1:
                arr.sort(new SortTangDan());
                break;
            case 2:
                arr.sort(new SortGiamDan());
                break;
        }

    }
    public void Max(){
        double max = arr.get(0).getPrice();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getPrice()>max){
                max = arr.get(i).getPrice();

            }

        }
        System.out.println(max);



    }

}
