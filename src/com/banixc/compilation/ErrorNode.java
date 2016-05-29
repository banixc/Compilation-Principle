package com.banixc.compilation;

class ErrorNode extends Node {
    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public String toString() {
        return "ERROR NODE";
    }

    @Override
    public String tree(int floor) {
        return "ERROR NODE\n";
    }
}
