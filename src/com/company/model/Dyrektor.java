package com.company.model;

import java.math.BigDecimal;

public class Dyrektor extends Pracownik {
    private BigDecimal dodatek;
    private String karta;
    private BigDecimal limit;


    public Dyrektor(String pesel, String imie, String nazwisko, String nrTelefonu, BigDecimal wyplata,BigDecimal dodatek, String karta, BigDecimal limit) {
        super(pesel,imie,nazwisko,nrTelefonu,wyplata);
        this.dodatek = dodatek;
        this.karta = karta;
        this.limit = limit;
    }

    public BigDecimal getDodatek() {
        return dodatek;
    }

    public void setDodatek(BigDecimal dodatek) {
        this.dodatek = dodatek;
    }

    public String getKarta() {
        return karta;
    }

    public void setKarta(String karta) {
        this.karta = karta;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
