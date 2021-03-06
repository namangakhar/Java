package com.daens;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private class pairs {
        public int u, v;
        public long w=0L;

        public pairs(int u, int v, long w) {
            set(u,v,w);
        }

        public void set(int x, int y, long z) {
            u = x;
            v = y;
            w = z;
        }
    }

    private int nBunkers, nQueries, nsuppliesbunkers, exit,e;
    private Long wt=0L;
    private ArrayList<pairs> paths = new ArrayList<pairs>();
    private ArrayList<Integer> supplies = new ArrayList<Integer>();
    private ArrayList<Integer> blocked=new ArrayList<>();
    private pairs y;
    private ArrayList<pairs> irs=new ArrayList<>();
    public Graph(int nBunkers, int nQueries, int nsuppliesbunkers, int exit) {
        this.nBunkers = nBunkers;
        this.nQueries = nQueries;
        this.nsuppliesbunkers = nsuppliesbunkers;
        this.exit = exit;
        iterators=new ArrayList<>(nBunkers);
    }
    public void showiterators(){
        System.out.println(iterators);
    }

    public boolean addpath(int u, int v, long w) {
        paths.add(new pairs(u,v,w));
        paths.add(new pairs(v,u,w));
        return true;
    }

    public void addsuppleslocation(int s)
    {
        supplies.add(s);
    }
    public void addirpairs(int i, int r){irs.add(new pairs(i,r,0));}

    public void showpaths() {
        for (pairs i : paths)
            System.out.println(i + "th path =  " + (int) (i.u) + " to " + i.v + " distance " + i.w);
    }

    public void findpaths(){
        for (pairs x:irs) {
            System.out.println(findpath(x.u,x.v));
            //showpaths();
        }
    }
    private String findpath(int I, int r) {
        I--;
        blocked.clear();
        y = new pairs(0, 0, 0);
        pairs x = paths.get(2 * (I));
        y.u = x.u;
        y.v = x.v;
        y.w = x.w;
        paths.get(2 * (I)).set(0, 0, 0);
        paths.get(2 * (I) + 1).set(0, 0, 0);

        if(findp(I,r)==-1)
        {paths.set(2*(I), y);
            x=y;
            x=new pairs(0,0,0);
            x.v = y.u;
            x.u = y.v;
            x.w = y.w;
            paths.set((2*(I))+1, x);
            return "escaped";}
  //      System.out.println("exit looking finished");
        for (int i:supplies) {
            blocked.clear();
            e = i;
            if(supplies.contains(r)){
                paths.set(2*(I), y);
                x=new pairs(0,0,0);
                x.v = y.u;
                x.u = y.v;
                x.w = y.w;
                paths.set((2*(I))+1, x);
                return Long.toString(0);}

            long w=findsupplies(I, r);
            if ( w>0) {
                paths.set(2*(I), y);
                    x=new pairs(0,0,0);
                    x.v = y.u;
                    x.u = y.v;
                    x.w = y.w;
                    paths.set((2*(I))+1, x);
                    return Long.toString(wt);}
        }
        paths.set(2*(I), y);
        x=new pairs(0,0,0);
        x.v = y.u;
        x.u = y.v;
        x.w = y.w;
        paths.set((2*(I))+1, x);
        return "oo";
    }




    private int findp(int I , int r) {
//       System.out.println("hellow new");
        for (pairs i : paths) {
 //           System.out.println(i.u + " " + i.v);
            if (i.u == r && i.v == exit) {
   //             System.out.println("Entered exit");
                return -1;
            }
        }
     //   System.out.println("here");
        for (pairs i : paths) {
       //     System.out.println(i.u + "ran" + i.v);
            if (i.u == r && !(blocked.contains(i.v))) {
         //       System.out.println("in findp u=" + i.u + " ,v " + i.v);
                blocked.add(r);
                if (findp(I, i.v) == -1) {
                    return -1;
                }
            }
        }
        return 0;
    }




        private long findsupplies(int I,int r){
 //           System.out.println("insupplies");
            for (pairs i : paths) {
//            System.out.println(i.u + " " + i.v);
                if (i.u == r && i.v == e) {
//                System.out.println("Entered exit");
                    wt=i.w;
                    return wt;
                }
            }
    //          System.out.println("here");
            for (pairs i : paths) {
  //          System.out.println(i.u + "ran" + i.v);
                if (i.u == r && !(blocked.contains(i.v))) {
 //               System.out.println("in findp u=" + i.u + " ,v " + i.v);
                    blocked.add(r);
                    if (findsupplies(I, i.v)>0) {
                        wt=wt+i.w;
                        return wt;
                    }
                }
            }
//            System.out.println("outta"+r);
        return 00;
    }
}
