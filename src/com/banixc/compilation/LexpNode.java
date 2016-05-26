package com.banixc.compilation;


import static com.banixc.compilation.Token.*;

public class LexpNode extends Node {

    private Op op;
    private Number number;
    private LexpSeqNode lexpSeqNode;
    private boolean isNumberBefore;

    public LexpNode(Op op, Number number, LexpSeqNode lexpSeqNode,boolean isNumberBefore) {
        this.op = op;
        this.number = number;
        this.lexpSeqNode = lexpSeqNode;
        this.isNumberBefore = isNumberBefore;
    }

    @Override
    public int getValue() {
        switch (op.type){
            case ADD:
                return number.getValue() + lexpSeqNode.getValue();
            case SUB:
                return (isNumberBefore?1:-1) * (number.getValue() - lexpSeqNode.getValue());
            case MUL:
                return number.getValue() * lexpSeqNode.getValue();
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        if(number!=null && op != null && lexpSeqNode != null)
        return String.valueOf(getValue());
        else
            return "ERROR";
    }

    @Override
    public String tree(int floor) {
        String all = toString()+"\n";
        String temp = "";
        for (int i = 0; i < floor; i++) {
//            if(i==floor-1)
//                temp += "├-";
//            else
//                temp += "| ";
            temp += "  ";
        }
        if(isNumberBefore){
            all += number.tree(floor+1);
            all += temp + op.toString() + "\n";
            all += temp + lexpSeqNode.tree(floor+1);
        } else {
            all += temp + lexpSeqNode.tree(floor+1);
            all += temp + op.toString() + "\n";
            all += temp + number.tree(floor+1);
        }
        return all;
    }


}
