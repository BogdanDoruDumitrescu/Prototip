package org.fis.maven.Models;

import java.util.Objects;

public class Race {
    private String driverUserName;
    private String clientUserName;
    private int pricePerKm;
    private int km;
    private int totalPrice;

    public Race( String driverUserName, String clientUserName, int pricePerKm,int km, int totalPrice) {
        this.pricePerKm = pricePerKm;
        this.totalPrice = totalPrice;
        this.km = km;
        this.driverUserName = driverUserName;
        this.clientUserName = clientUserName;
    }

    public String getDriverUserName() {
        return driverUserName;
    }

    public void setDriverUserName(String driverUserName) {
        this.driverUserName = driverUserName;
    }

    public String getClientUserName() {
        return clientUserName;
    }

    public void setClientUserName(String clientUserName) {
        this.clientUserName = clientUserName;
    }

    public int getPricePerKm() {
        return pricePerKm;
    }

    public void setPricePerKm(int pricePerKm) {
        this.pricePerKm = pricePerKm;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice() {
        this.totalPrice = km * pricePerKm;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return pricePerKm == race.pricePerKm &&
                totalPrice == race.totalPrice &&
                km == race.km &&
                driverUserName.equals(race.driverUserName) &&
                clientUserName.equals(race.clientUserName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pricePerKm, totalPrice, km, driverUserName, clientUserName);
    }

    @Override
    public String toString() {
        return "Race{" +
                "driverUserName='" + driverUserName + '\'' +
                ", clientUserName='" + clientUserName + '\'' +
                ", pricePerKm=" + pricePerKm +
                ", totalPrice=" + totalPrice +
                ", km=" + km +
                '}';
    }
}
