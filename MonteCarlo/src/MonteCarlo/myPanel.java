package MonteCarlo;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class myPanel extends JPanel {
    public myPanel() {
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Color myColor = new Color(0.75F, 0.0F, 0.75F);
        g2.setColor(myColor);

        Rectangle2D myRectangle = new Rectangle2D.Double(25.0, 25.0, 265.0, 265.0);
        g2.draw(myRectangle);

        double dotX, dotY;
        Ellipse2D.Double myDot;

        for (int i = 0; i < 265; i++) {
            dotX = (25.0 + i);
            dotY = 290.0 - (i * i) / 265.0;
            myDot = new Ellipse2D.Double(dotX, dotY, 1.0, 1.0);
            g2.draw(myDot);
        }

        double randX = 0, randY = 0, circleX = 0, circleY = 0;
        int trials = 1000, count = 0;
        Ellipse2D.Double myCircle;

        Random myRandomGenerator = new Random();
        g2.setColor(Color.blue);

        for (int i = 1; i <= trials; i++) {
            randX = myRandomGenerator.nextDouble();
            randY = myRandomGenerator.nextDouble();

            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                System.out.println(" Ошибка :" + e);
            }

            circleX = 25.0 + randX * 265.0 - 5.0;

            if (circleX > 280.0) circleX = 280.0;
            if (circleX < 25.0) circleX = 25.0;

            circleY = 290.0 - (randY * 265.0) - 5.0;
            if (circleY > 280.0) circleY = 280.0;
            if (circleY < 25.0) circleY = 25.0;


            myCircle = new Ellipse2D.Double(circleX, circleY, 10, 10);

            if (randY <= randX * randX) {
                count++;
                g2.fill(myCircle);
            } else {
                g2.draw(myCircle);
            }
        }
        double area;
        area = (double) count / (double) trials;
        g2.drawString("Процент точек под кривой составляет " + area, 25, 15);


    }
}