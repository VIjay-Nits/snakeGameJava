package snakegame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Vijay
 */
public class GamePlay extends JPanel {
    private ImageIcon tImage;
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.drawRect(24, 10, 851, 55);
        
        tImage=new ImageIcon();
        tImage.paintIcon(this, g, 25, 11);
        
        g.setColor(Color.red);
        g.drawRect(24, 74, 851, 577);
        
        g.setColor(Color.GREEN);
        g.fillRect(25, 75, 850, 575);
        
        
    }
    
}
