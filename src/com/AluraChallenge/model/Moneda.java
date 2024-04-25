package com.AluraChallenge.model;

import com.google.gson.annotations.SerializedName;

public class Moneda {
@SerializedName("ARS")
    private double ARS;
    @SerializedName("AUD")
    private double AUD;
    @SerializedName("USD")
    private double USD;
    @SerializedName("BRL")
    private double BRL;
    @SerializedName("CAD")
    private double CAD;


    public double getARS() {
        return ARS;
    }

    public void setARS(double ARS) {
        this.ARS = ARS;
    }

    public double getAUD() {
        return AUD;
    }

    public void setAUD(double AUD) {
        this.AUD = AUD;
    }

    public double getUSD() {
        return USD;
    }

    public void setUSD(double USD) {
        this.USD = USD;
    }

    public double getBRL() {
        return BRL;
    }

    public void setBRL(double BRL) {
        this.BRL = BRL;
    }

    public double getCAD() {
        return CAD;
    }

    public void setCAD(double CAD) {
        this.CAD = CAD;
    }
}
