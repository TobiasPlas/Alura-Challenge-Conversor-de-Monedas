package com.AluraChallenge.dto;

import com.AluraChallenge.model.Moneda;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public record MonedaDTO() {
    @SerializedName("conversion_rates")
    public static List<Moneda> listaMonedas;



    public Moneda getMoneda (int posicion){

        Moneda moneda=listaMonedas.get(posicion);

        return moneda;
    }

    public List<Moneda> getListaMonedas() {
        return listaMonedas;
    }

    public void setListaMonedas(List<Moneda> listaMonedas) {
        MonedaDTO.listaMonedas = listaMonedas;
    }
}
