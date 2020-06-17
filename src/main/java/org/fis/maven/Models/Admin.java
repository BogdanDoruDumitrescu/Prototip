package org.fis.maven.Models;

public class Admin {
    private int price;

    public Admin(int price){
        this.price = price;
    }

    public Admin(){
    }

    public int getPrice() {return price;}

    public void setPrice(int price) {this.price = price;}

    @Override
    public String toString() {
            return "Admin{" + " price=" + price + " lei" +'}';
        }
    }

