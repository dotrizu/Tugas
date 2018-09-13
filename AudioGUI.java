
package modul2;
import sun.audio.*; //import the sun.audio package
import java.awt.*;
import java.io.*;


public class AudioGUI extends Frame implements FilenameFilter {

/**
 * 
 */
private static final long serialVersionUID = 4914433234899026080L;
Button openButton = new Button("Open");  
Button playButton = new Button("Play");
Button loopButton = new Button("Loop");
Button stopButton = new Button("Stop");
Label filename = new Label("                   ");
File theFile = null;
@SuppressWarnings({ "restriction" })
AudioData theData = null;
InputStream nowPlaying = null;

@SuppressWarnings({ "deprecation" })
public AudioGUI() {
    super("AudioGUI");
    resize(300, 200);
    Panel north = new Panel();
    north.setLayout(new FlowLayout(FlowLayout.LEFT));
    north.add(new Label("File: "));
    north.add("North", filename);
    add("North", north);
    Panel south = new Panel();
    south.add(openButton);
    south.add(playButton);
    south.add(loopButton);
    south.add(stopButton);
    add("South", south);
}

@SuppressWarnings("deprecation")
public static void main(String[] args) {
    AudioGUI sp = new AudioGUI();
    sp.show();
}

@SuppressWarnings({ "deprecation", "restriction" })
public void open() {
    FileDialog fd = new FileDialog(this, "Please select a .au file:");
    fd.setFilenameFilter(this);
    fd.show();
    try {
        theFile = new File(fd.getDirectory() + "/" + fd.getFile());
        if (theFile != null) {
            filename.setText(theFile.getName());
            FileInputStream fis = new FileInputStream(theFile);
            AudioStream as = new AudioStream(fis);
            theData = as.getData();
        }
    }
    catch (IOException e) {
        System.err.println(e);
    }
}

@SuppressWarnings("restriction")
public void play() {
    stop();    
    if (theData == null) open();
    if (theData != null) {
        AudioDataStream ads = new AudioDataStream(theData);
        AudioPlayer.player.start(ads);
        nowPlaying = ads;
    }
}

@SuppressWarnings("restriction")
public void stop() {
    if (nowPlaying != null) {
        AudioPlayer.player.stop(nowPlaying);
        nowPlaying = null;
    }
}

@SuppressWarnings("restriction")
public void loop() {
    stop();
    if (theData == null) open();
    if (theData != null) {
        ContinuousAudioDataStream cads = new ContinuousAudioDataStream(theData);
        AudioPlayer.player.start(cads);
        nowPlaying = cads;
    }
}

public boolean action(Event e, Object what) {

    if (e.target == playButton) {
        play();
        return true;
    }
    else if (e.target == openButton) {
        open();
        return true;
    }
    else if (e.target == loopButton) {
        loop();
        return true;
    }
    else if (e.target == stopButton) {
        stop();
        return true;
    }

    return false;

}

public boolean accept(File dir, String name) {

    name = name.toLowerCase();
    if (name.endsWith(".au")) return true;
    if (name.endsWith(".wav")) return true;
    return false;

}

}