package com.banixc.compilation;

class Number extends Node {

    private static final String TAG = "Number";

    private int number;

    Number(int number) {
        this.number = number;
    }

    @Override
    public int getValue() {
        return number;
    }

    @Override
    public String toString() {
        return TAG+"("+ String.valueOf(getValue()) + ")";
    }

    @Override
    public String tree(int floor) {
        return getDiv(floor) + "Number(" + number + ")\n";
    }
}
