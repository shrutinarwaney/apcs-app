import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.Math;

public class App extends JFrame {
    private JPanel panel;
    private JLabel text;
    private JButton buttonDNA;
    private JButton buttonKin;
    private JButton buttonHis;

    private JPanel DNAPanel;

    private Scanner fScan;
    
    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(() -> {
            App app = new App();
            app.setVisible(true);
        }); 
    }
    
    public App() {
        setTitle("Shrulenzie's Science Calculator");
        setSize(1000,800);
        setLocationRelativeTo(null); // centers window on the screen
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        text = new JLabel("Choose a calculator", SwingConstants.CENTER);
        text.setFont(new Font("Sans-serif", Font.BOLD, 20));
        text.setBounds(0, 20, getBounds().width, 100); // sets coordinates on the app (x, y, width, height)
        panel.add(text);

        buttonDNA = new JButton("DNA Converter");
        buttonDNA.setBounds(getBounds().width / 2 - 100, 100, 200, 40); // same as this.getBounds()
        buttonDNA.addActionListener(new ActionListener() { // ActionListener is an interface that defines one function => actionPerformed()
           // Anonymous interface
            @Override 
            public void actionPerformed(ActionEvent e) {

            }
        });

        buttonKin = new JButton("Kinematic");
        buttonKin.setBounds(200, 100, 200, 40); // same as this.getBounds()
        buttonKin.addActionListener(new ActionListener() { // ActionListener is an interface that defines one function => actionPerformed()
           // Anonymous interface
            @Override 
            public void actionPerformed(ActionEvent e) {
                text.setText("You clicked the Kinematic button");
            }
        });

        buttonHis = new JButton("History");
        buttonHis.setBounds(600, 100, 200, 40); // same as this.getBounds()
        buttonHis.addActionListener(new ActionListener() { // ActionListener is an interface that defines one function => actionPerformed()
            @Override 
            public void actionPerformed(ActionEvent e) {
                text.setText("You clicked the History button");
            }
        });
        
        panel.add(buttonDNA);
        panel.add(buttonKin);
        panel.add(buttonHis);
    }

    public static void kinematic() {
        
    }

    public static void dna() {
        // DNA dna = new DNA( USERINPUTFIELD.getText() );
        // 
    }

    public static void history() {
        
    }
    
}
