package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class MyFrame extends JFrame {

    private final JTextField farField = new JTextField();
    private final JTextField celsField = new JTextField();

    MyFrame(String title) {
        super(title);

        this.setSize(380, 120);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        farField.setColumns(23);
        celsField.setColumns(23);
        FocusListener fl = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (e.getComponent().equals(celsField))
                    farField.setText("");
                else
                    celsField.setText("");

                celsField.setBackground(Color.WHITE);
                farField.setBackground(Color.WHITE);

            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        };
        celsField.addFocusListener(fl);
        farField.addFocusListener(fl);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Celsius    ");
        panel.add(label);
        panel.add(celsField);
        JLabel label1 = new JLabel("Farenheit");
        panel.add(label1);
        panel.add(farField);

        JButton button = new JButton("Convert");
        button.addActionListener(e -> {
            if (farField.getText().equals("")) {
                outputInfo(celsField, farField);
            } else if (celsField.getText().equals("")) {
                outputInfo(farField, celsField);
            }
        });
        panel.add(button);

        getContentPane().add(panel);
    }

    private void outputInfo(JTextField fieldToGet, JTextField fieldToPut) {
        Color oldColor = Color.WHITE;
        Color errColor = new Color(0xe43235);
        double converted;

        try {
            converted = convert(Double.parseDouble(fieldToGet.getText()), fieldToGet.equals(celsField));
            fieldToGet.setBackground(oldColor);
            fieldToPut.setText(Double.toString(converted));
            fieldToGet.setText("");
        } catch (NumberFormatException e) {
            fieldToGet.setBackground(errColor);
        }
    }

    private double convert(double value, boolean toFarenheit) {
        if (toFarenheit)
            return (value - 32) / (5.0 / 9);
        else
            return (value / (9.0 / 5)) + 32;
    }
}
