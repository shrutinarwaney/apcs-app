import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.event.DocumentEvent;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.Math;
import java.io.*;

import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;
import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.TRAILING;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class App extends JFrame {
    private JFrame kinFrame;
    private JFrame dnaFrame;
    
    private JPanel panel;
    private JLabel text;
    private JButton buttonDNA;
    private JButton buttonKin;
    // private JButton buttonHis;

    private JPanel dnaPanel;
    private JTextField dnaField;
    private JTextField mrnaField;
    private JTextField compField;
    private JButton dnaConvertButton;
    private JLabel dnaLabel;
    private JLabel mrnaLabel;
    private JLabel compLabel;

    private JPanel kPanel;
    private JLabel viLabel;
    private JLabel vfLabel;
    private JLabel aLabel;
    private JLabel tLabel;
    private JTextField viField;
    private JTextField vfField;
    private JTextField aField;
    private JTextField tField;
    private JButton kCalcButton;
    
    private JPanel hPanel;

    private Scanner fScan;
    private File file;
    
    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(() -> {
            try {
                App app = new App();
                app.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }); 
    }
    
    public App() throws Exception {
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
                try {
                    panel.revalidate();
                    panel.repaint();
                    dna();
                    
                } catch( Exception ex ) {
                    ex.printStackTrace();
                }
                
            }
        });

        buttonKin = new JButton("Kinematic");
        buttonKin.setBounds(200, 100, 200, 40); // same as this.getBounds()
        buttonKin.addActionListener(new ActionListener() { // ActionListener is an interface that defines one function => actionPerformed()
            @Override 
            public void actionPerformed(ActionEvent e) {
                try {
                    panel.revalidate();
                    panel.repaint();
                    kinematic();
                } catch( Exception ex ) {
                    ex.printStackTrace();
                }
                
            }
        });

        // buttonHis = new JButton("History");
        // buttonHis.setBounds(600, 100, 200, 40); // same as this.getBounds()
        // buttonHis.addActionListener(new ActionListener() { // ActionListener is an interface that defines one function => actionPerformed()
        //     @Override 
        //     public void actionPerformed(ActionEvent e) {
        //         history();
        //     }
        // });
        
        panel.add(buttonDNA);
        panel.add(buttonKin);
        // panel.add(buttonHis);
    }

    public void kinematic() throws Exception {        
        int fullCount = 0;
       
        kinFrame = new JFrame();
        kPanel = new JPanel();
        kinFrame.setTitle("Kinematic Calculator");

        var gl = new GroupLayout(kPanel);

        kPanel.setLayout(gl);
        kinFrame.add(kPanel);
        kinFrame.setVisible(true);
        kinFrame.setSize(1000,800);
        kinFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        viLabel = new JLabel("Initial Velocity:");
        vfLabel = new JLabel("Final Velocity:");
        aLabel = new JLabel("Acceleration:");
        tLabel = new JLabel("Time:");

        viField = new JTextField(10);
        // viField.getDocument().addDocumentListener( new DocumentListener() { 
        //     public void changedUpdate( DocumentEvent e ) {
        //         if (!(vfField.getText().isEmpty() && aField.getText().isEmpty() && tField.getText().isEmpty())) {
        //             viField.setEditable(false);
        //             viField.setText("");
        //         }
        //     }

        //     public void removeUpdate( DocumentEvent e ) {
        //         if (!(vfField.getText().isEmpty() && aField.getText().isEmpty() && tField.getText().isEmpty())) {
        //             viField.setEditable(false);
        //             viField.setText("");
        //         }
        //     }

        //     public void insertUpdate( DocumentEvent e ) {
        //         if (!(vfField.getText().isEmpty() && aField.getText().isEmpty() && tField.getText().isEmpty())) {
        //             viField.setEditable(false);
        //             viField.setText("");
        //         }
        //     }

        // }
        // );
        // viField.addActionListener((e)-> {
        //     if (!(vfField.getText().isEmpty() && aField.getText().isEmpty() && tField.getText().isEmpty())) {
        //         viField.setEditable(false);
        //         viField.setText("");
        //     }
        // });
        vfField = new JTextField(10);
        aField = new JTextField(10);
        tField = new JTextField(10);
        kCalcButton = new JButton("Calculate");
        kCalcButton.addActionListener(new ActionListener() { // ActionListener is an interface that defines one function => actionPerformed()
            // Anonymous interface
             @Override 
             public void actionPerformed(ActionEvent e) {
                 // INSIDE SUBMIT ACTIONLISTENER
                boolean viEmpty = ( viField.getText().equals("") );
                boolean vfEmpty = ( vfField.getText().equals("") );
                boolean aEmpty = ( aField.getText().equals("") );
                boolean tEmpty = ( tField.getText().equals("") );
                
                Kinematic kinematic = new Kinematic( viField.getText(), vfField.getText(), aField.getText(), tField.getText(), viEmpty, vfEmpty, aEmpty, tEmpty );
                String[] kinematicResults = kinematic.calculate();
                
                viField.setText( kinematicResults[ 0 ] );
                vfField.setText( kinematicResults[ 1 ] );
                aField.setText( kinematicResults[ 2 ] );
                tField.setText( kinematicResults[ 3 ] );
                viField.setEditable(true);
                vfField.setEditable(true);
                aField.setEditable(true);
                tField.setEditable(true);
            };
        });

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup(TRAILING)
                        .addComponent(vfLabel)
                        .addComponent(viLabel)
                        .addComponent(aLabel)
                        .addComponent(tLabel))
                .addGroup(gl.createParallelGroup()
                        .addComponent(viField)
                        .addComponent(vfField)
                        .addComponent(aField)
                        .addComponent(tField))
                .addGroup(gl.createParallelGroup()
                         .addComponent(kCalcButton))  
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup(BASELINE)
                        .addComponent(vfLabel)
                        .addComponent(vfField)
                        .addComponent(kCalcButton))
                .addGroup(gl.createParallelGroup(BASELINE)
                        .addComponent(viLabel)
                        .addComponent(viField))
                .addGroup(gl.createParallelGroup(BASELINE)
                        .addComponent(aLabel)
                        .addComponent(aField))
                .addGroup(gl.createParallelGroup(BASELINE)
                        .addComponent(tLabel)
                        .addComponent(tField))
        );

        pack();
        
    }

    public void dna() throws Exception {       
        dnaFrame = new JFrame();
        dnaPanel = new JPanel();
        dnaFrame.setTitle("DNA Converter");

        var gl = new GroupLayout(dnaPanel);

        dnaPanel.setLayout(gl);
        dnaFrame.add(dnaPanel);
        dnaFrame.setVisible(true);
        dnaFrame.setSize(1000,800);
        dnaFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        dnaLabel = new JLabel("DNA:");
        mrnaLabel = new JLabel("mRNA:");
        compLabel = new JLabel("Complimentary DNA:");

        dnaField = new JTextField(10);
        mrnaField = new JTextField(10);
        mrnaField.setEditable(false);
        compField = new JTextField(10);
        compField.setEditable(false);
        dnaConvertButton = new JButton("Convert");
        
        dnaConvertButton.addActionListener(new ActionListener() { // ActionListener is an interface that defines one function => actionPerformed()
            // Anonymous interface
             @Override 
             public void actionPerformed(ActionEvent e) {
                DNA dna = new DNA( dnaField.getText() );
                String[] results = dna.calculate();
                dnaField.setText(results[0]);
                mrnaField.setText(results[1]);
                compField.setText(results[2]);

            };
        });

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup(TRAILING)
                        .addComponent(dnaLabel)
                        .addComponent(mrnaLabel)
                        .addComponent(compLabel))
                .addGroup(gl.createParallelGroup()
                        .addComponent(dnaField)
                        .addComponent(mrnaField)
                        .addComponent(compField))
                .addGroup(gl.createParallelGroup()
                         .addComponent(dnaConvertButton))  
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup(BASELINE)
                        .addComponent(dnaLabel)
                        .addComponent(dnaField)
                        .addComponent(dnaConvertButton))
                .addGroup(gl.createParallelGroup(BASELINE)
                        .addComponent(mrnaLabel)
                        .addComponent(mrnaField))
                .addGroup(gl.createParallelGroup(BASELINE)
                        .addComponent(compLabel)
                        .addComponent(compField))
        );

        pack();
    }

    public void history() {
        hPanel = new JPanel();
        hPanel.setLayout(null);
        add(hPanel);
    }
    
}
