package TetrisPJ;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Window extends JFrame {
    private static final long serialVersionUID = 1L;
    // private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // private StringTokenizer st;
    private int numOfPlayers;

    Window () {
        try {
            numOfPlayers = readInt();
            setTitle("Tetris plus");
            setSize(400*numOfPlayers, 600);
            setLocation(100, 100);
            setResizable(false);
            add(new GamePanel(numOfPlayers));
            setVisible(true);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input: enter a number", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Window () throws IOException {
    //     numOfPlayers = readInt();
    //     setTitle("Tetris plus");
    //     setSize(400*numOfPlayers, 600);
    //     setLocation(100, 100);
    //     setResizable(false);
    //     add(new GamePanel(numOfPlayers));
    //     setVisible(true);
    // }

    // private String next () throws IOException {
    //     while (st == null || !st.hasMoreTokens())
    //         st = new StringTokenizer(br.readLine().trim());
    //     return st.nextToken();
    // }

    private String next() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }


    private int readInt() throws IOException {
        return Integer.parseInt(next());
    }
    
}
