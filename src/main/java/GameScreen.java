
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class GameScreen extends javax.swing.JFrame {

    public GameScreen(String title) throws HeadlessException {
        super(title);
    }
    
    
    public static void main(String[] args) {
        GameScreen screen = new GameScreen("Space Game");
        
     screen.setResizable(false);
     screen.setFocusable(false);
     
     screen.setSize(800,600);
     screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     Game game = new Game ();
     
     game.requestFocus();
     game.addKeyListener(game);
     game.setFocusable(true);
     game.setFocusTraversalKeysEnabled(false);
     
     
     screen.add(game);
     screen.setVisible(true);
     
     
     
     
    }
    
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
