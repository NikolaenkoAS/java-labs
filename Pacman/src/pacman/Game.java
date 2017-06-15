package pacman;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.examples.scroller.Scroller;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Game {
    public static void main(String[] args) {
        try {
            AppGameContainer appgc;
            appgc= new AppGameContainer(new Pacman("A pacman game"));
            appgc.setDisplayMode(581, 600, false);
            appgc.setIcon("images/icon.png");
            appgc.start();
        } catch (SlickException ex) {
            Logger.getLogger(Pacman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
