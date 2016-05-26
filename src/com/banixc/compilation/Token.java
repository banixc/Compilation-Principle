package com.banixc.compilation;

import java.util.LinkedList;
import java.util.List;


public class Token {

    public static final int NUMBER = 1;
    public static final int OPEN = 2;
    public static final int CLOSE = 3;
    public static final int ADD = 4;
    public static final int SUB = 5;
    public static final int MUL = 6;
    public static final int BLANK = 7;

    public int type;
    public int number;

    public Token(int type){
        this.type = type;
    }

    public Token(int type,int number){
        this.type = type;
        this.number = number;
    }

    public static List<Token> getTokenList(String string){
        //保存临时数
        int temp=0;
        //确认缓存里是否存在数
        boolean flag=false;
        List<Token> list = new LinkedList<>();
        char[] chars = string.toCharArray();
        for(int i = 0; i < chars.length; i++)
        {
            switch (chars[i]){
                case '+':
                    list.add(new Token(ADD));
                    break;
                case '-':
                    list.add(new Token(SUB));
                    break;
                case '*':
                    list.add(new Token(MUL));
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    flag=true;
                    temp = temp*10+chars[i]-'0';
                    break;
                case ' ':
//                    list.add(new Token(BLANK));
                    break;
                case '(':
                    list.add(new Token(OPEN));
                    break;
                case ')':
                    list.add(new Token(CLOSE));
                    break;
            }
            if(flag && i+1 < chars.length && (chars[i+1] > '9' || chars[i+1] < '0') ){
                list.add(new Token(NUMBER,temp));
                temp=0;
                flag=false;
            }
        }
        return list;
    }



    @Override
    public String toString(){
        switch (type){
            case OPEN:
                return "(";
            case CLOSE:
                return ")";
            case ADD:
                return "+";
            case SUB:
                return "-";
            case MUL:
                return "*";
            case NUMBER:
                return String.valueOf(number);
            case BLANK:
                return " ";
            default:
                return "";
        }
    }

}
