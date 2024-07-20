/**
 * @author Vinit Vala
 * SBU ID: 114501080
 * PlaylistOperations class that tests the methods of the Playlist class and allows the user to manipulate a
 * single Playlist object by performing operations on it.
 */

import java.util.Scanner;

public class PlaylistOperations {


    public static void main(String[] args) throws ArrayIndexOutOfBoundsException{

        Playlist currentPlaylist= new Playlist();
        Playlist playlistA=new Playlist();
        Playlist playlistB=new Playlist();
        Playlist copyPlaylist=new Playlist();

        currentPlaylist=playlistA;
        String playlistName = "default";
        String newPlayName=null;
        String copyInput=null;
        int copyCount=0; int newCount=0; int changeCount=0;

        System.out.println("Welcome to Vinit's playlist of audio files!");
        Scanner stdin=new Scanner(System.in);

        int counter=0;

        while (counter == 0) {

            System.out.println("\n****************************************************************");
            System.out.println("Menu:\nA) Add Song\nB) Print Songs by Artist\nG) Get Song\nR) Remove Song" +
                "\nP) Print All Songs\nS) Size\nQ) Quit\n\nX) Play the songs from Default Playlist \nN) Create new playlist\nV) Change Current playlist" +
                    "\nC) Copy playlist into new playlist\nE) Compare songs between current and selected playlist" +
                    "\nD) Display all playlist names\n");

            System.out.print("Select a menu option: ");

            char userInput = stdin.next().charAt(0);
            stdin.nextLine();
            userInput = Character.toUpperCase(userInput);

            try{
            switch(userInput) {

                case 'A': {

                        //Add Song
                        System.out.print("Enter the song title: ");
                        String title = stdin.nextLine();
                        System.out.print("Enter the song artist: ");
                        String artist = stdin.nextLine();
                        System.out.print("Enter the song length (minutes- between 0 and 59) : ");
                        int minutes = stdin.nextInt();
                        if (minutes > 59 || minutes < 0)
                            throw new IllegalArgumentException("The value of minutes should be between 0 and 59");
                        System.out.print("Enter the song length (seconds- not less than 0): ");
                        int seconds = stdin.nextInt();
                        if (seconds > 59 || seconds < 0)
                            throw new IllegalArgumentException("The value of seconds should be between 0 and 59");
                        System.out.print("Enter the song position: ");
                        int position = stdin.nextInt();

                    SongRecord newSongRecord = new SongRecord(title, artist, minutes, seconds);
                    currentPlaylist.addSong(newSongRecord, position);
                    System.out.println("Song added: " + title + " by " + artist);

                }
                break;

                case 'B': {

                    //Get song by artist
                    System.out.print("Enter the Artist: ");
                    String artist = stdin.nextLine().toUpperCase();
                    currentPlaylist.getSongsByArtist(currentPlaylist,artist);

//                    String a;
//                    System.out.printf("%-10s%-35s%-35s%-20s\n", "Song#", "Title", "Artist", "length");
//
//                    System.out.println("---------------------------------------------------------------------------------------------------");
//                    int n = currentPlaylist.size();
//                    int seconds;
//                    int position = 0;
//                    int minutes;
//                    String length;
//                    for (int i = 1; i <= n; i++) {
//
//                        seconds = currentPlaylist.getSong(i).getSeconds();
//                        minutes = currentPlaylist.getSong(i).getMinutes();
//                        String s = String.valueOf(seconds);
//                        if (seconds < 10) {
//                            s = "0" + s;
//                        }
//                        String l = String.valueOf(minutes);
//                        length = l + ":" + s;
//
//                        a = currentPlaylist.getSong(i).getArtist().toUpperCase();
//                        if (a.equals(artist)) {
//                            position++;
//                            System.out.printf("%-10d%-35s%-35s%-20s\n", position, currentPlaylist.getSong(i).getTitle(),
//                                    currentPlaylist.getSong(i).getArtist(), length);
//                        }
//                    }
                }
                break;

                case 'P': {

                    //Print All songs
                    currentPlaylist.printAllSongs();
//                    System.out.printf("%-10s%-35s%-35s%-20s\n", "Song#", "Title", "Artist", "length");
//                    System.out.println("---------------------------------------------------------------------------------------------------");
//                    int n = currentPlaylist.size();
//
//                    int seconds;
//                    int minutes;
//                    String length;
//                    for (int i = 1; i <= n; i++) {
//
//                        seconds = currentPlaylist.getSong(i).getSeconds();
//                        minutes = currentPlaylist.getSong(i).getMinutes();
//
//                        String s = String.valueOf(seconds);
//                        if (seconds < 10) {
//                            s = "0" + s;
//                        }
//                        String l = String.valueOf(minutes);
//                        length = l + ":" + s;
//
//                        System.out.printf("%-10d%-35s%-35s%-20s\n", i, currentPlaylist.getSong(i).getTitle(),
//                                currentPlaylist.getSong(i).getArtist(), length);
//                    }
                   //  +":" + playlistA.getSong(i).getSeconds()
                }
                break;

                case 'G': {
                    //Get song

                    System.out.print("Enter the position: ");
                    int position = stdin.nextInt();
                    System.out.printf("%-10s%-20s%-20s%-10s\n", "Song#", "Title", "Artist", "length");

                    System.out.println("----------------------------------------------------------------");
                    int n = currentPlaylist.size();

                    int seconds;
                    int i = position;
                    int minutes;
                    String length;

                    if (currentPlaylist.size()<i) //<=
                        throw new ArrayIndexOutOfBoundsException("Sorry! No song found at position " + position);
                    else {
                        seconds = currentPlaylist.getSong(i).getSeconds();
                        minutes = currentPlaylist.getSong(i).getMinutes();

                        String s = String.valueOf(seconds);
                        if (seconds < 10) {
                            s = "0" + s;
                        }
                        String l = String.valueOf(minutes);
                        length = l + ":" + s;


                        System.out.printf("%-10d%-20s%-20s%-10s\n", i, currentPlaylist.getSong(i).getTitle(),
                                currentPlaylist.getSong(i).getArtist(), length);
                    }
                }
                break;

                case 'R': {
                    //Remove song

                    System.out.print("Enter the position at which song will be removed: ");
                    int position = stdin.nextInt();
                    currentPlaylist.removeSong(position);
                    System.out.println("Song removed at position " + position);

                }
                break;

                case 'S': {
                    //Size
                    int size = currentPlaylist.size();
                    System.out.print("There are " + size + " song(s) in the current playlist");

                }
                break;

                case 'N': {

                    // Create new playlist
                    currentPlaylist=playlistB;

                    System.out.println("New playlist has been created and set to current playlist");
                    System.out.println("Enter a name for the playlist");
                    newPlayName= stdin.nextLine();
                    playlistName=newPlayName;
                    newCount++;

                    System.out.println("You are now accessing playlist- "+playlistName);

                }
                break;

                case 'V': {

                    //Change playlist
                    System.out.println("You are currently accessing playlist- "+playlistName);
                    System.out.println("Input the name of the playlist you want to change to: ");
                    System.out.println("The name of the default playlist is- Default ");
                    System.out.println("Type default to access it.");
                    String nameInput=stdin.nextLine();
                    int counter1=0;

                    while(counter1==0) {
                        if (nameInput.equalsIgnoreCase("default")){
                            currentPlaylist = playlistA;
                            changeCount++; counter1++;
                            System.out.println("You are now accessing the default playlist!");
                        }

                        else if (nameInput.equalsIgnoreCase(newPlayName)){
                            currentPlaylist = playlistB;
                            changeCount++; counter1++;
                            System.out.println("You are now accessing playlist- "+newPlayName);
                        }
                        else if(nameInput.equalsIgnoreCase(copyInput)){
                            currentPlaylist= copyPlaylist;
                            changeCount++; counter1++;
                            System.out.println("You are now accessing playlist- "+copyInput);
                        }
                        else
                            System.out.println("Please enter a valid name. Such playlist does not exist");
                        counter1++;
                    }
                }
                break;

                case 'C': {

                    // Copy playlist
                    System.out.println("The current playlist's songs will be copied to a new playlist!");
                    System.out.println("Input the name of the playlist you want to copy to: ");
                    copyInput=stdin.nextLine();
                    Playlist newPlaylist= new Playlist();

                    copyPlaylist= (Playlist) currentPlaylist.clone();
                    currentPlaylist=copyPlaylist; // should I remove this?
                    System.out.println("The current playlist has been copied to playlist- "+copyInput);
                    System.out.println("You are currently accessing playlist- "+copyInput);
                    copyCount++;

                }
                break;

                case 'E': {
                    //E - Compare the songs in the current playlist with the given playlist.

                    System.out.println("Comparing the songs in the current playlist with the default playlist:");
                    if(currentPlaylist.equals(playlistB))
                        System.out.println("The current playlist and the default playlist are same and have the same songs!");
                    else
                        System.out.println("Current playlist and default playlist are not the same and have different songs");

                }
                break;

                case 'D': {

                    System.out.println("The names of the playlist are as follows:");
                    System.out.println(playlistName);
                    System.out.println("Default playlist");
                    if(newCount>0 && changeCount!=1)
                    System.out.println(newPlayName);
                    if(copyCount>0)
                    System.out.println(copyInput);

                }
                break;

                case 'X': {

                    //Play songs!
                    System.out.println("Play a song from sample list:\n");

                    System.out.printf("%-10s%-20s%-20s%-10s\n", "Song#", "Title", "Artist", "length");
                    System.out.println("----------------------------------------------------------------");
                    System.out.printf("%-10d%-20s%-20s%-10s\n", 1, "Radioactive", "Imagine Dragons", "3:09");
                    System.out.printf("%-10d%-20s%-20s%-10s\n", 2, "It's time", "Imagine Dragons", "5:24");
                    System.out.printf("%-10d%-20s%-20s%-10s\n", 3, "Gangnam Style", "PSY", "4:09");

                    System.out.print("Enter 1,2,or 3 to play your selected song:");
                    int userIn = stdin.nextInt();
                    stdin.nextLine();

                    try {
                        String filePath="";
                        if(userIn==1){
                            filePath = "/Users/vinitvala/IdeaProjects/Summer/Imagine Dragons - Radioactive.wav";
                            System.out.println("Enjoy Radioactive!");
                        }
                        else if(userIn==2){
                            filePath = "/Users/vinitvala/IdeaProjects/Summer/Imagine Dragons - It's Time.wav";
                            System.out.println("It's Time");
                        }
                        else if(userIn==3){
                            filePath = "/Users/vinitvala/IdeaProjects/Summer/PSY - GANGNAM STYLE(강남스타일) M_V.wav";
                            System.out.println("Enjoy Gangnam Style!");
                        }
                        else
                            System.out.println("Invalid song option selected!");

                        SongPlayer audioPlayer = new SongPlayer(filePath);

                        audioPlayer.play();

                    } catch (Exception ex) {
                        System.out.println("Error with playing sound.");
                        ex.printStackTrace();

                    }
                    break;
                }
                case 'Q': {

                    System.out.println("Thank you for using the playlist!");
                    counter++;
                }
                break;

                default:
                    System.out.println("Wrong option entered. Enter again!");

            }

            }catch (FullPlaylistException e){
                System.out.println("The playlist is full");
            }
            catch (EmptyPlaylistException e){
                System.out.println("The playlist is empty!");
            }
            catch(IllegalArgumentException e){
                System.out.println("Value entered is not within the valid range.");
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Sorry! No song found at the position you entered ");
            }
    }
    }
}
