
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
        
        frame.setBounds(10, 10, 905, 700);
        frame.setBackground(Color.gray);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setTitle("SNAKE_2D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GamePlay gp=new GamePlay();
        frame.add(gp);
        
        
    }
    
}
