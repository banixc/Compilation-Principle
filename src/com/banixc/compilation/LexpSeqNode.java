package com.banixc.compilation;

class LexpSeqNode extends Node{
    private static final String TAG = "LexpSeqNode";

    private Node node;

    LexpSeqNode(Number number){
        node = number;
    }

    LexpSeqNode(LexpNode lexpNode){
        node = lexpNode;
    }

    @Override
    public int getValue() {
        return node.getValue();
    }

    @Override
    public String toString() {
        return TAG+"("+ String.valueOf(getValue()) + ")";
    }

    @Override
    public String tree(int floor) {

        return getDiv(floor) + toString() + "\n" + node.tree(floor+1);

    }
}
