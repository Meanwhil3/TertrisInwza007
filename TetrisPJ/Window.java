import java.awt.*;
import java.io.*;
import java.util.*;
public class Window extends Frame {
	private static final long serialVersionUID = -1324363758675184283L;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private StringTokenizer st;
	private int numOfPlayers;
        Window(int numOfPlayers){
            this.numOfPlayers = numOfPlayers;
            Window();
        }
	private void Window () {
                System.out.println(numOfPlayers);
		setTitle("Tetris");
		setSize(400*numOfPlayers, 600);
		setLocation(100, 100);
		setResizable(false);
		setVisible(true);
                add(new GamePanel(numOfPlayers));
	}
	private String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }
	private int readInt() throws IOException {
		return Integer.parseInt(next());
	}
}