package MonteCarlo;

import javax.swing.*;
import java.awt.*;

public class myFrame extends JFrame {
    public myFrame() throws HeadlessException {
        setResizable(false);
        Container container = getContentPane();
        myPanel panel = new myPanel();
        container.add(panel);
    }
}
