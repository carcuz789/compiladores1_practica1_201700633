/*
 * minuvahard10.com Video Game Tetris
 */
package practica1_201700633;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Tetris extends JFrame {

    JLabel statusbar;


    public Tetris() {

        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);
        Board board = new Board(this);
        add(board);
        board.start();

        setSize(300, 500);
        setTitle("Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
   }

   public JLabel getStatusBar() {
       return statusbar;
   }

    public static void main(String[] args) {

        Tetris game = new Tetris();
        game.setLocationRelativeTo(null);
        game.setVisible(true);

    } 
}    

