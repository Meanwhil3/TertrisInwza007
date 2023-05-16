package TetrisPJ;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private static final long serialVersionUID = 1L;
    // private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // private StringTokenizer st;
    private int numOfPlayers;

    Window () {
        JTextField inputField = new JTextField(10);
        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            try {
                numOfPlayers = Integer.parseInt(inputField.getText());
                // numOfPlayers = readInt();
            setTitle("Tetris plus");
            setSize(400*numOfPlayers, 600);
            setLocation(100, 100);
            setResizable(false);
            add(new GamePanel(numOfPlayers));
            setVisible(true);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input: enter a number", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        });
            
            JPanel mainPanel = new JPanel();
            mainPanel.add(new JLabel("Enter numer of players: "));
            mainPanel.add(inputField);
            mainPanel.add(startButton);
    
        // numOfPlayers = readInt();
        // setTitle("Tetris plus");
        // setSize(400*numOfPlayers, 600);
        // setLocation(100, 100);
        // setResizable(false);
        // add(new GamePanel(numOfPlayers));
        // setVisible(true);
    }

    // private String next () throws IOException {
    //     while (st == null || !st.hasMoreTokens())
    //         st = new StringTokenizer(br.readLine().trim());
    //     return st.nextToken();
    // }

    // private int readInt() throws IOException {
    //     return Integer.parseInt(next());
    // }
    
}
