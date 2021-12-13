package it.angelobdev.engine.object.defaults;

import it.angelobdev.engine.object.GameObject;
import it.angelobdev.engine.util.Dimension;
import it.angelobdev.engine.util.Vector2d;

import java.awt.*;

public class Rectangle extends GameObject {

    public Rectangle(double x, double y, double w, double h) {
        this.position = new Vector2d(x, y);
        this.dimension = new Dimension(w, h);
    }

    @Override
    public void render(Graphics g) {

        super.render(g);

        double x = position.getX();
        double y = position.getY();
        double width = dimension.getWidth();
        double height = dimension.getHeight();

        if (renderMode == RenderMode.FILL) {
            g.fillRect((int) x, (int) y, (int) width, (int) height);
        } else if (renderMode == RenderMode.STROKE) {
            g.drawRect((int) x, (int) y, (int) width, (int) height);
        } else {
            g.fillRect((int) x, (int) y, (int) width, (int) height);
            g.drawRect((int) x, (int) y, (int) width, (int) height);
        }
    }

}
