package org.example;

import java.util.*;


public class Main {

    private static ArrayList<album> albums = new ArrayList<>();

    public static void main(String[] args) {



        album AlbumPosty = new album("Beerbongs & Bentleys","Post malone");
        AlbumPosty.addSong("Better Days",3.50);
        AlbumPosty.addSong("Over now",3.50);
        AlbumPosty.addSong("Rockstar",4.00);
        AlbumPosty.addSong("Paranoid",3.27);

        albums.add(AlbumPosty);

        album AlbumTupac = new album("Untill The End Of Time","Tupac");
        AlbumTupac.addSong("California Love",3.50);
        AlbumTupac.addSong("All Eyes On Me ",3.27);
        AlbumTupac.addSong("Fame",3.50);
        AlbumTupac.addSong("When Thugz Cry",4.00);

        albums.add(AlbumTupac);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("Better Days",playList_1);
        albums.get(0).addToPlayList("Paranoid",playList_1);
        albums.get(1).addToPlayList("Fame",playList_1);

        play(playList_1);
    }

    private static void play(LinkedList<Song>playList){
        Scanner Scn = new Scanner(System.in);

        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size() == 0){
            System.out.println("This playlist have no song !");
        }else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit){
            int action = Scn.nextInt();
            Scn.nextLine();

            switch (action){
                case 0:
                    System.out.println("Playlist complete !");
                    quit = true;
                    break;

                case 1:
                    if (!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now Playing " +listIterator.next().toString());
                    }else {
                        System.out.println("no song available, reached to the end of the list !");
                        forward = false;
                    }
                    break;

                case 2:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("now playing " +listIterator.previous().toString());
                    }else {
                        System.out.println("We are the first song");
                        forward = false;
                    }
                    break;

                case 3:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Now playing " +listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("We are at the start of the list !");
                        }
                    }else {
                        if (listIterator.hasNext()){
                            System.out.println("Now playing " +listIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("We have reached to the end of list !");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    if (playList.size()>0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now playing "+listIterator.next().toString());
                        }else {
                            if (listIterator.hasPrevious()){
                                System.out.println("Now playing "+listIterator.previous().toString());
                            }
                        }
                    }
            }
        }

    }

    private static void printMenu(){
        System.out.println("Alavilable option \n Press");
        System.out.println("0 - To quit\n" +
                "1 - To play next song\n"+
                "2 - To play previous song\n"+
                "3 - To replay the current song\n"+
                "4 - List of all songs\n"+
                "5 - Print all available option\n"+
                "6 - Delete current Song");
    }

    private static void printList(LinkedList<Song> playList_1){
        Iterator<Song> iterator = playList_1.iterator();
        System.out.println("______________________");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("______________________");
    }

}