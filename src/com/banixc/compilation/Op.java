package com.banixc.compilation;


import static com.banixc.compilation.Token.*;

class Op extends Node{
    int type;
    Op(int type) {
        this.type=type;
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public String toString() {
        switch (type){
            case ADD:
                return "+";
            case SUB:
                return "-";
            case MUL:
                return "*";
        }
        return "";
    }

    @Override
    public String tree(int floor) {
        return getDiv(floor) + "OP(" + toString() + ")\n";
    }


}
