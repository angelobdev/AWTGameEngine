package it.angelobdev.engine.game;

public interface IGame {

    default void preInit() {
    }

    void init();

    void update();

    void render();


}
