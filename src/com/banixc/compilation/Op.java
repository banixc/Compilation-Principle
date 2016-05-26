package com.banixc.compilation;


import static com.banixc.compilation.Token.*;

class Op {
    int type;
    Op(int type) {
        this.type=type;
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
}
