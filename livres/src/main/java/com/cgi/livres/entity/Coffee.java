package com.cgi.livres.entity;

public class Coffee {

    private int coffee_id;

    private String brand;
    private String origin;
    private String characteristics;

    public Coffee() {
    }


    public Coffee(int coffee_id, String brand, String origin, String characteristics) {
        this.coffee_id=coffee_id;
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

    public void setCoffee_id(int coffee_id) {
        this.coffee_id = coffee_id;
    }

    public int getCoffee_id() {
        return this.coffee_id;
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
