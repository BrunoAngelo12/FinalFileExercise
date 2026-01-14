package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        
        System.out.println("Enter the file path: ");
        String strPath = sc.nextLine();
        
        File path = new File(strPath);

        String strLine = "";
        List<Product> listProducts = new ArrayList();
        int i = 0;
        
        try(BufferedReader br = new BufferedReader(new FileReader(strPath))){              
            
            while (strLine != null){
                strLine = br.readLine();
                String[] strResult = strLine.split(",");
                double price =Double.parseDouble(strResult[1]);
                int quantity = Integer.parseInt(strResult[2]);
                Product product = new Product(strResult[0], price, quantity);
                listProducts.add(product);
                i++;
            }
        
        }        
        catch(IOException e){
            System.out.println(e.getMessage());
        }

        boolean create = new File(strPath + "\\out").mkdir();
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(strPath+"\\out"))){
            for(Product p : listProducts){
                bw.write(p.toString());
                bw.newLine();
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }


        sc.close();
    }
}
