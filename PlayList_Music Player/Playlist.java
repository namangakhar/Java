package Theepicuremale;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
public class Playlist {
    private LinkedList<Song> playlist=new LinkedList<Song>();
    private ArrayList<Albumn> albumns=new ArrayList<Albumn>();
    private String listname;
    private int playing=0;

    public ListIterator<Song> i;
    boolean forward=true;

    public Playlist(String playlistname)
    {
        this.listname = playlistname;
        i= playlist.listIterator();
    }
//albumn stuff
     public void addalbumn(String albumn)
    {
        if(checkalbumn(albumn)<0)
        {
            albumns.add(new Albumn(albumn));
            System.out.println("Albumn "+albumn+" Created ");
        }
        else
            System.out.println("Albumn already present");
    }
    public void addalbumn(Albumn albumn)
    {
        if(checkalbumn((albumn.getAlbumnname()))<0)
        {   this.albumns.add(albumn);
                    System.out.println("Albumn "+albumn+" Created ");
        }
        else
            System.out.println("Albumn already present");
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

    public void addsonginalbumn(String albumn,String song,double duration)
    {
        int x=checkalbumn(albumn);
        if(x>=0)
        {
            albumns.get(x).addsong(song,duration);
        }
    }
//total songs

    public void totalsongs()
    {
        System.out.println("Playlist "+listname+" has "+playlist.size()+" songs in it");
        System.out.println("===========================================");
        for(int i=0;i<playlist.size();i++)
            System.out.println((i+1)+". "+playlist.get(i));
        System.out.println("===========================================");
    }

//songs stuff
    public void addsongtoplaylist(String albumnname,String sname)
    {
        if(playlist.size()!=0)
            while(i.hasNext())
            {
                playing++;
                i.next();
            }

        if(checkalbumn(albumnname)>=0)
        {
            Song x=albumns.get(checkalbumn(albumnname)).searchsong(sname);
            if (x!=null)
            {
                System.out.println("Added "+sname+" to playlist");
                i.add(x);
            }
        }
        if(playing>0)
        {
            while(playing>0)
            {
                playing--;
                i.previous();
            }
            i.previous();
        }
    }
    public void startplaylist() {
        while (i.hasPrevious()) {
            i.previous();
        }
        nextsong();
    }

    public void nextsong()
    {
        if (i.hasNext()) {
            if(!forward)
            {   i.next();
                forward=true;
            }
            System.out.println("Now playing : "+ i.next());
        }
        else {
        System.out.println("End of Playlist");
        }
    }

    public void previoussong()
    {
        if(i.hasPrevious()) {
            if (forward) {
                i.previous();
                forward = false;
            }}
        if(i.hasPrevious()){
            System.out.println("Now playing : " + i.previous().gettitle());
        }
            else
        System.out.println("This is Start of playlist");
        }


    public void removecurrent()
    {
        i.remove();
        if (i.hasNext())
        {
            System.out.println("Now playing : "+ i.next().gettitle());
        }
        else if(i.hasPrevious()) {
            if (forward) {
                i.previous();
                forward = false;
            }
            System.out.println("Now playing : " + i.previous().gettitle());
        }
        else
            System.out.println("No Songs in Playlist");
    }
    public void repeatsong()
    {
        if(!forward)
        {System.out.println("Currently playing "+i.next().toString());
        forward=true;}
        else
        {
            System.out.println("Currently playing "+i.previous().gettitle());
            i.next();
        }
    }
}
