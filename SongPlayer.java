/**
 * @author Vinit Vala
 * SBU ID: 114501080
 * SongPlayer class that plays songs from the playlist
 */

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SongPlayer {

    Clip clip;
    String status;

    AudioInputStream audioInputStream;
    static String filePath;

    /**
     * Parameterized Constructor
     * @param filePath
     * @throws UnsupportedAudioFileException
     * @throws IOException
     * @throws LineUnavailableException
     */
    public SongPlayer(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // created AudioInputStream object
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

        // clip reference
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * Method to start the clip
     */
    public void play() {
        clip.start();
        status = "play";
    }
}