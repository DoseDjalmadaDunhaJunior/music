import javax.sound.sampled.*;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TrackSample {

    private static byte[] readBytesInPredefinedFormat(TargetDataLine format, InputStream inStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[8192];
        int bytesRead;
        while ((bytesRead = inStream.read(buffer)) > 0) {
            int count = format.read(buffer, 0, buffer.length);
            if (count > 0) {
                byteArrayOutputStream.write(buffer, 0, count);
            }
            byteArrayOutputStream.write(buffer, 0, bytesRead);
        }
        byte[] bytes = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        inStream.close();
        return bytes;
    }

    public static byte[] getTrackBytes(String pathToTrackSample) throws IOException, LineUnavailableException {
        FileInputStream fileInputStream = new FileInputStream(pathToTrackSample);
        final AudioFormat format = CurrentAudioFormat.getAudioFormat(); //Fill AudioFormat with the wanted settings
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

        TargetDataLine line = (TargetDataLine) AudioSystem.getLine(info);
        line.open(format);
        line.start();

        return readBytesInPredefinedFormat(line, fileInputStream);
    }
}