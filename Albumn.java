package Theepicuremale;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Albumn {
    private String albumnname;
    private ArrayList<Song> songs =new ArrayList<Song>();

    public Albumn(String albumnname)
    {
        this.albumnname=albumnname;
    }
    public void allsongs()
    {
        System.out.println("Total songs ="+songs.size());
        for(int i=0;i<songs.size();i++)
            System.out.println((i+1) +" " + songs.get(i).gettitle());
    }
    public void addsong(String title,double duration)
    {

        if(checksong(title)<0)
        {
            songs.add(findplace(title),new Song(title,duration));
            System.out.println("Song "+title+" added to playlist.");
        }
        else
        {
            System.out.println("Song with name "+title+" already exists ");
        }
    }

    public String getAlbumnname() {
        return albumnname;
    }


    public Song searchsong(String title)
    {
        if(checksong(title)>=0)
        {
            return songs.get(checksong(title));}
        else
            System.out.println("Couldnt find song with the name "+title);
            return null;
    }

    private int findplace(String title)
    {
        if(songs.size()==0)
            return 0;
        for(int i=0;i<songs.size();i++) {
            if (songs.get(i).gettitle().compareToIgnoreCase(title) > 0) {
                if (i == 0)
                    return 0;
                return --i;
            }
        }
        return songs.size();
    }

    private int checksong(String title)
    {
        for(int i=0;i<songs.size();i++)
        {
            if(title.compareToIgnoreCase(songs.get(i).gettitle())==0)
            return i;
        }
        return -1;
    }




}
