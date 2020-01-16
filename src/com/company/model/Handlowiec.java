package com.company.model;

import java.math.BigDecimal;

public class Handlowiec extends Pracownik {
    private BigDecimal prowizja;
    private BigDecimal limitProwizji;

    public Handlowiec(String pesel, String imie, String nazwisko, String nrTelefonu, BigDecimal wyplata, BigDecimal prowizja, BigDecimal limitProwizji) {
        super(pesel, imie, nazwisko, nrTelefonu, wyplata);
        this.prowizja = prowizja;
        this.limitProwizji = limitProwizji;
    }
    //Pracownik temp = new Handlowiec;
    //Handlowiec temp= new Handlowiec;
    public BigDecimal getProwizja() {
        return prowizja;
    }

    public void setProwizja(BigDecimal prowizja) {
        this.prowizja = prowizja;
    }

    public BigDecimal getLimitProwizji() {
        return limitProwizji;
    }

    public void setLimitProwizji(BigDecimal limitProwizji) {
        this.limitProwizji = limitProwizji;
    }
}
