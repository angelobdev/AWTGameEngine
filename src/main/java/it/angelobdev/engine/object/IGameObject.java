package it.angelobdev.engine.object;

import it.angelobdev.engine.game.Game;
import it.angelobdev.engine.util.Vector2d;

import java.awt.*;

public interface IGameObject {

    Vector2d getPosition();

    double getWidth();

    double getHeight();

    default void update() {
        //By default there's nothing to update.
    }

    void render(Graphics2D g);

    default boolean isInside(Game game) {
        double x = getPosition().getX();
        double y = getPosition().getY();
        double width = getWidth();
        double height = getHeight();

        double gameWidth = game.getWidth();
        double gameHeight = game.getHeight();

        if (x < 0 || x + width > gameWidth) return false;
        if (y < 0 || y + height > gameHeight) return false;
        return true;
    }

}
