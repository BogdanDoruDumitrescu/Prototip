package org.fis.maven.Models;

public class Admin {
    private static final String username = "admin";
    private static final String password = "admin";
    private int price;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPrice(){return price;}
    public Admin(int price){this.price = price;}

    public String toString() {
        return "Admin{" + "username =' " + username + '\'' +
                ", password ='" + password + '\'' + ", price = " + price + "'}";
    }
}

