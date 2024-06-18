package com.example.happytraveler.ui.slideshow;

import java.util.Date;

public class Ekdromh {

    private String taxidiotikoGrafeio;
    private String country;
    private String date;
    private int price;

    public Ekdromh(String taxidiotikoGrafeio, String country, String date, Integer price) {
        this.taxidiotikoGrafeio = taxidiotikoGrafeio;
        this.country = country;
        this.date = date;
        this.price = price;
    }

    public String getTaxidiotikoGrafeio() {
        return taxidiotikoGrafeio;
    }

    public void setTaxidiotikoGrafeio(String taxidiotikoGrafeio) {
        this.taxidiotikoGrafeio = taxidiotikoGrafeio;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.country = country;

    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}