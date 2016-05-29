package com.banixc.compilation;


import static com.banixc.compilation.Token.*;

class LexpNode extends Node {

    private static final String TAG = "LexpNode";

    private Op op;
    private Number number;
    private LexpSeqNode lexpSeqNode;
    private boolean isNumberBefore;

    LexpNode(Op op, Number number, LexpSeqNode lexpSeqNode, boolean isNumberBefore) {
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
        return TAG+"("+String.valueOf(getValue())+")";
        else
            return "ERROR";
    }

    @Override
    public String tree(int floor) {
        String div = getDiv(floor);
        String all = div + toString()+"\n";

        if(isNumberBefore){
            all += number.tree(floor+1);
            all += op.tree(floor+1);
            all += lexpSeqNode.tree(floor+1);
        } else {
            all += lexpSeqNode.tree(floor+1);
            all += op.tree(floor+1);
            all += number.tree(floor+1);
        }
        return all;
    }


}
