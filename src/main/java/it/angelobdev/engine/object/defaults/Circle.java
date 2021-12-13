package it.angelobdev.engine.object.defaults;

import it.angelobdev.engine.object.GameObject;
import it.angelobdev.engine.util.Dimension;
import it.angelobdev.engine.util.Vector2d;

import java.awt.*;

public class Circle extends GameObject {

    public Circle(double x, double y, double radius) {
        this.position = new Vector2d(x, y);
        this.dimension = new Dimension(radius, radius);
    }

    @Override
    public void render(Graphics g) {

        super.render(g);

        int x = (int) position.getX();
        int y = (int) position.getY();
        int radius = (int) dimension.getWidth();

        switch (renderMode) {
            case STROKE:
                g.drawOval(x, y, radius, radius);
                break;
            case FILL:
                g.fillOval(x, y, radius, radius);
                break;
            case FULL:
                g.drawOval(x, y, radius, radius);
                g.fillOval(x, y, radius, radius);
                break;
        }

    }//render

}
