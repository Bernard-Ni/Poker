
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import java.util.Random;

public class Main {
    private String[][] K;
    private int L;
    private String[] kartaKomputera;
    private String[] kartaGracza;
    private String TEMP;
    private JFrame frame = new JFrame();
    JButton buttonRozpocznij = new JButton();
    JButton buttonDodoajDoBanku = new JButton();
    private int BANK = 0;
    JLabel L1 = new JLabel();

    private Main() {

        frame.setTitle("Poker");
        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Losowanie kart:


        buttonRozpocznij.setText("Rozpocznij grę");
        buttonRozpocznij.setBounds(650, 10, 200, 30);
        frame.add(buttonRozpocznij);
        frame.setLocation(1000,100);
        buttonRozpocznij.setVisible(true);



        buttonRozpocznij.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                losowanieKart();
                System.out.println("TEST");

                buttonRozpocznij.setVisible(true);
            }
        });

        buttonDodoajDoBanku.setText("Dodaj do Banku $10");
        buttonDodoajDoBanku.setBounds(650, 40, 200, 30);
        frame.add(buttonDodoajDoBanku);
        frame.setLocation(1000,100);
        buttonDodoajDoBanku.setVisible(true);

        buttonDodoajDoBanku.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                BANK = BANK + 10;
                L1.setText("W banku jest $" + BANK);
            }
        });

        L1.setText("W banku jest $" + BANK);
        L1.setBounds(50, 230, 400, 30);
        frame.add(L1);
        frame.setVisible(true);


    }

    private void losowanieKart() {

        K = new String[33][2];
        kartaKomputera = new String[6];
        kartaGracza = new String[6];

        //Przypisanie Kart do Tablicy K[][]:
        int i = 1;
        for (int f = 7; f <= 14; f++) {
            String ff = String.valueOf(f);
                if (f < 10) {
                    ff = "0" + ff;
                }
            K[i][0] = ff + "_S"; K[i][1] = "nieużyta";
            K[i+1][0] = ff + "_K"; K[i+1][1] = "nieużyta";
            K[i+2][0] = ff + "_W"; K[i+2][1] = "nieużyta";
            K[i+3][0] = ff + "_P"; K[i+3][1] = "nieużyta";
            i = i + 4;
        }

        //---------------------------------------------------------------------------
        //Losowanie kart dla Komputera:
        for(int f = 1; f <= 5 ; f++) {
            losuj();
            kartaKomputera[f] = K[L][0];
        }

        //sortowanie kart dla Komputera:
        for (int g = 1; g < 5; g++) {
            for(int f = 5; f >= 2 ; f--) {
                if (Integer.valueOf(kartaKomputera[f].substring(0,2)) < Integer.valueOf(kartaKomputera[f-1].substring(0,2))) {
                    TEMP = kartaKomputera[f];
                    kartaKomputera[f] = kartaKomputera[f-1];
                    kartaKomputera[f-1] = TEMP;
                    kartaKomputera[f-1] = TEMP;
                }
            }
        }

        //Rysowanie kart dla Komputera:
        for(int f = 1; f <= 5 ; f++) {
            JPanel RysujKarte = new RysujKarte(120 * (f-1) + 20, 20, kartaKomputera[f]);
            frame.add(RysujKarte);
            frame.setVisible(true);
        }

        //---------------------------------------------------------------------------
        //Losowanie kart dla Gracza:
        for(int f = 1; f <= 5 ; f++) {
            losuj();
            kartaGracza[f] = K[L][0];
        }

        //sortowanie kart dla Gracza:
        for (int g = 1; g < 5; g++) {
            for(int f = 5; f >= 2 ; f--) {
                if (Integer.valueOf(kartaGracza[f].substring(0,2)) < Integer.valueOf(kartaGracza[f-1].substring(0,2))) {
                    TEMP = kartaGracza[f];
                    kartaGracza[f] = kartaGracza[f-1];
                    kartaGracza[f-1] = TEMP;
                    kartaGracza[f-1] = TEMP;
                }
            }
        }

        //Rysowanie kart dla Gracza:
        for(int f = 1; f <= 5 ; f++) {
            JPanel RysujKarte = new RysujKarte(120 * (f-1) + 20, 400, kartaGracza[f]);
            frame.add(RysujKarte);
            frame.setVisible(true);
        }
        //---------------------------------------------------------------------------




    }


//=====================================================================================================================
    private void losuj(){
        for (int losowanie = 1; losowanie < 32; losowanie++) {
            Random los = new Random();
            L = (int) (los.nextDouble() * 32) + 1;
            if (!K[L][1].equals("użyta")) {
                K[L][1] = "użyta";
                break;
            }
        }
    }

//=====================================================================================================================
    public static void main(String[] args) throws IOException {
        new Main();
    }

}
