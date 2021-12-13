package it.angelobdev.engine.controller;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface Controllable {


    default void keyTyped(KeyEvent keyEvent) {

    }

    default void keyPressed(KeyEvent keyEvent) {

    }

    default void keyReleased(KeyEvent keyEvent) {

    }

    default void mouseClicked(MouseEvent mouseEvent) {

    }

    default void mousePressed(MouseEvent mouseEvent) {

    }

    default void mouseReleased(MouseEvent mouseEvent) {

    }

    default void mouseEntered(MouseEvent mouseEvent) {

    }

    default void mouseExited(MouseEvent mouseEvent) {

    }

}
