package com.example.assignment3;

public class clculator {

    private float fn;
    private float sn;

    public void setFn(float fn) {
        this.fn = fn;
    }

    public void setSn(float sn) {
        this.sn = sn;
    }

    public float Add() {
        return fn + sn;
    }

    public float sub() {
        return fn - sn;
    }

    public float mult() {
        return fn * sn;
    }

    public float div() {
        return fn / sn;
    }
}
