/**
 * @author Vinit Vala
 * SBU ID: 114501080
 *
 * SongRecord class which contains information about a particular audio file.
 */

import java.util.Objects;
public class SongRecord {

    private String title;
    private String artist;
    private int minutes;
    private int seconds;

    /**
     * Default constructor
     */
    public SongRecord(){

    }

    /**
     * Parameterized Constructor for SongRecord
     * @param title of song
     * @param artist of song
     * @param minutes of song
     * @param seconds of song
     */
    public SongRecord(String title,String artist, int minutes, int seconds){
        this.title=title;
        this.artist=artist;
        this.minutes=minutes;
        this.seconds=seconds;
    }

    /**
     * accessor method for Title
     * @return String
     */
    public String getTitle(){
        return title;
    }

    /**
     * Mutator method for Title
     * @param title of song
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * accessor method for Artist
     * @return String
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Mutator method for Artist
     * @param artist of song
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * accessor method for minutes
     * @return int
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Mutator method for minutes
     * @param minutes of song
     * @throws IllegalArgumentException
     */
    public void setMinutes(int minutes) throws IllegalArgumentException{    // should I create a new exception?
        if(minutes>59 || minutes<0)
            throw new IllegalArgumentException("The value of seconds should be between 0 and 59");
        else
            this.minutes = minutes;
    }

    /**
     * accessor method for Seconds
     * @return int
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * Mutator method for Seconds
     * @param seconds of song
     * @throws IllegalArgumentException
     */
    public void setSeconds(int seconds) throws IllegalArgumentException {
        if(seconds<0)
            throw new IllegalArgumentException("The value of minutes should not be negative!");
        this.seconds = seconds;
    }

    /**
     * Equals method for objects
     * @param obj
     * @return boolean
     */
    public boolean equals(Object obj){
        if(obj instanceof SongRecord){
            SongRecord songRecord=(SongRecord) obj;
            return Objects.equals(this.title, songRecord.title) && Objects.equals(this.artist, songRecord.artist) &&
                    Objects.equals(this.minutes, songRecord.minutes) && Objects.equals(this.seconds, songRecord.seconds);
        }
            return false;
    }


    /**
     * To String method to print details of song
     * @return String
     */
    public String toString() {          //change format of toString method as needed
        return
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }

    /**
     * clone method to copy a song
     * @return newSongRecord
     */
    public SongRecord clone(){
        SongRecord newSongRecord=new SongRecord(this.title,this.artist,this.minutes,this.seconds);
        return newSongRecord;
    }
}
