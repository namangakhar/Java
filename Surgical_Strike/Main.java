package com.daens;

import java.util.Scanner;
public class Main {
    public static Scanner sin=new Scanner(System.in);
    public static void main(String[] args) {
        int n,sn,qn,e;
        n=sin.nextInt();
        sn=sin.nextInt();
        qn=sin.nextInt();
        e=sin.nextInt();
	Graph ss=new Graph(n,sn,qn,e);
        int u,v;
        long w;
        for(int i=0; i<n-1; i++){
            u=sin.nextInt();
            v=sin.nextInt();
            w=sin.nextLong();
            ss.addpath(u,v,w);
        }
        for(int i=0;i<sn;i++)
            ss.addsuppleslocation(sin.nextInt());
        for(int i=0;i<qn;i++)
            ss.addirpairs(sin.nextInt(),sin.nextInt());

        sin.close();
        ss.findpaths();
    }
}
