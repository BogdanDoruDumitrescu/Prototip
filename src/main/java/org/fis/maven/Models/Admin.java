package org.fis.maven.Models;

public class Admin {
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
