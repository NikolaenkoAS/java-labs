package pacman;

import java.util.Random;

public class Ghost extends Thread {
    private final int initialX;
    private final int initialY;
    private int x;
    private int y;


    private final Pacman parent;

    public Ghost(int initialX, int initialY, Pacman parent) {
        this.x = this.initialX = initialX;
        this.y = this.initialY = initialY;
        this.parent = parent;
    }

    public void setInitialCoords() {
        x = initialX;
        y = initialY;
    }

    public void move(int dir) {

        int dx = 0, dy = 0;
        switch (dir) {
            case Direction.LEFT:
                dx = -1;
                dy = 0;
                break;
            case Direction.RIGHT:
                dx = 1;
                dy = 0;
                break;
            case Direction.UP:
                dx = 0;
                dy = -1;
                break;
            case Direction.DOWN:
                dx = 0;
                dy = 1;
                break;
        }

        CellType next = parent.area[x + dx][y + dy];
        switch (next) {
            case WALL:
            case GHOST:
                break;
            case EMPTY:
                parent.area[x + dx][y + dy] = CellType.GHOST;
                parent.area[x][y] = CellType.EMPTY;
                x += dx;
                y += dy;
                break;
            case PLAYER:
                parent.setLives(parent.getLives() - 1);
                parent.setDie(true);
                break;
            case PELLET:
                parent.area[x + dx][y + dy] = CellType.GHOST;
                parent.area[x][y] = CellType.PELLET;
                x += dx;
                y += dy;
                break;

        }
    }

    @Override
    public void run() {
        while (!parent.isWin() && !parent.isGameOver() && !this.isInterrupted()) {
            int dir = new Random().nextInt(4);
            move(dir);


            try {
                Thread.sleep(70);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

}
