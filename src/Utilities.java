import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

public class Utilities {
    char[] charSet;
    int maxN = 0;
    static final String FULLSET = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'.                                                                                                                                                                        ";
    static final String SHORTSET = "@@@%#*+=--:::.                                       ";



    public void setCharSet(String string) {
        charSet = new char[string.length()];
        for(int i = 0; i<string.length(); i++){
            charSet[i] = string.charAt(i);
        }
        maxN = string.length()-1;
    }

    public char[][] invertChar(char[][] ascii){
        int xLength = ascii.length;
        int yLength = ascii[0].length;
        char[][] res = new char[xLength][yLength];
        for(int y = 0; y < yLength;y++){
            for(int x = 0; x< xLength;x++){
                res[xLength-1-x][y] = ascii[x][y];
            }
        }
        return res;
    }

    public int rgbToGray(int r, int g, int b){
        return (r+g+b)/3;
    }

    public int grayToNValues(int gray, int n, float white){
        double decimal = (double)gray/255;
        int nVal = (int)(decimal*n);
        if(nVal>((double)n*white)) nVal = n;
        int grayVal = nVal * (255/n);
        return grayVal;
    }

    public BufferedImage increaseContrast(BufferedImage image, float brightenFactor, int offset){
        RescaleOp op = new RescaleOp(brightenFactor, offset, null);
        return op.filter(image, image);
    }

    public int increaseContrastGray(int gray){
        double num = ((double)gray)/127;
        num *= num;
        return (int)(num*63);
    }
// 10 char



    public char grayToChar(int g){
        return charSet[(int)(((double)g/255)*(charSet.length-1))];
    }


    public void saveToClipBoard(String s){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection strSel = new StringSelection(s);
        clipboard.setContents(strSel, null);
    }

    public BufferedImage getImageFromPath(String path){
        BufferedImage image = null;
        File file = null;
        try
        {
            file = new File(path);
            image = ImageIO.read(file);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        return image;
    }
}
