package com.banixc.compilation;


import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final String encoding = "UTF-8";


    private static String readFile(String filePath){
        try {
            File file=new File(filePath);
            if(file.isFile() && file.exists()){
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String allTxt = "";
                String lineTxt;
                while((lineTxt = bufferedReader.readLine()) != null){
                    allTxt+=lineTxt+"\n";
                }
                read.close();
                return allTxt;
            }
        } catch (Exception e) {
            System.out.println("Read error!");
            e.printStackTrace();
        }
        return null;

    }

    private static boolean writeFile(String fileName, String content) {
        try {
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fileName),encoding);
            out.write(content);
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }



    public static void main(String[] args) {


        if(args.length>0) {
            for (String fileName : args) {
                String content = readFile(fileName);
                if (content != null) {
                    String write = "";
                    StringTokenizer stringTokenizer = new StringTokenizer(content, "\n");

                    while (stringTokenizer.hasMoreTokens()) {
                        String lexp = stringTokenizer.nextToken();
                        Tree tree = new Tree(lexp);
                        write += lexp + "\n" +
                                tree.getNode().tree(0) + "\n";
                    }
                    boolean flags = writeFile(fileName + ".out", write);
                    System.out.println(fileName + " Convert " + (flags ? "success!" : "failed!"));
                } else {
                    System.out.println(fileName + " Not find!");
                }
            }
        } else {
            System.out.println("Usage: FileName1 FileName2 FileName3");
        }


//        Tree tree = new Tree(a);
//        System.out.print(tree.getNode().getValue());
    }
}
