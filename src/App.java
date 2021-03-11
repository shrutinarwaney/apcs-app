import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.Math;

public class App extends JFrame {
    private JPanel panel;
    private JLabel text;
    private JButton calculate, clear;
    private Scanner fScan;
    
    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(() -> {
            App app = new App();
            app.setVisible(true);
        }); 
    }
    
    public App(){
        setTitle("Shrulenzie's Awesome Everything Calculator");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        text = new JLabel("Welcome! Select a calculator to start!", SwingConstants.CENTER);
        text.setFont(new Font("Sans-serif", Font.BOLD, 20));
        text.setBounds(0, 15, getBounds().width,100);
        panel.add(text);

    }

    public static void kinematic() {

    }

    public static void dna() {

    }

    public static void history() {
        
    }
    
}
