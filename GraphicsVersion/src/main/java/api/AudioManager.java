package api;

import java.io.File;
import java.io.ByteArrayInputStream;
import javax.sound.sampled.*;

public class AudioManager {

    private static SourceDataLine speaker;

    public static void startPlaying(byte[] audio) {
        try {
            AudioInputStream ais = new AudioInputStream(
                    new ByteArrayInputStream(audio),
                    new javax.sound.sampled.AudioFormat(44100, 16, 2, true, false),
                    audio.length
            );
            AudioFormat format = ais.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            speaker = (SourceDataLine) AudioSystem.getLine(info);
            speaker.open(format);
            speaker.start();
            int buffer;
            byte[] data = new byte[4096];
            while ((buffer = ais.read(data)) != -1) speaker.write(data, 0, buffer);
            speaker.drain();
            speaker.close();
            ais.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}