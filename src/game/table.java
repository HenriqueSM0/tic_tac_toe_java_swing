package game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Label;

public class table extends JFrame {
    space [][] spaces;
    char current_player;
    int round;

    table () {
        int i, j;
        spaces = new space[3][3];
        setTitle("Tic Tac Toe");
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300, 300);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                spaces[i][j] = new space(this);
                panel.add(spaces[i][j]);
            }
        } 
        add(panel);
        round = 0;
        current_player = '1';
    }

    private boolean analyze_x (char type) {
        int i;
        for (i = 0; i < 3; i++) {
            if ((spaces[i][0].get_type() == type) && (spaces[i][1].get_type() == type) && (spaces[i][2].get_type() == type)) {
                return true;
            }
        }
        return false;
    } 

    private boolean analyze_y (char type) {
        int j;
        for (j = 0; j < 3; j++) {
            if ((spaces[0][j].get_type() == type) && (spaces[1][j].get_type() == type) && (spaces[2][j].get_type() == type)) {
                return true;
            }
        }
        return false;
    }

    private boolean analyze_d_1 (char type) {
        if ((spaces[0][0].get_type() == type) && (spaces[1][1].get_type() == type) && (spaces[2][2].get_type() == type)) {
            return true;
        }
        return false;
    }

    private boolean analyze_d_2 (char type) {
        if ((spaces[0][2].get_type() == type) && (spaces[1][1].get_type() == type) && (spaces[2][0].get_type() == type)) {
            return true;
        }
        return false;
    }

    void analyze_winner () {
        if (analyze_x('1') || analyze_y('1') || analyze_d_1('1') || analyze_d_2('1')) {
            dispose();
            JFrame final_frame = new JFrame();
            Label label = new Label();
            label.setText("Player 1 wins !!!");
            final_frame.add(label);
            final_frame.setVisible(true);
            final_frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            final_frame.setLocationRelativeTo(null);
            final_frame.setSize(100, 100);
        } else if (analyze_x('2') || analyze_y('2') || analyze_d_1('2') || analyze_d_2('2')) {
            dispose();
            JFrame final_frame = new JFrame();
            Label label = new Label();
            label.setText("Player 2 wins !!!");
            final_frame.add(label);
            final_frame.setVisible(true);
            final_frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            final_frame.setLocationRelativeTo(null);
            final_frame.setSize(100, 100);
        }
    }

   public static void main(String[] args) {
    new table();
   }
    
}
