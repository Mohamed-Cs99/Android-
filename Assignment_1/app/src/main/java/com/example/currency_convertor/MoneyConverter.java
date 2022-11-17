package com.example.currency_convertor;

public class MoneyConverter {

    private float m ;

    public float getM() {
        return m;
    }

    public void setM(float m) {
        this.m = m;
    }

    public float convert_to_dollar()
    {
        return  m /18 ;
    }
    public  float convert_to_Egyptian()
    {
        return m*18 ;
    }

}
