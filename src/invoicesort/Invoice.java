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

    /**
     * 
     * @param PartNumber The part number
     * @param Quantity The quantity of the order
     * @param Price The price of each unit
     * @param PartDescription the description of each item
     */
    public Invoice(int PartNumber, int Quantity, double Price, String PartDescription) {
        this.PartDescription = PartDescription;
        this.PartNumber = PartNumber;
        this.Quantity = Quantity;
        this.Price = Price;
    }

    /**
     * 
     * @return a formatted string of all variables
     */
    @Override
    public String toString() {
        return "PartNumber:" + this.PartNumber + "\n"
                + "Quantity:" + this.Quantity + "\n"
                + "Price:" + this.Price + "\n"
                + "PartDescription:" + this.PartDescription + "\n";
    }

    /**
     * 
     * @return The part number
     */
    public Integer getPartNumber() {
        return PartNumber;
    }

    /**
     * 
     * @param PartNumber The part number
     */
    public void setPartNumber(Integer PartNumber) {
        this.PartNumber = PartNumber;
    }

    /**
     * 
     * @return The quantity of the order
     */
    public Integer getQuantity() {
        return Quantity;
    }

    /**
     * 
     * @param Quantity The quantity of the order
     */
    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    /**
     * 
     * @return The price of each unit
     */
    public Double getPrice() {
        return Price;
    }

    /**
     * 
     * @param Price The price of each unit
     */
    public void setPrice(Double Price) {
        this.Price = Price;
    }

    /**
     * 
     * @return the description of each item 
     */
    public String getPartDescription() {
        return PartDescription;
    }

    /**
     * 
     * @param PartDescription the description of each item
     */
    public void setPartDescription(String PartDescription) {
        this.PartDescription = PartDescription;
    }
}
