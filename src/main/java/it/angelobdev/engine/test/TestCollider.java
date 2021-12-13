package it.angelobdev.engine.test;

import it.angelobdev.engine.game.Game;
import it.angelobdev.engine.object.GameObject;
import it.angelobdev.engine.object.defaults.Rectangle;
import it.angelobdev.engine.util.Vector2d;

import java.awt.*;
import java.util.ArrayList;

public class TestCollider {

    public static void main(String[] args) {

        new Game() {

            ArrayList<GameObject> gos;

            @Override
            public void init() {
                gos = new ArrayList<>();
                gos.add(new Rectangle(10, 10, 20, 20).setColor(Color.BLUE));
                gos.add(new Rectangle(790, 10, 20, 20).setColor(Color.RED));
            }

            @Override
            public void update() {
                if (!gos.isEmpty()) {
                    gos.get(0).getPosition().move(Vector2d.Direction.RIGHT, 2);
                    gos.get(1).getPosition().move(Vector2d.Direction.LEFT, 2);
                }
                try {
                    boolean colliding = gos.get(0).isColliding(gos.get(1));
                    if (colliding) {
                        System.out.println("AHIA!");
                        gos.clear();

                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void render() {
                for (GameObject go : gos)
                    go.render(g);
            }
        };

    }

}
