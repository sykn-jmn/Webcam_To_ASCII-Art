import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Display extends JFrame {
    DrawPane panel;

    public void setASCII(char[][] ascii){
        panel.setASCII(ascii);
    }

    public Display(char[][] ascii){
        super("ASCII Camera");

        this.setSize(1010,800);
        this.setLocation(170,0);

        panel = new DrawPane(ascii);
        setContentPane(panel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    static class DrawPane extends JPanel{
        char[][] ascii;
        Font font;
        public DrawPane(char[][] ascii){
            this.ascii = ascii;
            this.repaint();
            font = new Font("Monospaced", Font.BOLD,10);
        }
        public void setASCII(char[][] ascii){
            this.ascii = ascii;
            this.repaint();
        }
        public void paintComponent(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRect(0,0,1400,1000);
            g.setColor(Color.BLACK);
            g.setFont(font);
            for(int y = 0; y <ascii[0].length; y++){
                for(int x = 0; x<ascii.length;x++){
                    g.drawString(""+ascii[x][y],x*Main.CHAR_SPACE,y*Main.CHAR_SPACE);
                }
            }
        }
    }
}
