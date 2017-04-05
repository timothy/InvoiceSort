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
 * https://zeroturnaround.com/rebellabs/java-8-explained-applying-lambdas-to-java-collections/
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
                e1.getPrice(), e2.getPrice());

        //Sort by Value
        Comparator<Invoice> ValueSort = (e1, e2) -> Double.compare(
                e1.getQuantity() * e1.getPrice(), e2.getQuantity() * e2.getPrice());

        //Sort by PartDescription
        Comparator<Invoice> PartDescriptionSort = (e1, e2) -> e1.getPartDescription()
                .compareTo(e2.getPartDescription());

        //Create a list of invoice objects
        List<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(new Invoice(123456, 56, 108.50, "Cars"));
        invoiceList.add(new Invoice(545555, 27, 11.50, "Boats"));
        invoiceList.add(new Invoice(777777, 15, 13.50, "Planes"));
        invoiceList.add(new Invoice(999999, 32, 115.50, "Spoons"));
        invoiceList.add(new Invoice(121212, 45, 172.50, "Bikes"));
        invoiceList.add(new Invoice(151515, 27, 2.50, "Dirt"));
        invoiceList.add(new Invoice(989898, 57, 194.50, "ARIfot"));
        invoiceList.add(new Invoice(829155, 58, 1.50, "Bats"));
        invoiceList.add(new Invoice(333333, 59, 10.50, "Shoes"));
        invoiceList.add(new Invoice(111111, 70, 129.50, "Food"));

        System.out.println("a. Sort the Invoice objects by PartDescription, then display the results.");
//        //a. Sort the Invoice objects by PartDescription, then display the results.
        invoiceList.stream().sorted(PartDescriptionSort)
                .forEach(e -> System.out.println(e));
        
        System.out.println("\n\nb. Sort the Invoice objects by Price, then display the results.");
//        //b. Sort the Invoice objects by Price, then display the results.
        invoiceList.stream().sorted(PriceSort)
                .forEach(e -> System.out.println(e));

                System.out.println("\n\nc. Map each Invoice to its PartDescription and Quantity, sort the results by Quantity, then display the results.");
        //c. Map each Invoice to its PartDescription and Quantity, sort the results by Quantity, then display the results.
        invoiceList
                .stream()
                .sorted(QuantitySort)
                .map(s -> s.getPartDescription() + s.getQuantity())
                .forEach(e -> System.out.println(e));

        System.out.println("\n\nd. Map each Invoice to its PartDescription and the value of the Invoice (i.e., Quantity * Price). Order the results by Invoice value.");
        //d. Map each Invoice to its PartDescription and the value of the Invoice (i.e., Quantity * Price). Order the results by Invoice value.
        invoiceList
                .stream()
                .sorted(ValueSort)
                .map(s -> s.getPartDescription() + (s.getQuantity() * s.getPrice()))
                .forEach(e -> System.out.println(e));

        System.out.println("\n\ne. Modify Part (d) above to select the Invoice values in the range of $200 to $500 (inclusive) and display the results separately.");
        //e. Modify Part (d) above to select the Invoice values in the range of $200 to $500 (inclusive) and display the results separately.
        invoiceList
                .stream().filter(s -> 200 < s.getQuantity() * s.getPrice() && 500 > s.getQuantity() * s.getPrice())
                .sorted(ValueSort)
                .map(s -> s.getPartDescription() + (s.getQuantity() * s.getPrice()))
                .forEach(e -> System.out.println(e));

    }
}
