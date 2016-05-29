package com.banixc.compilation;

import java.util.List;

import static com.banixc.compilation.Token.*;

class Tree {
    private List<Token> list;
    private Node node;

    private Tree(List<Token> list) {
        this.list = list;
//        list.stream().filter(token -> token.type == BLANK).forEach(list::remove);
//        for (Token token: list){
//
//            if(token.type == BLANK)
//                list.remove(token);
//        }
        node = getLexp(0,list.size());
    }

    Tree(String string) {
        this(Token.getTokenList(string));
    }

    Node getNode(){
        if(node!=null)
        return node;
        else
            return new ErrorNode();
    }

    @Override
    public String toString(){
        if(node==null) return "ERROR NODE";
        else return getNode().toString();
    }

    private LexpSeqNode getLexpSeq(int start, int end){
        if(start>=end) return null;
        Number number = getNumber(start,end);
        if(number!=null) {
            return new LexpSeqNode(number);
        }
        else {
            LexpNode node = getLexp(start, end);
            if(node!=null)
                return new LexpSeqNode(node);
        }
        return null;
    }

    private LexpNode getLexp(int start, int end){
        if(start>=end) return null;
        if(list.get(start).type==OPEN && list.get(end-1).type==CLOSE){
            start++;
            end--;
            Op op=getOp(start,start +1);
            if(op==null) return null;
            // 两种情况 1.首项为NUMBER 则start +1  为 number start +2 - end 为 lexp
            Number number = getNumber(start+1,start+2);
            if(number != null) {
                LexpSeqNode node = getLexpSeq(start+2,end);
                if(node == null) return null;
                return new LexpNode(op,number,node,true);
            }
            //2.首项为LexpSeq 则start +1 - end - 1 为 lexp  end - 1 - end 为 number
            LexpSeqNode node = getLexpSeq(start +1,end-1);
            if(node == null) return null;
            number = getNumber(end - 1,end);
            if(number != null) {
                return new LexpNode(op,number,node,false);
            } else {
                return null;
            }
        }
        return null;

    }

    private Number getNumber(int start, int end) {
        if(start>=end) return null;
        Token token = list.get(start);
        if(token.type!=NUMBER) return null;
        return new Number(token.number);
    }

    private Op getOp(int start,int end){
        if(start>=end) return null;
        int type = list.get(start).type;
        if(type == ADD || type == MUL || type == SUB) {
            return new Op(type);
        }
        return null;
    }

}
