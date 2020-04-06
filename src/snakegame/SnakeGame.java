
package snakegame;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Vijay
 */
public class SnakeGame {

    
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        
        frame.setBounds(100, 100, 905, 700);
        frame.setBackground(Color.yellow);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
