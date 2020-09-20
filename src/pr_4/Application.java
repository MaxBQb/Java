package pr_4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Application extends JFrame {
    JButton btn_ac = new JButton("AC Milan");
    JButton btn_rm = new JButton("Real Madrid");
    Font fnt = new Font("Tahoma", Font.BOLD,20);
    JLabel lbl_result = new JLabel("Result: 0 X 0", SwingConstants.CENTER);
    JLabel lbl_last = new JLabel("Last Scorer: N/A", SwingConstants.CENTER);
    Label lbl_winner = new Label("Winner: DRAW", Label.CENTER);

    static final int MAX_SCORE = 10;

    private int rm_score;
    private int ac_score;

    private void updateResults() {
        lbl_result.setText(String.format("Result: %s X %s", ac_score, rm_score));
        lbl_winner.setText("Winner: "+(rm_score < ac_score ? "AC Milan" :
                (rm_score > ac_score ? "Real Madrid" : "DRAW")));
        if (rm_score == MAX_SCORE)
            btn_rm.setEnabled(false);
        if (ac_score == MAX_SCORE)
            btn_ac.setEnabled(false);
        if (rm_score == ac_score && rm_score == MAX_SCORE)
            setTitle("Милан и Мадрид, уже никто не победит.");
    }

    Application() {
        super("Милан и Мадрид, ну и кто победит?");
        btn_ac.setFont(fnt);
        btn_rm.setFont(fnt);
        lbl_result.setFont(fnt);
        lbl_last.setFont(fnt);
        lbl_winner.setFont(fnt);
        setLayout(new BorderLayout());
        setSize(640,200);
        add(btn_ac, BorderLayout.WEST);
        add(btn_rm, BorderLayout.EAST);
        JPanel pnl_info = new JPanel(new GridLayout(3, 1));
        pnl_info.add(lbl_result);
        pnl_info.add(lbl_last);
        pnl_info.add(lbl_winner);
        add(pnl_info);

        btn_ac.addMouseListener(new MouseListener() {
            public void mouseExited(MouseEvent a) {}
            public void mouseClicked(MouseEvent a) {}
            public void mouseEntered(MouseEvent a) {}
            public void mouseReleased(MouseEvent a) {}
            public void mousePressed(MouseEvent a) {
                if (a.getButton() != 1 || ac_score >= MAX_SCORE)
                    return;
                ac_score++;
                lbl_last.setText("Last Scorer: "+((JButton)a.getSource()).getText());
                updateResults();
            }
        });

        btn_rm.addMouseListener(new MouseListener() {
            public void mouseExited(MouseEvent a) {}
            public void mouseClicked(MouseEvent a) {}
            public void mouseEntered(MouseEvent a) {}
            public void mouseReleased(MouseEvent a) {}
            public void mousePressed(MouseEvent a) {
                if (a.getButton() != 1 || rm_score >= MAX_SCORE)
                    return;
                rm_score++;
                lbl_last.setText("Last Scorer: "+((JButton)a.getSource()).getText());
                updateResults();
            }
        });
        getRootPane().putClientProperty("apple.awt.brushMetalLook", Boolean.TRUE);

    }

    public static void main(String[]args) {
        (new Application()).setVisible(true);
    }
}

