package TetrisPJ;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.*;

public class GamePanel extends Panel implements KeyListener {
    private static final long serialVersionUID = 2L;

    // Attribute for double buffered display
    private BufferedImage bi;
    private Graphics gi;

    private Dimension dim;
    private final Color background = Color.BLACK;

    // Attribute represent the number of players
    private int numOfPlayers;

    // left and right portions of the panel
    Tetris[] screens;

    private BufferedReader br;
    private int [][] key;
    GamePanel (int numbOfPlayers) {
        this.numOfPlayers = numOfPlayers;
        key = new int[numOfPlayers][6];
        screens = new Tetris[numOfPlayers];
        try {
            br = new BufferedReader(new FileReader("INPUT"));
            for (int i = 0; i < numOfPlayers; i++)
                for (int j = 0; j < 6; j++)
                    key[i][j] = Integer.parseInt(br.readLine().trim());
        }
        addKeyListener(this);
        for (int i = 0; i < numOfPlayers; i++)
            screens[i] = new Tetris(400*i, 0, this, i);
    }
    public void paint (Graphics g) {
        dim = getSize();
        bi = new BufferedImage(dim.width, dim.height, BufferedImage.TYPE_INT_RGB);
        gi = bi.getGraphics();
        update(g);
    }

    public void update (Graphics g) {
        gi.setColor(background);
        gi.fillRect(0, 0, dim.width, dim.height);
        for (int i = 0; i < numOfPlayers; i++) {
            if (screens[i] == null)
                continue
            screens[i].displayGrid(gi);
            screens[i].displayPieces(gi);
            screens[i].displayUI(gi);
        }
        g.drawImage(bi, 0, 0, this);
    }

    @Override
    public void keyTyped (KeyEvent e) {}
    @Override
    public void keyReleased (KeyEvent e) {
        for (int i = 0; i < numOfPlayers; i++) {
            for (int j = 0; j < 6; j++) {
                if (e.getKeyCode() == key[i][j]) {
                    if (screens[i].curr == null)
                        break;
                    if (j == 3)
                        screens[i].delay = (screens[i].level >= 20 ? Tetris.GLOBAL_DELAY[19] : Tetros.GLOBAL_DELAY[screens[i].level]);
                }
            }
        }
    }
    @Override
    public void keyPressed (KeyEvent e) {
        // user input
        // three case that handle when user adjusts the game states (ACTIVE, PAUSEd, CLOSED)
        if (e.getKeyCode() == KeyEvent.VK_P) {
            boolean currentState = screens[0].isPaused;
            for (int i = 0; i < numOfPlayers; i++)
                screens[i].isPaused = !currentState;
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        } else if (e.getKeyCode() == KeyEvent.VK_R) {
            for (int i = 0; i < numOfPlayers; i++)
                screens[i].restart();
            repaint();
            return;
        }
        if (screens[0].isPaused || screens[0].isGameOver)
            return;
        int keyCode = e.getKeyCode();
        for (int i = 0; i < numOfPlayers; i++) {
            for (int j = 0; j < 6; j++) {
                if (keyCode == key[i][j]) {
                    if (screens[i].curr == null)
                        break;
                    switch (j) {
                        case 0:
                            screens[i].movePiece(0, -1);
                            repaint();
                            break;
                        case 1:
                            screens[i].movePiece(0, 1);
                        case 2:
                            screens[i].rotateRight();
                            break;
                        case 3:
                            screens[i].rotateLeft();
                            break;
                        case 4:
                            screens[i].delay = (screens[i].level >= 20 ? Tetris.GLOBAL_DELAY[19] : Tetris.GLOBAL_DELAY[screens[i].level])/9;
                        case 5:
                            if (screens[i].isHolding)
                                break;
                            if (screens[i].holdId == 0) {
                                screens[i].holdId = screens[i].curr.id;
                                screens[i].curr = null;
                            } else {
                                int temp = screens[i].holdId;
                                screens[i].holdId = screens[i].curr.id;
                                screens[i].curr = screens[i].p.getActive(temp-1);
                            }
                            screens[i].isHolding = true;
                            screens[i].time = 1 << 30;
                            break;
                        case 6:
                            screens[i].time = 1 << 30;
                            screens[i].lockTime = 1 << 30;
                            while(screens[i].movePiece(1, 0));
                            break;
                    }
                }
            }
        }
        repaint();
    }

    protected void setGameOver() {
        for (int i = 0; i < numOfPlayers; i++)
            screens[i].isGameOver = true;
    }

    protected void sendGarbage (int id, int send) {
        if (numOfPlayers == 1)
            return;
        int rand = (int)(Math.random()*(numOfPlayers - 1));
        if (rand >= id)
            rand++;
        screens[rand].addGarbage(send);
    }

}
