package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface implements Runnable{
    private JFrame frame;
    private JFrame frame_db;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JButton button1;

    @Override
    public void run() {
        frame = new JFrame("Vorm Analyse Tool");
        frame_db = new JFrame("Vorm detail");
        frame.setPreferredSize(new Dimension(600, 400));
        frame_db.setPreferredSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame_db.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        createDetailBox(frame_db.getContentPane());
        frame.pack();
        frame_db.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container contentPane) {
        contentPane.setLayout(new BorderLayout(10,10));

        JTextArea output = new JTextArea();
        output.setPreferredSize(new Dimension(30,200));
        output.setEditable(false);
        JLabel inhoud = new JLabel();
        inhoud.setText("Totale inhoud: ");
        JButton clear = new JButton("Clear");

        String[] shapes = new String[] {"Kies een vorm", "Square", "Cuboid", "Sphere", "Cylinder", "Cone"};
        JComboBox<String> dropdown = new JComboBox<String>(shapes);
        dropdown.setBounds(90,91,262,43);
        dropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dropdown.getSelectedItem() != null){
                    Object item = dropdown.getSelectedItem();
                    output.setText("Gekozen voor " + item);
                    frame_db.setVisible(true);
                }
            }
        });

        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        displayPanel.add(output);
        displayPanel.add(inhoud);
        displayPanel.add(clear);

        contentPane.add(displayPanel,BorderLayout.CENTER);
        contentPane.add(dropdown,BorderLayout.WEST);
    }

    private void createDetailBox (Container detailBox) {
        detailBox.setLayout(new BorderLayout(10,10));
        JTextArea db_output = new JTextArea();
        db_output.setPreferredSize(new Dimension(30,200));
        db_output.setEditable(false);
        JLabel db_inhoud = new JLabel();
        db_inhoud.setText("Totale inhoud: ");
        JButton db_clear = new JButton("Clear");

        db_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame_db.setVisible(false);
                https://github.com/Manero88/VAT-Prof.git
            }
        });

        JPanel displayDB = new JPanel();
        displayDB.setLayout(new BoxLayout(displayDB, BoxLayout.Y_AXIS));
        displayDB.add(db_output);
        displayDB.add(db_inhoud);
        displayDB.add(db_clear);

        detailBox.add(displayDB,BorderLayout.CENTER);
    }
}
