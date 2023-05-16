package TetrisPJ;

import java.awt.*;
import java.util.*;
public class Tetris {
    
    // grid of color ids that stores what kind of block is where
    private int[][] grid = new int[22][10];

    // Dimensions of the frame
    private final int panelR, panelC;

    // Big panel
    private final GamePanel panel;

    // The delay balues for levels: array index corresponds to level. After level 20 the delay remains consistent
    protected static final int[] GLOBAL_DELAY = {800,720,630,550,470,380,300,220,130,100,80,80,80,70,70,70,30,30,30,20};

    // The global delay lock value
    private final int GLOBAL_LOCK = 1000;

    //Color for different type of blocks
    //light gray, yellow, cyan, blue, orange, green, red, magenta
    //empty square, O, I, L, J, S, Z, T in order
    private static final Color[] c = {Color.LIGHT_GRAY, Color.YELLOW, Color.CYAN, Color.BLUE, Color.ORANGE, Color.GREEN, Color.RED, Color.MAGENTA, Color.DARK_GRAY};
    private static final Color ghostColor = Color.DARK_GRAY;
    private static final Color UIColor = Color.LIGHT_GRAY;

    // Kick case for J L S T Z blocks
    private static final int[][] move1 = {{0, -1, -1, 0, -1},
        {0, +1, +1, 0, +1},
        {0, +1, +1, 0, +1},
        {0, +1, +1, 0, +1},
        {0, +1, +1, 0, +1},
        {0, +1, +1, 0, +1},
        {0, -1, -1, 0, -1},
        {0, -1, -1, 0, -1},
        {0, -1, -1, 0, -1}};
    private static final int[][] mover1 = {{0, 0, +1, 0, -2},
        {0, 0, +1, 0, -2},
        {0, 0, -1, 0, +2},
        {0, 0, -1, 0, +2},
        {0, 0, +1, 0, -2},
        {0, 0, +1, 0, -2},
        {0, 0, -1, 0, +2},
        {0, 0, -1, 0, +2}};

    // Kick cases for I block
    private static final int[][] movec2 = {{0, -2, +1, -2, +1},
        {0, -1, +2, -1, +2},
        {0, -1, +2, -1, +2},
        {0, +2, -1, +2, -1},
        {0, +2, -1, +2, -1},
        {0, +1, -2, +1, -2},
        {0, +1, -2, +1, -2},
        {0, -2, +1, -2, +1}};
    private static final int[][] mover2 = {{0, 0, 0, -1, +2}, 
		{0, 0, 0, +2, -1},
		{0, 0, 0, +2, -1},
		{0, 0, 0, +1, -2},
		{0, 0, 0, +1, -2},
		{0, 0, 0, -2, +1},
		{0, 0, 0, -2, +1},
		{0, 0, 0, -1, +2}};

    // Handle the queue for pieces
    private Queue<Integer> bag = new ArrayDeque<Integer>();
    // Genereates the pieces
    protected Piece p = new Piece();
    // Represents the current active piece
    protected Piece.Active curr = null;
    //Represents the ID of the current screen
    private int id;

    // Attribute to manage hold function
    protected int holdId = 0;
    protected boolean isHolding = false;

    // Timing and level attribute
    protected int time = 0;
    protected int delay = GLOBAL_DELAY[0];
    protected int level = 0;
    protected int lockTime = 0;
    protected int linesCleared = 0;

    // Constants for UI
    private final int[] dy = {50, 100, 150, 200, 300};

    // Game state attribute
    protected boolean isPaused = false;
    protected boolean isGameOver = false;

    private int combo = 0;

    // Thread to manages the gravity of the pieces
    private Timer t = new Timer();
    private TimerTask move = new TimerTask() {
        @Override
        public void run () {
            // Checking the game states
            if (isPaused || isGameOver)
                return;
            
            // refill the bag if it is close to empty
            synchronized (bag) {
                if (bag.size() < 4)
                    for (int id : p.getPreview())
                        bag.offer(id);
            }
            
        }
    };


}   
