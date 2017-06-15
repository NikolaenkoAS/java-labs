package pacman;

public class Player{
    private int x = 14;
    private int y = 18;
    private Pacman parent;

    public Player(Pacman parent) {
        this.parent = parent;
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

        CellType[][] area = parent.getArea();
        CellType next = area[x + dx][y + dy];

        switch (next) {
            case WALL:
                break;
            case EMPTY:
                area[x + dx][y + dy] = CellType.PLAYER;
                area[x][y] = CellType.EMPTY;
                x += dx;
                y += dy;
                break;
            case GHOST:
                parent.setLives(parent.getLives() - 1);
                parent.setDie(true);
                break;
            case PELLET:
                area[x + dx][y + dy] = CellType.PLAYER;
                area[x][y] = CellType.EMPTY;
                x += dx;
                y += dy;
                parent.setScore(parent.getScore() + 10);
                break;

        }
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setInitialCoords() {
        x = 14;
        y = 18;
    }
}