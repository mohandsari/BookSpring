package com.cgi.livres.entity;

public class Coffee {

    private String brand;
    private String origin;
    private String characteristics;

    public Coffee() {
    }


    public Coffee(String brand, String origin, String characteristics) {
        this.brand = brand;
        this.origin = origin;
        this.characteristics = characteristics;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String getCharacteristics() {
        return this.characteristics;
    }

    // getters and setters
}
