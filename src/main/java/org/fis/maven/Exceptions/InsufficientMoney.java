package org.fis.maven.Exceptions;

public class InsufficientMoney extends Exception {
    public InsufficientMoney() {
        super("Not enough money!");
    }
}