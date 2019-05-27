import ws.schild.jave.*;
import java.io.File;
import java.util.Formatter;


public class VideoTime {

    public static void main(String[] args){
        File source = new File("lq.mp4");
        MultimediaObject multimediaObject = new MultimediaObject(source);
        try {
            MultimediaInfo info = multimediaObject.getInfo();
            long time = info.getDuration();

            int  h = (int) (time / (60*60*1000));
            int min = (int) (time%(60*60*1000) /(60*1000));
            int sec = (int) ((time%(60*60*1000) % (60*1000))/1000);

            Formatter formatter = new Formatter();
            String result = formatter.format("%02d:%02d:%02d", h, min, sec).toString();

            System.out.println(result);
        } catch (EncoderException e) {
            e.printStackTrace();
        }
    }
}
