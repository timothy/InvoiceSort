/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicesort;

/**
 *
 * @author tim
 */
public class Invoice {

    private Integer PartNumber;
    private Integer Quantity;
    private Double Price;
    private String PartDescription;

    public Invoice(int PartNumber, int Quantity, double Price, String PartDescription) {
        this.PartDescription = PartDescription;
        this.PartNumber = PartNumber;
        this.Quantity = Quantity;
        this.Price = Price;
    }

    @Override
    public String toString() {
        return "PartNumber:" + this.PartNumber + "\n"
                + "Quantity:" + this.Quantity + "\n"
                + "Price:" + this.Price + "\n"
                + "PartDescription:" + this.PartDescription + "\n";
    }

    public Integer getPartNumber() {
        return PartNumber;
    }

    public void setPartNumber(Integer PartNumber) {
        this.PartNumber = PartNumber;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double Price) {
        this.Price = Price;
    }

    public String getPartDescription() {
        return PartDescription;
    }

    public void setPartDescription(String PartDescription) {
        this.PartDescription = PartDescription;
    }
}
