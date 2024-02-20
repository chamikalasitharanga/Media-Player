package org.example;

public class Song {

    String title;
    double duration;

    public Song(String T, double D){
        this.title=T;
        this.duration=D;

    }
    public Song(){

    }

    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
