import java.util.Arrays;
import java.util.Objects;

/**
 * @author Vinit Vala
 * SBU ID: 114501080
 * Playlist class that stores all SongRecord objects that belong to a particular playlist.
 */
public class Playlist {

    private SongRecord[] songRecords;
    private int count;
    final int CAPACITY=50;

    /**
     * Default constructor
     */
    public Playlist(){
        this.count=0;
    }

    /**
     * Clone method to copy playlist
     * @return playlist object
     */
    public Object clone(){                          //check if proper
        Playlist playlistCopy=new Playlist();
        SongRecord[] songRecordCopy=new SongRecord[count];

        for(int i=0;i<count;i++){
            songRecordCopy[i]=songRecords[i];
        }
        playlistCopy.songRecords=songRecordCopy;
        playlistCopy.count=count;

        return (Playlist)playlistCopy;      // should I keep typeCast or remove it?
    }

    /**
     * equals method to check if playlists are equal
     * @param obj
     * @return boolean
     */
    public boolean equals(Object obj) {

        //Note: If obj is null or it is not a Playlist object, then the return value is false.
        if(obj==null){
            return false;
        }

        Playlist playlist1=(Playlist)obj;
        if(playlist1.count!=count){
            return false;
        }
        else{
            for(int i=0;i< playlist1.count;i++){
                if(playlist1.songRecords[i]!=songRecords[i])
                    return false;
            }
        }
        return true;
    }

    /**
     * Method to find size of playlist
     * @return int
     */
    public int size(){                  //Preconditions: This PlayList object has been instantiated.
        return this.count;
    }

    /**
     * Add song method which adds songs to the playlist
     * @param song
     * @param position
     * @throws IllegalArgumentException
     * @throws FullPlaylistException
     * @throws NullPointerException
     */
    public void addSong(SongRecord song, int position) throws IllegalArgumentException,FullPlaylistException,NullPointerException{
        position--; //position in the playlist and not the array
        if(count>CAPACITY)
            throw new FullPlaylistException("The Playlist if full!");
        else if(position<0 || position>count+1)
            throw new IllegalArgumentException("The position of song is not within the valid range of playlist");
        else{
            SongRecord[] songAdd=new SongRecord[count+1];

            for(int i=0;i<=count;i++){          // what if 1st song is added to position 2? what if songs added to position 1 and then 3? create holes in the array?
                if (count==0&&position>0)
                    throw new IllegalArgumentException("The playlist is empty so You can only add the song at position 1.");
                else if(i<position)
                    songAdd[i]=songRecords[i];
                else if(i==position)
                    songAdd[i]=song;
                else
                    songAdd[i]=songRecords[i-1];
                }
            songRecords=songAdd;
            count++;

            }
        }

    /**
     * removeSong method which removes songs from the playlist
     * @param position
     * @throws IllegalArgumentException
     * @throws EmptyPlaylistException
     */
    public void removeSong(int position) throws IllegalArgumentException, EmptyPlaylistException{

        if(count==0)
            throw new EmptyPlaylistException("The playlist is empty!");
        else if(position<1||position>count){ //>=count
            throw new IllegalArgumentException("Invalid position entered");
        }
        // else if(position==count)
        else{
            position--;
            SongRecord songRemove[]=new SongRecord[count-1];
            int j=0;
            for(int i=0;i<count;i++){
                if(i==position)
                    continue;
                songRemove[j]=songRecords[i];
                j++;
            }

            songRecords=songRemove;
            count--;
        }
    }

    /**
     * getSong method which gets a particular song in the playlist
     * @param position of song
     * @return song object
     * @throws IllegalArgumentException
     * @throws ArrayIndexOutOfBoundsException
     */
    public SongRecord getSong(int position) throws IllegalArgumentException, ArrayIndexOutOfBoundsException{ //should be O(1)
        position--;
        if(position<0|| position>count)
            throw new IllegalArgumentException("position is not within the valid range.");
        else if(songRecords.length<=position)
            throw new ArrayIndexOutOfBoundsException("");//There exists no song at position"+ ++position
        else
            return songRecords[position];

    }

    /**
     * method to print all songs
     */
    public void printAllSongs(){

        System.out.printf("%-10s%-20s%-20s%-10s\n", "Song#", "Title", "Artist", "length");

        System.out.println("----------------------------------------------------------------");
        int n = count;

        int seconds;
        int minutes;
        String length;
        for (int i = 0; i < n; i++) { //i=1

            seconds = songRecords[i].getSeconds();
            minutes = songRecords[i].getMinutes();

            String s = String.valueOf(seconds);
            if (seconds < 10) {
                s = "0" + s;
            }
            String l = String.valueOf(minutes);
            length = l + ":" + s;

            System.out.printf("%-10d%-20s%-20s%-10s\n", i+1, songRecords[i].getTitle(),
                    songRecords[i].getArtist(), length);
        }

    }

    /**
     * Method to print all songs by Artist in a playlist
     * @param originalList
     * @param artist
     * @return
     */
    public static Playlist getSongsByArtist(Playlist originalList, String artist){

        String a;

        System.out.printf("%-10s%-20s%-20s%-10s\n", "Song#", "Title", "Artist", "length");

        System.out.println("----------------------------------------------------------------");
        int n = originalList.count;
        int seconds;
        int position = 0;
        int minutes;
        String length;
        for (int i = 1; i <= n; i++) {

            seconds = originalList.getSong(i).getSeconds();
            minutes = originalList.getSong(i).getMinutes();
            String s = String.valueOf(seconds);
            if (seconds < 10) {
                s = "0" + s;
            }
            String l = String.valueOf(minutes);
            length = l + ":" + s;

            a = originalList.getSong(i).getArtist().toUpperCase();
            if (a.equals(artist)) {
                position++;
                System.out.printf("%-10d%-20s%-20s%-10s\n", position, originalList.getSong(i).getTitle(),
                        originalList.getSong(i).getArtist(), length);
            }

        }
        return originalList;

    }

    /**
     * ToString method for playlist
     * @return String
     */
    public String toString() {  //change this to print a single playlist!


        return "Playlist{" + Arrays.toString(songRecords);
    }
}


