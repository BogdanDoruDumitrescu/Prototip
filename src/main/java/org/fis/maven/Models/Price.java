package org.fis.maven.Models;

public class Price {
    private int price;

    public Price(int price){
        this.price=price;
    }

    public Price(){
    }

    public void setPrice(int price) { this.price=price;}

    public int getPrice() {return price;}

    @Override
    public String toString() {
        return "Admin{" + " price=" + price + '}';
    }
}

