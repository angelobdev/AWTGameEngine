package it.angelobdev.engine.test;

import it.angelobdev.engine.game.Game;
import it.angelobdev.engine.object.defaults.Rectangle;
import it.angelobdev.engine.simplenoise.Noise;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class TestNoise {
    public static void main(String[] args) {
        new Game() {
            private Noise noise;
            private int ox = 0, oy = 0;
            ArrayList<Rectangle> grid;

            @Override
            public void preInit() {
                setTitle("Colored Perlin Noise!");
                setFPS(24);
            }

            @Override
            public void init() {

                //Controller
                controllerSetup(getPanel());

                //Noise
                noise = new Noise();
                noise.SetNoiseType(Noise.NoiseType.Perlin);

                //Grid
                grid = new ArrayList<>();
                int size = 4;
                for (int i = 0; i < getWidth(); i += size)
                    for (int j = 0; j < getHeight(); j += size)
                        grid.add(new Rectangle(i, j, size, size));

            }

            @Override
            public void update() {

                for (Rectangle rect : grid) {

                    // Getting coords ...
                    int x = (int) rect.getPosition().getX() + ox;
                    int y = (int) rect.getPosition().getY() + oy;

                    // Calculating height ...
                    double noiseValue = noise.GetNoise(x, y);
                    double zoNoise = (noiseValue + 1) / 2.0d;
                    int height = (int) (zoNoise * 255);

                    // Setting color based on height ...
                    Color c;
                    if (height > 200)
                        c = Color.white;
                    else if (height > 150)
                        c = Color.lightGray;
                    else if (height > 100)
                        c = new Color(90, 68, 18);
                    else if (height > 51)
                        c = Color.green.darker();
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
        };
    }
}
