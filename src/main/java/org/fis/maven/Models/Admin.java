package org.fis.maven.Models;

public class Admin {
<<<<<<< HEAD
    private static final String username = "admin";
    private static final String password = "admin";

    public String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public String toString() {
        return "Admin{" + "username =' " + username + '\'' +
                ", password ='" + password + '\'' + "'}";
    }
}
=======
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

>>>>>>> origin/SetPriceDone
