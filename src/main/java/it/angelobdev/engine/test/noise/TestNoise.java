package it.angelobdev.engine.test.noise;

import it.angelobdev.engine.game.Game;
import it.angelobdev.engine.object.Rectangle;
import it.angelobdev.engine.simplenoise.Noise;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TestNoise extends Game {

    private Noise noise;
    private BufferedImage image;

    private int ox = 0, oy = 0;

    private final int SIZE = 10;
    ArrayList<Rectangle> grid;


    @Override
    public void init() {
        //Controller
        controllerSetup(getPanel());
        //Noise
        noise = new Noise();
        noise.SetNoiseType(Noise.NoiseType.Perlin);

        //Grid
        grid = new ArrayList<>();
        for (int i = 0; i < getWidth(); i += SIZE)
            for (int j = 0; j < getHeight(); j += SIZE)
                grid.add(new Rectangle(i, j, SIZE, SIZE));

    }

    @Override
    public void update() {
        //System.out.println("Updating...");
        for (Rectangle rect : grid) {

            // Getting coords ...
            int x = (int) rect.getPosition().getX();
            int y = (int) rect.getPosition().getY();

            // Calculating height ...
            double noiseValue = noise.GetNoise(x + ox, y + oy);
            double zoNoise = (noiseValue + 1) / 2.0d;
            int height = (int) (zoNoise * 255);

            // Setting color based on height ...
            Color c = null;
            if (height > 200)
                c = Color.white;
            else if (height > 150)
                c = Color.lightGray;
            else if (height > 100)
                c = new Color(90, 68, 18);
            else if (height > 50)
                c = new Color(192, 181, 107);
            else
                c = Color.blue;

            // Setting rectangle color ...
            rect.setColor(c);
        }
    }

    @Override
    public void render() {
        //System.out.println("Rendering...");
        for (Rectangle rect : grid)
            rect.render(g);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int step = 10;
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_UP:
                oy -= step;
                break;
            case KeyEvent.VK_DOWN:
                oy += step;
                break;
            case KeyEvent.VK_LEFT:
                ox -= step;
                break;
            case KeyEvent.VK_RIGHT:
                ox += step;
                break;
        }
    }

    public static void main(String[] args) {
        TestNoise tn = new TestNoise();
        tn.setFPS(24);
        tn.run();
    }
}
