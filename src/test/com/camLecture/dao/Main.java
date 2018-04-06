package com.camLecture.dao;

import java.awt.*;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/3/29.
 */
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();

        int len=str.length();
        char[] temp=str.toCharArray();
        char[][] c=new char[len][len];

        for(int i=0;i<len;i++){
            c[i][i]=temp[len-1];
        }
        for(int i=len-2;i<=0;i--){
            temp=sc.nextLine().toCharArray();
            for(int j=0;j<len;j++){
                c[j][i]=temp[j];
            }
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                System.out.print(c[i][j]);
            }
            System.out.println();
        }

    }
}
