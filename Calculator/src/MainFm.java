import javax.swing.*;
import java.awt.event.ActionListener;

public class MainFm extends JFrame {
    private JPanel panel1;
    private JTextField resultField;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton сButton;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a9Button;
    private JButton a8Button;
    private JButton a7Button;
    private JButton buttonEquals;
    private JButton a0Button;
    private JButton buttonPlus;
    private JButton buttonMinus;
    private JButton buttonMulti;
    private JButton buttonDiv;
    private JButton buttonPoint;
    String operation;
    private double value1 = 0, value2 = 0, result = 0;

    ActionListener numbersListener = e -> {
        if (resultField.getText().equals("0"))
            resultField.setText(e.getActionCommand());
        else
            resultField.setText(resultField.getText().concat(e.getActionCommand()));
    };

    ActionListener operationListener = e -> {
        operation = e.getActionCommand();
        value1 = Double.parseDouble(resultField.getText());
        resultField.setText("0");
    };

    ActionListener equalsListener = e -> {
        value2 = Double.parseDouble(resultField.getText());
        try {
            switch (operation) {
                case "+":
                    result = value1 + value2;
                    break;
                case "-":
                    result = value1 - value2;
                    break;
                case "*":
                    result = value1 * value2;
                    break;
                case "/":
                    if(value2 == 0) throw new ArithmeticException();
                    result = value1 / value2;
                    break;
            }
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, "Zero division error", "error", JOptionPane.ERROR_MESSAGE);
        }

        resultField.setText(Double.toString(result));
    };

    ActionListener cListener = e -> {
        String text = resultField.getText();
        if(text.length() == 1){
            resultField.setText("0");
        }else{
            resultField.setText(text.substring(0, text.length() - 1));
        }
    };

    ActionListener pointListener = e -> {
        String text = resultField.getText();

        if(!text.contains(".")){
            resultField.setText(text.concat("."));
        }
    };

    public MainFm() {
        a1Button.addActionListener(numbersListener);
        a2Button.addActionListener(numbersListener);
        a3Button.addActionListener(numbersListener);
        a4Button.addActionListener(numbersListener);
        a5Button.addActionListener(numbersListener);
        a6Button.addActionListener(numbersListener);
        a9Button.addActionListener(numbersListener);
        a8Button.addActionListener(numbersListener);
        a7Button.addActionListener(numbersListener);
        a0Button.addActionListener(numbersListener);
        buttonPlus.addActionListener(operationListener);
        buttonMinus.addActionListener(operationListener);
        buttonMulti.addActionListener(operationListener);
        buttonDiv.addActionListener(operationListener);
        buttonEquals.addActionListener(equalsListener);
        сButton.addActionListener(cListener);
        buttonPoint.addActionListener(pointListener);

        resultField.setText("0");
        resultField.setEditable(false);
        this.setContentPane(panel1);
        this.setSize(250, 250);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

}
