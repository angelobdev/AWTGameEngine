package it.angelobdev.engine.object;

import it.angelobdev.engine.util.Vector2d;

public class Rectangle extends GameObject {

    public Rectangle(double x, double y, double w, double h) {
        this.position = new Vector2d(x, y);
        this.width = w;
        this.height = h;
    }

}
