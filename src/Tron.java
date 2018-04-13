import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Tron extends JFrame {

    String title = "Animation Template";
    Color background = Color.BLUE;
    int delay = 10;

    // ���� ����������

    void start() {
        // ��� ��� �������������

    }

    void update() {
        // ��� ��� ���������� ������� ��������

    }

    void draw(Graphics2D g2) {

        // ��� ��� ��������� ���������� �����

    }

    void input(int keyCode) {
        // ��� ��� ��������� �����
        if (keyCode == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        } // else if / switch...

    }

    public Tron() {
        setTitle(title);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        DrawPanel panel = new DrawPanel();
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                input(e.getKeyCode());
            }
        });
        add(panel);

        addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				start();

				javax.swing.Timer timer = new javax.swing.Timer(delay, new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                update();
		                repaint();
		            }
		        });
		        timer.start();
			}
		});

        setVisible(true);
    }

    public static void main(String[] args) {
        new Tron();
    }

    class DrawPanel extends JPanel {
        public DrawPanel() {
            setBackground(background);
            setFocusable(true);
            requestFocusInWindow();
            setDoubleBuffered(true);
        }

        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            RenderingHints hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
            );
            g2.setRenderingHints(hints);

            super.paintComponent(g);
            draw(g2);
        }
    }

}
