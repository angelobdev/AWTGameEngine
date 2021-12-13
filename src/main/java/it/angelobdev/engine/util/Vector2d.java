package it.angelobdev.engine.util;

import java.util.Objects;

@SuppressWarnings("unused")
public class Vector2d {

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    private double x, y;

    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2d(Vector2d v2d) {
        this.x = v2d.getX();
        this.y = v2d.getY();
    }

    public void move(Direction dir, double step) {
        if (step <= 0)
            throw new IllegalArgumentException("Step can't be negative or zero!");
        switch (dir) {
            case UP:
                y = y - step;
                break;
            case DOWN:
                y = y + step;
                break;
            case LEFT:
                x = x - step;
                break;
            case RIGHT:
                x = x + step;
                break;
        }
    }

    /*** GETTERS AND SETTERS ***/

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    /*** OVERRIDES ***/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector2d)) return false;
        Vector2d v = (Vector2d) o;
        return v.x == x && v.y == y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "V2D{" + x + ", " + y + "}";
    }

}
