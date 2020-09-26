package lab_5;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


class Animation {
    private JLabel viewer;
    private int step;
    private int current_pos;
    private Timer timer;
    private FrameSlider change_frame;
    private int fps;
    private ArrayList<ImageIcon> frames;

    Animation(int fps) {
        step = 1;
        current_pos = 0;
        viewer = new JLabel();
        frames = new ArrayList<ImageIcon>();
        timer = new Timer();
        change_frame = new FrameSlider();
        setFps(fps);
    }

    Animation(int fps, String[] paths) throws IOException {
        this(fps);
        readFrames(paths);
    }

    public void readFrames(String[] paths) throws IOException {
        for (var path: paths)
            frames.add(new ImageIcon(path));
    }

    protected void slideFrame() {
        if (frames.size() == 0)
            return;
        current_pos += step;
        current_pos %= frames.size();
        viewer.setIcon(frames.get(current_pos));
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public void reverse() {
        step *= -1;
    }

    public int getFps() {
        return fps;
    }

    public void setFps(int fps) {
        this.fps = fps;
        timer.purge();
        timer.scheduleAtFixedRate(change_frame, 0,
                (long)(1000/fps));
    }

    public void setCurrent_pos(int current_pos) {
        if (frames.size() == 0) {
            current_pos = 0;
            return;
        }
        current_pos %= frames.size();
        if (current_pos < 0)
            current_pos += frames.size();
        this.current_pos = current_pos;
    }

    public JLabel getViewer() {
        return viewer;
    }

    public void setViewer(JLabel viewer) {
        this.viewer = viewer;
    }

    class FrameSlider extends TimerTask {
        @Override
        public void run() {
            slideFrame();
        }
    }
}


public class Appication extends JFrame{

    Appication() throws IOException {
        super("Кто здесь?!");
        setBounds(0,0,270,170);
        setLocationRelativeTo(null);
        int Height = getHeight();
        int Width = getWidth();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        var frames = new String[] {
                "./Tasks/src/lab_5/left.png",
                "./Tasks/src/lab_5/right.png"
        };
        var animation = new Animation(2, frames);
        var container = new JPanel();
        container.add(animation.getViewer());
        add(container, BorderLayout.CENTER);
    }


    public static void main(String[] args) throws IOException {
        var app = new Appication();
        app.setVisible(true);
    }
}

