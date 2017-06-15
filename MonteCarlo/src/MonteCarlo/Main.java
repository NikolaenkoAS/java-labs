package MonteCarlo;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        myFrame mf = new myFrame();
        mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mf.setSize(400,400);
        mf.setTitle("Метод Монте-Карло");
        mf.setVisible(true);

    }
}
