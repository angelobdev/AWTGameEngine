package it.angelobdev.engine.test;

import it.angelobdev.engine.game.Game;
import it.angelobdev.engine.object.GameObject;
import it.angelobdev.engine.object.IGameObject;
import it.angelobdev.engine.object.defaults.Circle;
import it.angelobdev.engine.object.defaults.Oval;
import it.angelobdev.engine.object.defaults.Rectangle;

import java.awt.*;
import java.util.ArrayList;

public class TestGO {

    public static void main(String[] args) {

        new Game() {

            ArrayList<GameObject> gos;

            @Override
            public void init() {
                gos = new ArrayList<>();
                gos.add(new Rectangle(10, 10, 20, 20).setColor(Color.BLUE));
                gos.add(new Oval(120, 10, 20, 20).setColor(Color.RED));
                gos.add(new Circle(60, 80, 20).setColor(Color.GREEN));
            }

            @Override
            public void update() {

            }

            @Override
            public void render() {
                for (GameObject go : gos)
                    go.render(g);
            }
        };

    }

}
