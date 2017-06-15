package pacman;

import org.newdawn.slick.*;


public class Pacman extends BasicGame {
    private final int CELL_SIZE = 20;
    private final int A_HEIGHT = 29;
    private final int A_WIDTH = 29;
    public CellType[][] area = new CellType[A_WIDTH][A_HEIGHT];
    private int score = 0;
    private int lives = 3;
    private int timeout = 0;

    private Ghost ghost1;
    private Ghost ghost2;
    private Ghost ghost3;

    private Animation heroAnim;
    private Animation ghostAnim;
    private Animation dyingAnim;
    private boolean started = false;
    private Player player = new Player(this);
    private Input input;
    private boolean win;
    private boolean gameOver;
    private boolean die = false;

    public Pacman(String gamename) throws SlickException {
        super(gamename);
    }


    @Override
    public void init(GameContainer gc) throws SlickException {
        generateLevel();
        heroAnim = new Animation(new SpriteSheet("./images/hero.png", 20, 20), 80);
        heroAnim.setLooping(true);

        ghostAnim = new Animation(new SpriteSheet("./images/ghost.png", 20, 20), 200);
        ghostAnim.setLooping(true);

        dyingAnim = new Animation(new SpriteSheet("./images/dying.png", 20, 20), 150);

        input = gc.getInput();

    }

    public void initGhosts(){
        ghost1 = new Ghost(13, 14, this);
        ghost2 = new Ghost(14, 14, this);
        ghost3 = new Ghost(15, 14, this);
    }
    @Override
    public void keyPressed(int key, char c) {
        super.keyPressed(key, c);
        if (gameOver || win) {
            startNewGame();
        } else if (!started) {
            initGhosts();
            ghost2.start();
            ghost3.start();
            ghost1.start();
            started = true;
        }

    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        input = gc.getInput();
        if (timeout > 150) {
            if (input.isKeyDown(Input.KEY_UP)) {
                rotateAnim(heroAnim, -90);
                player.move(Direction.UP);
            }
            if (input.isKeyDown(Input.KEY_DOWN)) {
                rotateAnim(heroAnim, 90);
                player.move(Direction.DOWN);
            }
            if (input.isKeyDown(Input.KEY_LEFT)) {
                rotateAnim(heroAnim, 180);
                player.move(Direction.LEFT);
            }
            if (input.isKeyDown(Input.KEY_RIGHT)) {
                rotateAnim(heroAnim, 0);
                player.move(Direction.RIGHT);
            }

            timeout = 0;
        }
        timeout += i;

        if (die) {
            ghost1.interrupt();
            ghost2.interrupt();
            ghost3.interrupt();
            startNewGame();

            gc.sleep(1000);
        }
        win = score == 417 * 10;
        gameOver = lives <= 0;
    }

    private void startNewGame() {
        if (gameOver) {
            score = 0;
            lives = 3;
        }
        generateLevel();
        player.setInitialCoords();
        ghost1.setInitialCoords();
        ghost2.setInitialCoords();
        ghost3.setInitialCoords();
        rotateAnim(heroAnim, 0);
        started = false;
        die = false;
        win = false;
        gameOver = false;
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        if (win)
            g.drawImage(new Image("./images/winScreen.png"), 0, 0);
        else if (gameOver)
            g.drawImage(new Image("./images/gameOver.png"), 0, 0);
        else {
            CellType currentCell;

            for (int i = 0; i < A_WIDTH; i++) {
                for (int j = 0; j < A_HEIGHT; j++) {
                    currentCell = area[i][j];

                    switch (currentCell) {
                        case WALL: {
                            g.setColor(Color.blue);
                            g.fillRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                            break;
                        }
                        case PELLET: {
                            g.setColor(Color.yellow);
                            g.fillOval(i * CELL_SIZE + 7, j * CELL_SIZE + 7, 7, 7);
                            break;
                        }
                        case PLAYER: {
                            heroAnim.draw(i * CELL_SIZE, j * CELL_SIZE);
                            break;
                        }
                        case GHOST: {
                            ghostAnim.draw(i * CELL_SIZE, j * CELL_SIZE);
                            break;
                        }
                    }
                }
            }

            g.setColor(Color.orange);
            g.drawString("Score: ".concat(Integer.toString(score)), 0, A_HEIGHT * CELL_SIZE);
            g.drawString("Lives: ".concat(Integer.toString(lives)), A_WIDTH * CELL_SIZE - 75,
                    A_HEIGHT * CELL_SIZE);

            if (!started)
                g.drawString("Press any key to start.", 190, 240);
        }
    }


    private void generateLevel() {
        int i, j;
        for (i = 0; i < A_WIDTH; i++) {
            for (j = 0; j < A_HEIGHT; j++) {
                area[i][j] = CellType.EMPTY;
            }
        }
        //создать стены по бокам
        for (i = 0; i < A_WIDTH; i++) {
            area[i][0] = CellType.WALL;
            area[i][A_HEIGHT - 1] = CellType.WALL;
            area[A_WIDTH - 1][i] = CellType.WALL;
            area[0][i] = CellType.WALL;
        }

        //сделать клетку для приведений
        final int leftCellBound = 10;
        final int rightCellBound = 18;
        final int topCellBound = 11;
        final int botCellBound = 17;


        for (i = leftCellBound; i <= rightCellBound; i++) {
            if (i != leftCellBound + 4) {
                area[i][topCellBound] = CellType.WALL;
                area[i][botCellBound] = CellType.WALL;
            }
        }

        for (i = topCellBound + 1; i < botCellBound; i++) {
            if (i != topCellBound + 3) {
                area[leftCellBound][i] = CellType.WALL;
                area[rightCellBound][i] = CellType.WALL;
            }
        }

        for (i = leftCellBound + 2; i < rightCellBound - 1; i++) {

            if (i != leftCellBound + 4) {
                area[i][topCellBound + 2] = CellType.WALL;
            }
            area[i][botCellBound - 2] = CellType.WALL;

        }

        area[leftCellBound + 2][topCellBound + 3] = CellType.WALL;
        area[rightCellBound - 2][topCellBound + 3] = CellType.WALL;

        //сгенерировать четверть карты вручную
        for (i = 2; i < 14; i++) {
            if (!(i == 5 || i == 11))
                area[i][2] = CellType.WALL;

            if (i == 2 || i == 8 || i == 13)
                area[i][3] = CellType.WALL;

            if (!(i == 3 || i == 5 || i == 10 || i == 12))
                area[i][6] = CellType.WALL;

            if (i == 2 || i == 11 || i == 13)
                area[i][7] = CellType.WALL;

            if (!(i == 3 || i == 9 || i == 12))
                area[i][8] = CellType.WALL;
        }

        for (i = 4; i < 14; i++)
            if (i == 4 || i == 10 || i == 11 || i == 13)
                area[i][9] = CellType.WALL;

        for (i = 2; i < 12; i++)
            if (!(i == 3 || i == 7 || i == 9))
                area[i][4] = CellType.WALL;

        for (i = 4; i < 14; i++)
            if (i == 4 || i == 11 || i == 13)
                area[i][5] = CellType.WALL;

        for (i = 2; i < 9; i++) {
            if (i % 2 == 0) {
                area[i][10] = CellType.WALL;
                area[i][11] = CellType.WALL;
            }

            if (i != 3)
                area[i][13] = CellType.WALL;
        }
        area[2][12] = CellType.WALL;

        //Скопировать остальные четверти
        for (i = 2; i < 14; i++) {
            for (j = 2; j < A_HEIGHT - 1; j++) {
                area[A_WIDTH - i - 1][j] = area[i][j];
                area[i][A_HEIGHT - j - 1] = area[i][j];
            }
        }

        for (i = 1; i < A_WIDTH - 1; i++)
            for (j = 1; j < A_HEIGHT - 1; j++)
                if ((i < 10 || j < 11) || (i > 18 || j > 17))
                    if (area[i][j] == CellType.EMPTY)
                        area[i][j] = CellType.PELLET;

        area[14][18] = CellType.PLAYER;

        area[13][14] = CellType.GHOST;
        area[14][14] = CellType.GHOST;
        area[15][14] = CellType.GHOST;
    }

    private void rotateAnim(Animation anim, int angle) {
        for (int i = 0; i < anim.getFrameCount(); i++)
            anim.getImage(i).setRotation(angle);
    }

    public CellType[][] getArea() {
        return area;
    }

    public void setArea(CellType[][] area) {
        this.area = area;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setDie(boolean die) {
        this.die = die;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isDie() {
        return die;
    }
}
