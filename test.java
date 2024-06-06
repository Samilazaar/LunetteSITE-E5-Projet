import javax.swing.*;
import java.awt.*;


public class test {

    public static void main(String[] args) {
        JFrame fenetre = new JFrame("Mon Application de Bureau");

        ImageIcon imageIcon = new ImageIcon("logo.png");
        JLabel imageLabel = new JLabel(imageIcon);

        // Crée un JLabel avec un texte formaté
        JLabel etiquette = new JLabel("Hello, World!");
        
        // Configure la police et la taille du texte
        etiquette.setFont(new Font("Montserrat", Font.BOLD, 32));

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(etiquette);
        panel.add(imageLabel);

        fenetre.add(panel);

        fenetre.setSize(400, 300);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
        
    }
}