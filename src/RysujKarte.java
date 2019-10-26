import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RysujKarte extends JPanel {

    private BufferedImage image;
    int x;
    int y;

    public RysujKarte(int x1 ,int y1, String Karta) {

        File imageFile = new File("out/production/Poker/Karty/"+Karta+".png");
        try {
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            System.err.println("Błąd odczytu");
            e.printStackTrace();
        }
        x = x1;
        y = y1;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, x, y, 113, 170, this);
    }

}