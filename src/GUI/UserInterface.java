package GUI;

import ApplicationLogic.*;
import Controller.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author manerotapessur
 * @version 1.0
 */

public class UserInterface {
    /**
     * Initialiseer de componenten voor het eerste scherm van de UserInterface.
     */
    private JFrame window;
    private int WIDTH = 600, HEIGHT = 450;
    private JLabel volume, totalVolume;
    private JButton tVolume, save, load, delete, clear, calculate;
    private JList output;
    private JTextField volumetf, totalVolumetf;
    private JDialog newFormView;
    private DefaultListModel<String> outputList = new DefaultListModel<>();
    private double totVolume;
    private JComboBox<String> shape;


    public UserInterface(){
        this.startWindow();
    }

    public void addOutList(String cubeInfoString){
            this.outputList.addElement(cubeInfoString);
    }

    public double getTotalVol(){
            return totVolume;
    }



    public void startWindow(){
        /**
         * In de setWindow methode wordt het eerste scherm gevormd met alle velden en knoppen die hierin horen. (Voor extra vensters moet er een nieuwe methode bij komen.)
         */

        FlowLayout layout = new FlowLayout(0,20,20);
        this.window = new JFrame();
        this.window.setLayout(layout);

        window.setTitle("Vorm Analyse Tool");
        window.setBackground(new Color(128,128,128));
        window.setSize(WIDTH,HEIGHT);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        /**
         * Alles wat aan de linker kan van het scherm (startWindow) staat wordt ingevuld onder leftScreen JPanel.
         */

        JPanel leftScreen = new JPanel();
        leftScreen.setPreferredSize(new Dimension(200,350));
        leftScreen.setLayout(new FlowLayout(2, 20,20));

        // shape is een dropdown menu waar je een vorm kan kiezen
        String shapes[]={"Choose a shape", "Square", "Cuboid", "Sphere", "Cone", "Cylinder"};
        shape = new JComboBox<>(shapes);
        shape.setSize(1,1);
        leftScreen.add(shape);
        shape.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setShapeWindow(shape.getSelectedItem().toString());
            }
        });

        // Voeg de venster inhoud en totale inhoud inclusief labels aan het linker scherm toe.
        this.volume = new JLabel("Volume");
        this.volumetf = new JTextField(5);
        volumetf.setEditable(false);
        this.totalVolume = new JLabel("Total volume");
        this.totalVolumetf = new JTextField(5);
        totalVolumetf.setEditable(false);

        // Twee buttons op het linker paneel worden hieronder toegevoegd.
        this.save = new JButton("Save");
        this.load = new JButton("Load");

        leftScreen.add(volume);
        leftScreen.add(volumetf);
        leftScreen.add(totalVolume);
        leftScreen.add(totalVolumetf);
        leftScreen.add(save);
        leftScreen.add(load);

        //---Einde linker paneel-----//


        JPanel rightScreen = new JPanel();
        rightScreen.setPreferredSize(new Dimension(350,350));
        rightScreen.setLayout(new FlowLayout(2,15,20));

        this.output = new JList();
        output.setPreferredSize(new Dimension(350,200));
        output.setModel(outputList);

        this.tVolume = new JButton("Total volume");
        this.clear = new JButton("Clear");
        this.delete = new JButton("Delete");

        rightScreen.add(output);
        rightScreen.add(tVolume);
        rightScreen.add(clear);
        rightScreen.add(delete);

        //---Einde rechter paneel-----//

        window.add(leftScreen);
        window.add(rightScreen);

        tVolume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalVolumetf.setText(Double.toString(totVolume));
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputList.clear();
                totVolume = 0;
                totalVolumetf.setText("");
            }
        });



        //================================================================


        JLabel author = new JLabel("© Manero Tapessur 2019");
        author.setForeground(Color.gray);
        author.setFont(new Font("tahoma",Font.ITALIC,11));
        window.add(author,BorderLayout.PAGE_END);
        //================================================================


        window.setLayout(new FlowLayout());
        window.setVisible(true);
    }

    public String getSelectedShape(){
            return shape.getSelectedItem().toString();
    }

    public void setShapeWindow(String typeVorm){
        /**
         * setShapeWindow is een nieuw venster die zal openen zodra er een vorm in "dropdown" gekozen is. Deze zal, afhankelijk van de gekozen vorm, inputvelden hebben
         * waarmee de inhoud van de gekozen vorm berekend kan worden.
         */

        FlowLayout dialogLayout = new FlowLayout();

        this.newFormView = new JDialog();
        this.newFormView.setLayout(dialogLayout);
        newFormView.setSize(300,120);
        newFormView.setLocationRelativeTo(null);
        newFormView.setResizable(false);


        this.shapeContent(this.newFormView, typeVorm);
        newFormView.setVisible(true);

    }

    public JButton getCalculateButton(){
            return this.calculate;
    }


    private void shapeContent(JDialog newFormView, String selectedShape){
        /**
         * shapeContent kijkt welke vorm er in de JComboBox "dropdown" ingevuld is en zal vervolgens actie ondernemen.
         */

        JLabel length = new JLabel("Length");
        JTextField lengthtf = new JTextField(6);
        JLabel width = new JLabel("Width");
        JTextField widthtf = new JTextField(6);
        JLabel height = new JLabel("Height");
        JTextField heighttf = new JTextField(6);
        JLabel radius = new JLabel("Radius");
        JTextField radiustf = new JTextField(6);


         this.calculate = new JButton("Calculate");

        switch (selectedShape){

            case "Square": {

                newFormView.setTitle("Square");
                newFormView.add(length);
                newFormView.add(lengthtf);
                newFormView.add(width);
                newFormView.add(widthtf);
                newFormView.add(calculate);

                calculate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Square square = new Square(Double.parseDouble(lengthtf.getText()), Double.parseDouble(widthtf.getText()));
                        outputList.addElement(square.printInfo());
                        totVolume += square.getVolume();
                        newFormView.dispose();

                    }
                });

                break;
            }

            case "Cuboid": {

                newFormView.setTitle("Cuboid");
                newFormView.add(length);
                newFormView.add(lengthtf);
                newFormView.add(width);
                newFormView.add(widthtf);
                newFormView.add(height);
                newFormView.add(heighttf);
                newFormView.add(calculate);

                calculate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Shape cuboid = new Cuboid(Double.parseDouble(heighttf.getText()), Double.parseDouble(lengthtf.getText()), Double.parseDouble(widthtf.getText()));
                        outputList.addElement(cuboid.printInfo());
                        totVolume += cuboid.getVolume();
                        newFormView.dispose();
                    }
                });

                break;
            }

            case "Sphere": {

                newFormView.setTitle("Sphere");
                newFormView.add(radius);
                newFormView.add(radiustf);

                newFormView.add(calculate);

                calculate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Shape sphere = new Sphere(Double.parseDouble(radiustf.getText()));
                        outputList.addElement(sphere.printInfo());
                        totVolume += sphere.getVolume();
                        newFormView.dispose();

                    }
                });

                break;
            }

            case "Cone": {

                newFormView.setTitle("Cone");
                newFormView.add(radius);
                newFormView.add(radiustf);
                newFormView.add(height);
                newFormView.add(heighttf);
                newFormView.add(calculate);

                calculate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Shape cone = new Cone(Double.parseDouble(radiustf.getText()), Double.parseDouble(heighttf.getText()));
                        outputList.addElement(cone.printInfo());
                        totVolume += cone.getVolume();
                        newFormView.dispose();
                    }
                });

                break;
            }

            case "Cylinder": {

                newFormView.setTitle("Cone");
                newFormView.add(radius);
                newFormView.add(radiustf);
                newFormView.add(height);
                newFormView.add(heighttf);

                newFormView.add(calculate);

                calculate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Shape cylinder = new Cylinder(Double.parseDouble(radiustf.getText()), Double.parseDouble(heighttf.getText()));
                        outputList.addElement(cylinder.printInfo());
                        totVolume += cylinder.getVolume();
                        newFormView.dispose();
                    }
                });

                break;
            }

            default:
                newFormView.setTitle("No shape selected");
                newFormView.add(new JLabel("Please select a shape"));

        }
    }

}
