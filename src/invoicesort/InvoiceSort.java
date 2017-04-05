/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicesort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.leveluplunch.com/java/tutorials/007-sort-arraylist-stream-of-objects-in-java8/
 *
 * @author tim
 */
public class InvoiceSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * Create Comparator lambda functions to sort with.
         */
        //Sort by PartNumber
        Comparator<Invoice> PartNumberSort = (e1, e2) -> Integer.compare(
                e1.getPartNumber(), e2.getPartNumber());

        //Sort by Quantity
        Comparator<Invoice> QuantitySort = (e1, e2) -> Integer.compare(
                e1.getQuantity(), e2.getQuantity());

        //Sort by Price
        Comparator<Invoice> PriceSort = (e1, e2) -> Double.compare(
                e1.getQuantity(), e2.getQuantity());

        //Sort by PartDescription
        Comparator<Invoice> PartDescriptionSort = (e1, e2) -> e1.getPartDescription()
                .compareTo(e2.getPartDescription());

        //Create a list of invoice objects
        List<Invoice> invoice = new ArrayList<>();
        invoice.add(new Invoice(123456, 56, 108.50, "Cars"));
        invoice.add(new Invoice(545555, 27, 109.50, "Boats"));
        invoice.add(new Invoice(777777, 15, 120.50, "Planes"));
        invoice.add(new Invoice(999999, 32, 115.50, "Spoons"));
        invoice.add(new Invoice(121212, 45, 172.50, "Bikes"));
        invoice.add(new Invoice(151515, 27, 135.50, "Dirt"));
        invoice.add(new Invoice(989898, 57, 194.50, "ARIfot"));
        invoice.add(new Invoice(829155, 58, 258.50, "Bats"));
        invoice.add(new Invoice(333333, 59, 137.50, "Shoes"));
        invoice.add(new Invoice(111111, 70, 129.50, "Food"));

        //Sort by PartNumber using a comparitor function
        invoice.stream().sorted(PartNumberSort)
                .forEach(e -> System.out.println(e));

        //Sort by Quantity using a comparitor function
        invoice.stream().sorted(QuantitySort)
                .forEach(e -> System.out.println(e));

        //Sort by Price using a comparitor function
        invoice.stream().sorted(PriceSort)
                .forEach(e -> System.out.println(e));

        //Sort by PartDescription using a comparitor function
        invoice.stream().sorted(PartDescriptionSort)
                .forEach(e -> System.out.println(e));

        //Sort by PartDescription without using a comparitor
//        invoice.stream().sorted((e1, e2) -> e1.getPartDescription()
//                    .compareTo(e2.getPartDescription()))
//            .forEach(e -> System.out.println(e));
    }
}
