package org.example;
import java.util.ArrayList;
import java.util.LinkedList;

public class album {
    private String name;
    private String artist;
    private ArrayList<Song>songs;

    public album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public album(){

    }

    public Song findSong(String title){
        for(Song checkedSong : songs){
            if (checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return null;
    }

    public boolean addSong(String title, double duration){
        if (findSong(title) == null){
            songs.add(new Song(title,duration));
        //    System.out.println(title + " Successfully added to the list");
            return true;

        }

        else {
        //    System.out.println(  title + " already exist in the list");
            return false;
        }
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song>playList){
        int index = trackNumber - 1;

        if (index > 0 && index <= this.songs.size()){
            playList.add(this.songs.get(index));
            return true;
        }
     //   System.out.println("This Album does not have song with track number " +trackNumber);
        return false;

    }

    public boolean addToPlayList(String title, LinkedList<Song>PlayList){
        for (Song checkedSong : this.songs){
            if (checkedSong.getTitle().equals(title)){
                PlayList.add(checkedSong);
                return true;
            }
        }
    //    System.out.println( title + " there is no such song in this album !");
        return false;
    }

}
