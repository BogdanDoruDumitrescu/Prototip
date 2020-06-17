package org.fis.maven.Models;

public class Admin {
    private String username;
    private String password;
    private int price;

    public Admin(String username, String password, int price) {
        this.username = username;
        this.password = password;
        this.price = price;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username){ this.username =username; }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password){this.password = password;}

    public int getPrice() { return price; }
    public void setPrice(){this.price = price;}

    public String toString() {
        return "Admin{" + "username =' " + username + '\'' +
                ", password ='" + password + '\'' + ", price = " + price + "'}";
    }
}

