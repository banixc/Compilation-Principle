package com.banixc.compilation;

/**
 * Created by Banixc on 2016/5/25.
 */
public class Number extends Node {

    private int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public int getValue() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(getValue());
    }

    @Override
    public String tree(int floor) {
        return "NUMBER:" + number + "\n";
    }
}
