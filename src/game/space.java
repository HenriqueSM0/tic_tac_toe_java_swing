package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class space extends JButton implements MouseListener {
    private char type;
    table T;

    space (table T) {
        type = 'A';
        setBackground(colors.WHITE);
        this.T = T;
        addMouseListener(this);
    }

    boolean set_type (char new_type) {
        if (type == 'A') {
            type = new_type;
            if (new_type == '1') {
                setBackground(colors.BLUE);
            } else {
                setBackground(colors.RED);
            }
            return true;
        }
        return false;
    }

    char get_type () {
        return type;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (set_type(T.current_player)) {
            if (T.current_player == '1') {
                T.current_player = '2';
            } else {
                T.current_player = '1';
            }
            T.round++;
            if (T.round == 9) {
                T.dispose();
            }
            T.analyze_winner();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
    
    }

    
}
