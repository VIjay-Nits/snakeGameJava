package snakegame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import java.util.Random;

/**
 *
 * @author Vijay
 */
public class GamePlay extends JPanel implements KeyListener,ActionListener {

    private int []xlength=new int[20];
    private int []ylength=new int[20];
    
    private boolean left=false,right=false,up=false,down=false;
    
    private ImageIcon rm,lm,um,dm,tail;
    
    private Timer time;
    private int delay=120;
    
    private int snakelength=3;
    private int moves=0;
    
    private int[] xenemy={25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
    private int[] yenemy={75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};
    
    private int xpos=new Random().nextInt(34);
    private int ypos=new Random().nextInt(23);
    
   
    private ImageIcon enemyImage;
    
    public GamePlay() {
       
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        time =new Timer(delay, this);
        time.start();
         
    }
    
    private ImageIcon tImage;
    
    
    @Override
    public void paint(Graphics g){
        if(moves==0){
            xlength[2]=50;
            xlength[1]=75;
            xlength[0]=100;
            ylength[2]=100;
            ylength[1]=100;
            ylength[0]=100;
        
        }
        
        g.setColor(Color.white);
        g.drawRect(24, 10, 851, 55);
        
        tImage=new ImageIcon("image/snaketitle.jpg");
        tImage.paintIcon(this, g, 25, 11);
       
        
        g.setColor(Color.white);
        g.drawRect(24, 74, 851, 577);
        
        g.setColor(Color.BLACK);
        g.fillRect(25, 75, 850, 575);
        
        rm=new ImageIcon("image/rightmouth.png");
        rm.paintIcon(this, g,xlength[0], ylength[0]);
        
        for(int i=0;i<snakelength;i++){
            if(i==0&&right){
                rm=new ImageIcon("image/rightmouth.png");
                rm.paintIcon(this, g,xlength[0], ylength[0]);
        
            }
            if(i==0&&left){
                rm=new ImageIcon("image/leftmouth.png");
                rm.paintIcon(this, g,xlength[0], ylength[0]);
        
            }
            if(i==0&&up){
                rm=new ImageIcon("image/upmouth.png");
                rm.paintIcon(this, g,xlength[0], ylength[0]);
        
            }
            if(i==0&&down){
                rm=new ImageIcon("image/downmouth.png");
                rm.paintIcon(this, g,xlength[0], ylength[0]);
        
            }
            
            if(i!=0){
                tail =new ImageIcon("image/snakeimage.png");
                tail.paintIcon(this, g,xlength[i], ylength[i]);
        
            }
            
        }
        
        enemyImage=new ImageIcon("image/enemy.png");
        
        
        if(xenemy[xpos]==xlength[0]&&yenemy[ypos]==ylength[0]){
                snakelength++;
                xpos=new Random().nextInt(34);
                ypos=new Random().nextInt(23);
                
        }
        enemyImage.paintIcon(this, g, xenemy[xpos], yenemy[ypos]);
        
        
        g.dispose();
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
         if(e.getKeyCode()==KeyEvent.VK_RIGHT){
             moves++;
             if(!left){
                 right=true;
                
             }
             else{
                 right=false;
                 
             }
             up=false;
             down=false;
         }
         if(e.getKeyCode()==KeyEvent.VK_LEFT){
             moves++;
             if(!right){
                 left=true;
                
             }
             else{
                 left=false;
                 
             }
             up=false;
             down=false;
         }
         if(e.getKeyCode()==KeyEvent.VK_UP){
             moves++;
             if(!down){
                 up=true;
                
             }
             else{
                 up=false;
                 
             }
             right=false;
             left=false;
         }
         if(e.getKeyCode()==KeyEvent.VK_DOWN){
             moves++;
             if(!up){
                 down=true;
                
             }
             else{
                 down=false;
                 
             }
             right=false;
             left=false;
         }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        time.start();
        if(right){
              for(int r=snakelength;r>0;r--){
                  ylength[r]=ylength[r-1];
              }
              for(int x=snakelength;x>=0;x--){
                  if(x==0){
                      xlength[x]=xlength[x]+25;
                  }
                  else{
                      xlength[x]=xlength[x-1];
                  }
                  if(xlength[x]>850){
                      xlength[x]=25;
                  }
              }
              
              repaint();
            
        }
        if(left){
             for(int r=snakelength;r>0;r--){
                  ylength[r]=ylength[r-1];
              }
              for(int x=snakelength;x>=0;x--){
                  if(x==0){
                      xlength[x]=xlength[x]-25;
                  }
                  else{
                      xlength[x]=xlength[x-1];
                  }
                  if(xlength[x]<25){
                      xlength[x]=850;
                  }
              }
              
              repaint();
            
        }
        if(up){
             for(int r=snakelength;r>0;r--){
                  xlength[r]=xlength[r-1];
              }
              for(int x=snakelength;x>=0;x--){
                  if(x==0){
                      ylength[x]=ylength[x]-25;
                  }
                  else{
                      ylength[x]=ylength[x-1];
                  }
                  if(ylength[x]<75){
                      ylength[x]=625;
                  }
              }
              
              repaint();
        }
        if(down){
            for(int r=snakelength;r>0;r--){
                  xlength[r]=xlength[r-1];
              }
              for(int x=snakelength;x>=0;x--){
                  if(x==0){
                      ylength[x]=ylength[x]+25;
                  }
                  else{
                      ylength[x]=ylength[x-1];
                  }
                  if(ylength[x]>625){
                      ylength[x]=75;
                  }
              }
              
              repaint();
            
        }
        
        
    }
    
}
