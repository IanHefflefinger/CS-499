package com.company;


// Now that this application has been connected to a database, it almost doesn't make sense for it to include
// inventory item objects. I will leave this here for now until I can think of a different implementation or perhaps
// for the future where having objects of this type might be necessary.

public class InventoryItem {
    // instance variables
    protected int id;
    protected String name;
    protected int price;
    protected int numStock;
    protected int maxNumStock;

    // constructor(s)
    public InventoryItem(int id, String name, int price, int numStock, int maxNumStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.numStock = numStock;
        this.maxNumStock = maxNumStock;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumStock() {
        return numStock;
    }

    public void setNumStock(int numStock) {
        this.numStock = numStock;
    }

    public int getMaxNumStock() {
        return maxNumStock;
    }

    public void setMaxNumStock(int maxNumStock) {
        this.maxNumStock = maxNumStock;
    }
}
