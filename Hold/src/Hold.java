import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Hold implements KeyListener{
    private int holds;////keb kar hold 
    JFrame f1;
    private String canhold= "UNLOCK";
    private boolean isholding = false;
    private JLabel b1,b2,b3,b4,b5,b6,b7,holding,holdingaa,using,lock;

    public int getHolds() {
        return holds;
    }

    public void setHolds(int holds) {
        this.holds = holds;
    }
    Random random = new Random();
    JPanel p1,p2;
    int x[] = new  int[7];///que tung 7 que tor tor gun
    
    ImageIcon jblock = new ImageIcon("C:\\Users\\pobro\\Documents\\NetBeansProjects\\Hold\\src\\images.png"); 
    ImageIcon dblock = new ImageIcon("C:\\Users\\pobro\\Documents\\NetBeansProjects\\Hold\\src\\Lblockp.png");
    ImageIcon oblock = new ImageIcon("C:\\Users\\pobro\\Documents\\NetBeansProjects\\Hold\\src\\OBlock.png"); 
    ImageIcon zblock = new ImageIcon("C:\\Users\\pobro\\Documents\\NetBeansProjects\\Hold\\src\\images (3).png"); 
    ImageIcon  sblock = new ImageIcon("C:\\Users\\pobro\\Documents\\NetBeansProjects\\Hold\\src\\images (2).png");
    Hold(){
        f1 = new JFrame("test");
        b1 = new JLabel();
        b2 = new JLabel();
        b3 = new JLabel();
        b4 = new JLabel();
        b5 = new JLabel();
        b6 = new JLabel();
        b7 = new JLabel();
        p1 = new JPanel();
        p2 = new JPanel();
        lock = new JLabel("UnLock");
        using = new JLabel("USING");
        holding = new JLabel("Holding");
        holdingaa = new JLabel();
        p1.setLayout(new GridLayout(1,3));
        p1.add(lock);
        p1.add(holding);
        p2.setLayout(new GridLayout(1,2));
        p1.add(holdingaa);
        f1.setLayout(new GridLayout(8,1));
        p2.add(using);
        p2.add(b1);
        f1.add(p2);f1.add(b2);f1.add(b3);f1.add(b4);f1.add(b5);f1.add(b6);f1.add(b7);f1.add(p1);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setSize(1000,1000);
        f1.addKeyListener(this);
        f1.setFocusable(true);
        generate();
        check();
    }
    public void generate(){///long chey chey deaw pai chai rabob tung
        x[0] = random.nextInt(1,6);
        x[1] = random.nextInt(1,6);
        x[2] = random.nextInt(1,6);
        x[3] = random.nextInt(1,6);
        x[4] = random.nextInt(1,6);
        x[5] = random.nextInt(1,6);
        x[6] = random.nextInt(1,6);
        System.out.println(x[0]);
        System.out.println(x[1]);
        System.out.println(x[2]);
        System.out.println(x[3]);
        System.out.println(x[4]);
        System.out.println(x[5]);
        System.out.println(x[6]);
    }
    public void change() {
    for (int i = 0; i < 6; i++) {
        x[i] = x[i + 1];
    }
    x[6] = random.nextInt(1, 6);
    System.out.println(x[0]);
    this.isholding = false;
    this.canhold = "UNLOCK";
    lock.setText("UNLOCK");
    }
    public void check(){//////wai update nartar block vela don plean tum loop maigeng loey chai if else :O
        
        if (x[0]== 1){
            b1.setIcon(jblock);
        }
        else if(x[0]==2){
            b1.setIcon(dblock);
        }
        else if(x[0]==3){
            b1.setIcon(oblock);
        }
        else if(x[0]==4){
            b1.setIcon(zblock);
        }
        else if(x[0]==5){
            b1.setIcon(sblock);
        }
        if (x[1]== 1){
            b2.setIcon(jblock);
        }
        else if(x[1]==2){
            b2.setIcon(dblock);
        }
        else if(x[1]==3){
            b2.setIcon(oblock);
        }
        else if(x[1]==4){
            b2.setIcon(zblock);
        }
        else if(x[1]==5){
            b2.setIcon(sblock);
        }
        if (x[2]== 1){
            b3.setIcon(jblock);
        }
        else if(x[2]==2){
            b3.setIcon(dblock);
        }
        else if(x[2]==3){
            b3.setIcon(oblock);
        }
        else if(x[2]==4){
            b3.setIcon(zblock);
        }
        else if(x[2]==5){
            b3.setIcon(sblock);
        }
        ////
        if (x[3]== 1){
            b4.setIcon(jblock);
        }
        else if(x[3]==2){
            b4.setIcon(dblock);
        }
        else if(x[3]==3){
            b4.setIcon(oblock);
        }
        else if(x[3]==4){
            b4.setIcon(zblock);
        }
        else if(x[3]==5){
            b4.setIcon(sblock);
        }
        ////
        if (x[4]== 1){
            b5.setIcon(jblock);
        }
        else if(x[4]==2){
            b5.setIcon(dblock);
        }
        else if(x[4]==3){
            b5.setIcon(oblock);
        }
        else if(x[4]==4){
            b5.setIcon(zblock);
        }
        else if(x[4]==5){
            b5.setIcon(sblock);
        }
        /////
        if (x[5]== 1){
            b6.setIcon(jblock);
        }
        else if(x[5]==2){
            b6.setIcon(dblock);
        }
        else if(x[5]==3){
            b6.setIcon(oblock);
        }
        else if(x[5]==4){
            b6.setIcon(zblock);
        }
        else if(x[5]==5){
            b6.setIcon(sblock);
        }
        /////
        if (x[6]== 1){
            b7.setIcon(jblock);
        }
        else if(x[6]==2){
            b7.setIcon(dblock);
        }
        else if(x[6]==3){
            b7.setIcon(oblock);
        }
        else if(x[6]==4){
            b7.setIcon(zblock);
        }
        else if(x[6]==5){
            b7.setIcon(sblock);
        }
        //////
         if (this.holds == 1){
            holdingaa.setIcon(jblock);
        }
        else if(this.holds==2){
            holdingaa.setIcon(dblock);
        }
        else if(this.holds==3){
            holdingaa.setIcon(oblock);
        }
        else if(this.holds==4){
            holdingaa.setIcon(zblock);
        }
        else if(this.holds==5){
            holdingaa.setIcon(sblock);
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
         int keyCode = e.getKeyCode();
         if (keyCode == KeyEvent.VK_A) {
                System.out.println("A key pressed");
         }
         if (keyCode == KeyEvent.VK_S) {
                System.out.println("s key pressed");
         }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode(); ////// god a len job 1 tar bab block long mar jon sood
         if (keyCode == KeyEvent.VK_A) {
                System.out.println("CHANGING");
                change();
                check();
         }
         if (keyCode == KeyEvent.VK_S) {//////tar god s 
             if(holds==0&&isholding == false&&this.canhold =="UNLOCK"){///bab young mai mee hold 
                System.out.println("HOLDING");
                this.holds = x[0];////aow block x[0] ma law 
                change();//kayub kun 1
                check();//update block
                this.isholding = true;//set kar
                this.canhold = "LOCKED";//ser kar
                lock.setText("LOCKED");
             }
             else if(isholding == true&&this.canhold =="LOCKED"){// tar done lock yuu ja plean block maidai
                 System.out.println("cannot do");
                 JOptionPane.showMessageDialog(null, "maidai");
             }
             else if(holds>0&&this.canhold == "UNLOCK"){/// hlung jark hold ja plean block kub current yang deaw mai mee update
                 int temp  = x[0];
                 x[0] = temp;
                 x[0] = holds;
                 holds= temp;
                this.isholding = true;
                this.canhold = "LOCKED";
                lock.setText("LOCKED");
                check();
                 
             }
         }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    
    
    
    
}
