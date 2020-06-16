package org.fis.maven.Exceptions;

public class UserPasswordIncorrect extends Exception{
    public UserPasswordIncorrect() {
        super("Username or Password is incorrect!");
    }
}