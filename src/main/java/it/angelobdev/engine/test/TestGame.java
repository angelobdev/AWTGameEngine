package it.angelobdev.engine.test;

import it.angelobdev.engine.game.Game;
import it.angelobdev.engine.object.defaults.Rectangle;
import it.angelobdev.engine.util.Vector2d;

import java.awt.*;


public class TestGame extends Game {

    Rectangle rect;

    @Override
    public void init() {
        rect = new Rectangle(0, 0, 200, 200);
    }

    @Override
    public void update() {
        rect.getPosition().move(Vector2d.Direction.RIGHT, 1);
        rect.getPosition().move(Vector2d.Direction.DOWN, 1);
    }

    @Override
    public void render() {
        g.setColor(Color.RED);
        rect.render(g);
    }

    public static void main(String[] args) {
        new TestGame();
    }
}
