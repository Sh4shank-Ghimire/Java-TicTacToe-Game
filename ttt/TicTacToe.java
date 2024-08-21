package ttt;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {
    /* Datatype and objects declaration */
    Random random = new Random();
    JFrame frame = new JFrame();
    JLabel textfield = new JLabel();
    JPanel title_Panel = new JPanel();
    JPanel button_panel = new JPanel();
    JButton button[] = new JButton[9];
    JButton replay = new JButton("Replay");
    boolean turn1st;

    TicTacToe() {
        /* Frame */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        /* Textfield */
        textfield.setBackground(new Color(160, 82, 45));
        textfield.setForeground(new Color(245, 245, 245));
        textfield.setFont(new Font("POPPINS", Font.BOLD, 70));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("TicTacToe(Alu_Cross)");
        textfield.setOpaque(true);

        /* Title panel contains textfield */
        title_Panel.setLayout(new BorderLayout());
        title_Panel.setBounds(0, 0, 800, 100);
        title_Panel.add(textfield);

        /* button panel for button */
        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150, 150, 150));

        /* Coniguration of buttons for "X" and "O" */
        for (int i = 0; i < 9; i++) {
            button[i] = new JButton();
            button_panel.add(button[i]);
            button[i].setFont(new Font("POPPINS", Font.BOLD, 100));
            button[i].setBackground(new Color(30, 30, 50));
            button[i].setFocusable(false);
            button[i].addActionListener(this);
        }

        /* COnfiguration of the replay button */
        replay.setFont(new Font("POPPINS", Font.BOLD, 15));
        replay.setFocusable(false);
        replay.setBackground(new Color(245, 245, 220));
        replay.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == replay) {
                    resetGame();
                }
            }
        });

        title_Panel.add(replay, BorderLayout.EAST);

        frame.add(title_Panel, BorderLayout.NORTH);
        frame.add(button_panel);

        turn1st();

    }

    /* The random class determines the first turn */
    private void turn1st() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        if (random.nextInt(2) == 0) {
            turn1st = true;
            textfield.setText("X turn");
        } else {
            turn1st = false;
            textfield.setText("O turn");
        }
    }

    private void check() {
        /* Conditions for "X" to win */
        if ((button[0].getText() == "X") &&
                (button[1].getText() == "X") &&
                (button[2].getText() == "X")) {
            xWins(0, 1, 2);
        }
        if ((button[3].getText() == "X") &&
                (button[4].getText() == "X") &&
                (button[5].getText() == "X")) {
            xWins(3, 4, 5);
        }
        if ((button[6].getText() == "X") &&
                (button[7].getText() == "X") &&
                (button[8].getText() == "X")) {
            xWins(6, 7, 8);
        }
        if ((button[0].getText() == "X") &&
                (button[3].getText() == "X") &&
                (button[6].getText() == "X")) {
            xWins(0, 3, 6);
        }
        if ((button[1].getText() == "X") &&
                (button[4].getText() == "X") &&
                (button[7].getText() == "X")) {
            xWins(1, 4, 7);
        }
        if ((button[2].getText() == "X") &&
                (button[5].getText() == "X") &&
                (button[8].getText() == "X")) {
            xWins(2, 5, 8);
        }
        if ((button[0].getText() == "X") &&
                (button[4].getText() == "X") &&
                (button[8].getText() == "X")) {
            xWins(0, 4, 8);
        }
        if ((button[2].getText() == "X") &&
                (button[4].getText() == "X") &&
                (button[6].getText() == "X")) {
            xWins(2, 4, 6);
        }

        /* Conditions for "O" to win */
        if ((button[0].getText() == "O") &&
                (button[1].getText() == "O") &&
                (button[2].getText() == "O")) {
            oWins(0, 1, 2);
        }
        if ((button[3].getText() == "O") &&
                (button[4].getText() == "O") &&
                (button[5].getText() == "O")) {
            oWins(3, 4, 5);
        }
        if ((button[6].getText() == "O") &&
                (button[7].getText() == "O") &&
                (button[8].getText() == "O")) {
            oWins(6, 7, 8);
        }
        if ((button[0].getText() == "O") &&
                (button[3].getText() == "O") &&
                (button[6].getText() == "O")) {
            oWins(0, 3, 6);
        }
        if ((button[1].getText() == "O") &&
                (button[4].getText() == "O") &&
                (button[7].getText() == "O")) {
            oWins(1, 4, 7);
        }
        if ((button[2].getText() == "O") &&
                (button[5].getText() == "O") &&
                (button[8].getText() == "O")) {
            oWins(2, 5, 8);
        }
        if ((button[0].getText() == "O") &&
                (button[4].getText() == "O") &&
                (button[8].getText() == "O")) {
            oWins(0, 4, 8);
        }
        if ((button[2].getText() == "O") &&
                (button[4].getText() == "O") &&
                (button[6].getText() == "O")) {
            oWins(2, 4, 6);
        }
    }

    private void xWins(int a, int b, int c) {
        /* The buttons change the color if the condition is met. */
        button[a].setBackground(new Color(53, 94, 59));
        button[b].setBackground(new Color(53, 94, 59));
        button[c].setBackground(new Color(53, 94, 59));

        /* Disables the button after the win */
        for (int i = 0; i < 9; i++) {
            button[i].setEnabled(false);
        }
        textfield.setText("X wins");
    }

    private void oWins(int a, int b, int c) {
        button[a].setBackground(new Color(53, 94, 59));
        button[b].setBackground(new Color(53, 94, 59));
        button[c].setBackground(new Color(53, 94, 59));

        for (int i = 0; i < 9; i++) {
            button[i].setEnabled(false);
        }
        textfield.setText("O wins");
    }

    private void draw() {
        /* Boolean allFilled to check if all the buttons are filled or not. */
        boolean allFilled = true;

        /* If not the loop is broken down. */
        for (int i = 0; i < 9; i++) {
            if (button[i].getText().equals("")) {
                allFilled = false;
                break;
            }
        }

        if (allFilled) {
            textfield.setText("Draw");
            for (int i = 0; i < 9; i++) {
                button[i].setEnabled(false);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == button[i]) {
                if (turn1st) {
                    if (button[i].getText() == "") {
                        button[i].setForeground(new Color(255, 0, 0));
                        button[i].setText("X");
                        turn1st = false;
                        textfield.setText("O turn");
                        check();
                    }
                } else {
                    if (button[i].getText() == "") {
                        button[i].setForeground(new Color(0, 0, 255));
                        button[i].setText("O");
                        turn1st = true;
                        textfield.setText("X turn");
                        check();
                        draw();
                    }
                }
            }
        }
    }

    private void resetGame() {
        for (int i = 0; i < 9; i++) {
            button[i].setText("");
            button[i].setEnabled(true);

        }
    }
}
