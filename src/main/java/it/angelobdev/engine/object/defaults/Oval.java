package it.angelobdev.engine.object.defaults;

import it.angelobdev.engine.object.GameObject;
import it.angelobdev.engine.util.Dimension;
import it.angelobdev.engine.util.Vector2d;

import java.awt.*;

public class Oval extends GameObject {

    public Oval(double x, double y, double SMA, double sma) {
        this.position = new Vector2d(x, y);
        this.dimension = new Dimension(SMA * 2, sma * 2);
    }

    @Override
    public void render(Graphics g) {

        super.render(g);

        int x = (int) position.getX();
        int y = (int) position.getY();
        int SMA = (int) dimension.getWidth();
        int sma = (int) dimension.getHeight();

        switch (renderMode) {
            case STROKE:
                g.drawOval(x, y, SMA, sma);
                break;
            case FILL:
                g.fillOval(x, y, SMA, sma);
                break;
            case FULL:
                g.drawOval(x, y, SMA, sma);
                g.fillOval(x, y, SMA, sma);
                break;
        }

    }//render

}
