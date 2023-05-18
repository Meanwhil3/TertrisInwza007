import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Popo implements ActionListener {
    private int numPlayers;
    private JFrame frame;
    private JPanel panel,p2;
    private JButton button;
    private JTextField textField;
    private JLabel label;
    private Window window;

    Popo() {
        frame = new JFrame();
        button = new JButton("ENTER");
        textField = new JTextField(10);
        panel = new JPanel();
        p2 = new JPanel();
        label = new JLabel("HOW MANY PLAYERS");

        panel.setLayout(new FlowLayout());
        frame.setLayout(new GridLayout(2, 1));
        panel.add(label);
        panel.add(textField);
        frame.add(panel);
        frame.add(p2);
        p2.add(button);

        button.setBackground(Color.WHITE);
        button.setForeground(Color.RED);
        button.setFocusPainted(false);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(button)) {
            if (textField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "ENTER NUMBER");
            } else {
                setNumPlayers(Integer.parseInt(textField.getText()));
                textField.setText("");
                window = new Window(numPlayers);
                frame.dispose();
            }
        }
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }
}