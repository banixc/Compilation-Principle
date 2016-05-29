package com.banixc.compilation;

abstract class Node{

    public static final String DIV = "  ";

    public abstract int getValue();
    public abstract String toString();

    public abstract String tree(int floor);

    String getDiv(int floor){
        String temp = "";
        for (int i = 0; i < floor; i++) {
            if(i==0) {
                if (floor != 1)
                    temp += "  ";
                else
                    temp += "├─";
            }
            else if(i == floor -1 )
                temp += "└─";
            else
                temp += "  ";
        }
        return temp;
    }

}
