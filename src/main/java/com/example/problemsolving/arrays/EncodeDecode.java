package com.example.problemsolving.arrays;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {
    public static void main(String[] args) {
        EncodeDecode test = new EncodeDecode();
        test.encode(List.of(new String[]{"neet","code","love","you"}));
        test.encode(List.of(new String[]{"we","say",":","yes","!@#$%^&*()"}));
        test.decode("4#neet4#code4#love3#you");
        //test.decode("2we3say1:3yes10!@#$%^&*()");
    }

    public String encode(List<String> strs) {

        String enc = "";
        for (int i = 0; i < strs.size(); i++) {
            String s = strs.get(i);
            enc = enc + s.length() +"#"+ s;
        }
        System.out.println(enc);
        return enc;
    }

    public List<String> decode(String str) {
        List<String> dec = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            String s = "";
            //len : count lenght integer
            String len ="";
            if(str.charAt(i+1)== '#'){
                len=len+str.charAt(i);
                i++;
            }
            else{
                while(str.charAt(i+1)!= '#'){
                    len = len + str.charAt(i+1);
                    i++;
                }
            }
            System.out.println("len: " + len);

            int length =0;
            int b =len.length();
            System.out.println("b: " + b);
            for (int l =0;l<len.length() ;l++){
                length = length *10;
                length = length+Integer.parseInt(String.valueOf(len.charAt(l)));

            }
            System.out.println("length "+length);
            for (int j=1; j<=length ;j++){
                s=s+str.charAt(i+j);

            }
            dec.add(s);
            i=i+length+1;
        }
        System.out.println(dec);
        return dec;
    }
}
