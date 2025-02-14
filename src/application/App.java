package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class App {
    public static void main(String[] args) throws Exception {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Product #" + (i + 1) + " data: ");

            System.out.print("Common, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            if (ch == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                sc.nextLine();
                String manufactureDate = sc.nextLine();

                // upcasting
                Product usedProduct = new UsedProduct(name, price, LocalDate.parse(manufactureDate, format));
                products.add(usedProduct);
            } else if (ch == 'i') {
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();

                // upcasting
                Product importedProduct = new ImportedProduct(name, price, customsFee);
                products.add(importedProduct);
            } else {
                Product commonProduct = new Product(name, price);
                products.add(commonProduct);
            }

            // se não caiu em nenhum dos ifs, só pode ser um product comum. assim,

        }

        System.out.println();

        for (Product product : products) {
            System.out.println(product.priceTag());
        }

        sc.close();
    }
}
