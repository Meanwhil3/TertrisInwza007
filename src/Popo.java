import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Popo implements ActionListener {
    private JFrame frame;
    private JPanel p1,p2,p3,p4;
    private JButton b1,b2;
    private JTextField textField;
    private JLabel lt,lh;
    private Window window;

    Popo() {
        frame = new JFrame();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        lt = new JLabel("TETRIS");
        lh = new JLabel("HOW MANY PLAYER");
        b1 = new JButton("1");
        b2 = new JButton("2");
        p4 = new JPanel();
        p1.add(lt);
        p2.add(lh);
        p3.add(b1);p3.add(b2);
        // toktang
        p1.setBackground(Color.BLACK);
        p2.setBackground(Color.BLACK);
        p3.setBackground(Color.BLACK);
        p4.setBackground(Color.BLACK);
        lt.setForeground(Color.WHITE);
        lh.setForeground(Color.WHITE);
        lh.setFont(new Font("Verdana", Font.BOLD, 24));
        lt.setFont(new Font("Verdana", Font.BOLD, 35));
        p1.setLayout(new FlowLayout());
        p2.setLayout(new FlowLayout());
        p3.setLayout(new FlowLayout());
        b1.setPreferredSize(new Dimension(75, 50));
        b2.setPreferredSize(new Dimension(75, 50));
        b1.setFocusable(false);
        b2.setFocusable(false);
        b1.setFont(new Font("Verdana", Font.BOLD, 15));
        b2.setFont(new Font("Verdana", Font.BOLD, 15));
        b1.setForeground(Color.BLACK);
        b2.setForeground(Color.BLACK);
        b1.setBackground(Color.WHITE);
        b2.setBackground(Color.WHITE);
        frame.setLayout(new GridLayout(4,1));
        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.add(p4);
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(b1)) {
            window = new Window(1);
                frame.dispose();
        }
        if (e.getSource().equals(b2)) {
            window = new Window(2);
                frame.dispose();
        }
    }
}