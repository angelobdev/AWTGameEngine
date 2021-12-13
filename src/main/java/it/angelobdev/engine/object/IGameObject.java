package it.angelobdev.engine.object;

import it.angelobdev.engine.util.Dimension;
import it.angelobdev.engine.util.Vector2d;

import java.awt.*;

public interface IGameObject {

    Vector2d getPosition();

    Dimension getDimension();

    Color getColor();

    default void render(Graphics g) {
        g.setColor(getColor());
    }

}
