import com.github.sarxos.webcam.Webcam;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    public static final int FRAME_WIDTH = 900;
    public static final int FRAME_HEIGHT = 620;
    public static final int CHAR_SPACE = 10;
    public static final int SIZE = 100;
    public static final float WIDTH_TO_HEIGHT = 1f;
    public static final float SPACE = 0.3f;
    public static Utilities util;

    public static void main(String[] args) throws InterruptedException {
        util = new Utilities();
        util.setCharSet(Utilities.SHORTSET);

        Webcam webcam = Webcam.getDefault();
        webcam.open();
        BufferedImage image = webcam.getImage();



        char[][] ascii = imageToAscii(image);
        Display display = new Display(util.invertChar(ascii));



        while(true){
            display.setASCII(util.invertChar(imageToAscii(webcam.getImage())));
        }
    }









    public static char[][] imageToAscii(BufferedImage image){
        int width = image.getWidth();
        int height = image.getHeight();
        double xStep = ((double)width)/SIZE;
        double yToXRatio = (double)height/width;
        int numYChar = (int)(yToXRatio*(SIZE* WIDTH_TO_HEIGHT));
        double yStep = ((double)height)/numYChar;
        int subArea = (int)xStep*(int)yStep;

        double x, y = 1;
        int xIndex = 0, yIndex = 0;
        char[][] ascii = new char[SIZE][numYChar];

        while(yIndex<numYChar){
            x=1;
            xIndex = 0;
            while(xIndex<SIZE){
                int r=0,g=0,b=0;
                for(int x1 = (int)x; x1<(int)x+(int)xStep && x1<width; x1++){
                    for(int y1 = (int)y; y1<(int)y+(int)yStep && y1<height;y1++){
                        int rgb = image.getRGB(x1,y1);
                        r += (rgb>>16) & 0xff;
                        g += (rgb>>8) & 0xff;
                        b += rgb & 0xff;
                    }
                }

                int toGray = util.rgbToGray(r/subArea,g/subArea,b/subArea);
                int toValues = util.grayToNValues(toGray, util.maxN, 1f);
                char toChar = util.grayToChar(toValues);

                ascii[xIndex][yIndex]=toChar;
                x+=xStep;
                xIndex++;
            }
            y+=yStep;
            yIndex++;
        }
        return ascii;
    }

}
