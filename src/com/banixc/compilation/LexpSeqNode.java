package com.banixc.compilation;

class LexpSeqNode extends Node{
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
        return String.valueOf(getValue());
    }

    @Override
    public String tree(int floor) {

        return node.tree(floor);

    }
}
