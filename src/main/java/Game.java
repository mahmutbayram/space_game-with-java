
import java.awt.Color;
import java.awt.Graphics;
import java.awt.PageAttributes;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.paint.Color.color;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

class Fires {    
    private int x;
    private int y;
    int getY;

    public Fires(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}

/**
 *
 * @author mm
 */
public class Game extends JPanel implements KeyListener,ActionListener{
   
    Timer timer = new Timer(6,this);
    
    private int total_time = 0;
    private int total_fire = 0;
    
    private BufferedImage image;
    
    private ArrayList<Fires> fires = new ArrayList<Fires> ();
    
    private int firedirY = 1 ;
    private int ballX = 0 ;
    private int balldirX = 2 ;
    private int spaceshipX = 0 ;
    private int dirSpaceX = 20 ;
    
    public boolean checkIt(){
        for (Fires fire: fires ) {
            
            if (new Rectangle(fire.getX(),fire.getY(),10,20).intersects(new Rectangle(ballX,0,20,20))) {
                return  true;
            }
        }
        return false;
    }
            

    public Game() {
        
        try {
            image = ImageIO.read(new FileImageInputStream(new File ("spaceship.png")));
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        setBackground(Color.BLACK);
        
        timer.start();
        
       
    }

    @Override
    public void repaint() {
        super.repaint(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        
        total_time += 5;
        
        g.setColor(Color.BLUE);
        g.fillOval(ballX, 0, 20, 20);
        
        g.drawImage(image, spaceshipX, 490, image.getHeight()/30, image.getWidth()/30,this);
        
        for (Fires fire : fires ){
            if (fire.getY() < 0 ){
                fires.remove(fire);
            }
        }
        g.setColor(Color.RED);
        
        for (Fires fire : fires){
            
            g.fillRect(fire.getX(),fire.getY(), 10, 20);
            
        }
        
        if (checkIt()){
            timer.stop();
            String message = "You won!\n"+
                             "Total fire = "+total_fire+
                             "\nTotal time = "+total_time/1000.0;
            
            JOptionPane.showMessageDialog(this, message);
            
            System.exit(0);
        }
    }
    
     
    
    @Override
    public void keyTyped(KeyEvent e) {
     
        
    }
    
       
        

   
    
    @Override
    public void keyPressed(KeyEvent e) {
    int c = e.getKeyCode();
        
        if (c == KeyEvent.VK_LEFT ){
            
            if (spaceshipX <= 0 ) {    
                
                spaceshipX = 0;
                
            }
            else {
                
                spaceshipX -= dirSpaceX;
                
            }
        }
        else if ( c == KeyEvent.VK_RIGHT){
            if ( spaceshipX >=720){
                
                spaceshipX = 720;
                
            }
            else {
                
                spaceshipX += dirSpaceX;
                
            }
        }
        else if ( c == KeyEvent.VK_CONTROL){
            
            fires.add(new Fires(spaceshipX+53,490));
            
            
            total_fire++;
        }
    
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        for (Fires fire: fires ) {
            
            fire.setY(fire.getY()-firedirY);
            
                    
            
        }
         
        
        
        
        ballX += balldirX;
        
        if ( ballX >= 750) {
            
            balldirX = -balldirX;
            
        }
        if ( ballX <= 0) {
            
            balldirX = -balldirX;
               
        }
       
        repaint();
        
    }
    
}
        
