package it.angelobdev.engine.game;

import it.angelobdev.engine.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

@SuppressWarnings({"unused", ""})
public abstract class Game extends Controller implements IGame, Runnable {

    // Thread management variables ...
    private Thread thread;
    private boolean running = false;

    // Restricted variables (constants once game starts) ...
    private JPanel panel;
    private String title = "Game!";
    private int width = 800;
    private int height = 600;

    // Free variables ...
    private Color bg_color = Color.black;
    private int FPS = 60;

    // Graphics handler ...
    protected Graphics2D g;

    private void start() {

        //JPanel setup:
        panel = new JPanel() {
            @Override
            public void addNotify() {
                super.addNotify();
                if (thread == null) {
                    thread = new Thread(Game.this);
                    thread.start();
                }
            }
        };
        panel.setPreferredSize(new Dimension(width, height));
        panel.setFocusable(true);
        panel.requestFocus();

        //JFrame setup:
        JFrame window = new JFrame(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Getting screen resolution:
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screen = tk.getScreenSize();
        int screenWidth = screen.width;
        int screenHeight = screen.height;

        //Finishing JFrame setup:
        window.setSize(width, height);
        window.setLocation(screenWidth / 2 - width / 2, screenHeight / 2 - height / 2);
        window.setResizable(false);
        window.setVisible(true);
        window.setContentPane(panel);

        //Thread setup:
        thread = new Thread(this);
        thread.start();

        //Last touch...
        running = true;
    }

    @Override
    public void run() {

        if (!running)
            start();

        else {

            init();

            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            g = (Graphics2D) image.getGraphics();
            running = true;

            long DELTA;
            long startTime;
            long elapsedTime;
            long waitTime;

            while (running) {

                DELTA = 1000 / FPS;
                startTime = System.nanoTime();

                if (panel.getGraphics() != null) {
                    panel.getGraphics().drawImage(image, 0, 0, null);
                    panel.getGraphics().dispose();
                }

                update();

                //Drawing background
                g.setColor(bg_color);
                g.fillRect(0, 0, width, height);

                render();

                elapsedTime = System.nanoTime() - startTime;
                waitTime = DELTA - elapsedTime / 1000000;

                if (waitTime < 5)
                    waitTime = 5;

                try {
                    Thread.sleep(waitTime);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//run

    /* GETTERS AND SETTERS FOR RESTRICTED VARIABLES */

    public JPanel getPanel() {
        return panel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (!running) this.title = title;
        else throw new RuntimeException("Unable to do this now! Game has started already...");
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (!running) this.width = width;
        else throw new RuntimeException("Unable to do this now! Game has started already...");
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (!running) this.height = height;
        else throw new RuntimeException("Unable to do this now! Game has started already...");
    }

    /* GETTERS AND SETTERS FOR FREE VARIABLES */

    public int getFPS() {
        return FPS;
    }

    public void setFPS(int FPS) {
        this.FPS = FPS;
    }

    public Color getBackground() {
        return bg_color;
    }

    public void setBackground(Color bg_color) {
        this.bg_color = bg_color;
    }

}
