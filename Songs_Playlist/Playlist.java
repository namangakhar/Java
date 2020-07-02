package Theepicuremale;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
public class Playlist {
    private LinkedList<Song> playlist=new LinkedList<Song>();
    private ArrayList<Albumn> albumns=new ArrayList<Albumn>();
    private String listname;
    public ListIterator<Song> i;
    boolean forward=true;

    public Playlist(String playlistname)
    {
        this.listname = playlistname;
        i= playlist.listIterator();
    }

    public void addalbumn(String albumn)
    {
        if(checkalbumn(albumn)<0)
        {
            albumns.add(new Albumn(albumn));
            System.out.println("Albumn "+albumn+" Created ");
        }
    }
    public void addsonginalbumn(String albumn,String song,double duration)
    {
        int x=checkalbumn(albumn);
        if(x>=0)
        {
            albumns.get(x).addsong(song,duration);
        }
    }
    public void totalsongs()
    {
        System.out.println(playlist.size());
    }

    public void nextsong()
    {
        if (i.hasNext())
        {if(!forward)
        {i.next();
            forward=true;}
            System.out.println("Now playing : "+playlist.get(2).gettitle());}
        else
        System.out.println("End of Playlist");

    }
    public void previoussong()
    {
        if(i.hasPrevious()) {
            if (forward) {
                i.previous();
                forward = false;
            }
            System.out.println("Now playing : " + i.previous().gettitle());
        }
            else
            System.out.println("This is Start of playlist");
        }


    public void removecurrent()
    {
        if (i.hasNext())
        {if(!forward)
        {i.next();
            forward=true;}
            System.out.println("Now playing : "+ i.next().gettitle());}
        if(i.hasPrevious()) {
            if (forward) {
                i.previous();
                forward = false;
            }
            System.out.println("Now playing : " + i.previous().gettitle());
        }
        else
            System.out.println("No Songs in Playlist");
    }
    public void addsongtoplaylist(String albumnname,String sname)
    {
        if(checkalbumn(albumnname)>=0)
        {
            Song x=albumns.get(checkalbumn(albumnname)).searchsong(sname);
            if (x!=null)
            {
                System.out.println("Added "+sname+" to playlist");
                playlist.add(x);

            }
        }
    }
    public void repeatsong()
    {
        if(forward)
        System.out.println("Currently playing "+i.next().toString());
        else
        {
            System.out.println("Currently playing "+i.next());
        }
    }
    private int checkalbumn(String aname)
    {
     for (int i=0;i<albumns.size();i++)
     {
         if (albumns.get(i).getAlbumnname().compareToIgnoreCase(aname)==0)
             return i;
     }
         return -1;
    }



}
