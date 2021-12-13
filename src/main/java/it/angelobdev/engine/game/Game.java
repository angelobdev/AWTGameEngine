package it.angelobdev.engine.game;

import it.angelobdev.engine.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

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
    private BufferedImage canvas;
    protected Graphics2D g;

    public Game() {

        preInit();

        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) canvas.getGraphics();

        //JPanel setup:
        panel = new JPanel() {
            @Override
            public void addNotify() {
                super.addNotify();
                if (thread == null) {
                    thread = new Thread(Game.this);
                    thread.start();
                    //Last touch...
                    running = true;
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.drawImage(canvas, 0, 0, null);
                g2.dispose();
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
    }

    @Override
    public void run() {


        init();

        long DELTA;
        long startTime;
        long elapsedTime;
        long waitTime;

        while (running) {

            DELTA = 1000 / FPS;
            startTime = System.nanoTime();

            //Updating elements
            update();
            //Drawing background (preparing for new elements)
            g.setColor(bg_color);
            g.fillRect(0, 0, width, height);
            //Rendering new graphical elements
            render();
            //Drawing on screen
            panel.repaint();

            elapsedTime = System.nanoTime() - startTime;
            waitTime = DELTA - elapsedTime / 1000000;

            if (waitTime < 5)
                waitTime = 5;

            try {
                TimeUnit.MILLISECONDS.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.exit(0);

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