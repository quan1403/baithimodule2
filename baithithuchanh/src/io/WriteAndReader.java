package io;

import Models.Product;

import java.io.*;
import java.util.ArrayList;

public class WriteAndReader {
    File file = new File("C:\\Users\\ADMIN\\Desktop\\baithimodule2\\baithithuchanh\\src\\models\\Product.csv");

    public void write(ArrayList<Product> arr) {

        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Product p : arr) {
                bufferedWriter.write(p.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();

        } catch (FileNotFoundException e) {
            System.out.println("");
        } catch (IOException e) {
            System.out.println("");
        }
    }

    public ArrayList<Product> Reader() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while (str !=null){
                String[] arr = str.split(",");
                String id = arr[0];
                String name = arr[1];
                double price = Double.parseDouble(arr[2]);
                int amount = Integer.parseInt(arr[3]);
                String describe = arr[4];
                products.add(new Product(id,name,price,amount,describe));
                str = bufferedReader.readLine();

            }
            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException ex) {
            System.out.println("");;
        } catch (IOException ex) {
            System.out.println("");
        }
        return products;
    }
}
