package Controller;

import GUI.UserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeController {
    private Shape shape;
    private UserInterface ui;

    public ShapeController(Shape shape, UserInterface ui) {
        this.shape = shape;
        this.ui = ui;
    }

    public void addActionListeners(){

        this.ui.getCalculateButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

    }

    public void newVorm(){

    }



}
