package it.angelobdev.engine.object;

import it.angelobdev.engine.controller.Controllable;
import it.angelobdev.engine.util.Vector2d;

import java.awt.*;

public abstract class GameObject implements IGameObject, Controllable {

    public enum RenderMode {
        FILL, STROKE, FULL
    }

    protected Vector2d position;
    protected double width, height;
    protected RenderMode renderMode = RenderMode.FILL;
    protected Color color = Color.white;

    public GameObject() {
    }

    public GameObject(Vector2d position, double width, double height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public GameObject(GameObject go) {
        this.position = new Vector2d(go.getPosition());
        this.width = go.width;
        this.height = go.height;
    }

    @Override
    public void render(Graphics2D g) {

        g.setColor(color);

        double x = position.getX();
        double y = position.getY();

        if (renderMode == RenderMode.FILL) {
            g.fillRect((int) x, (int) y, (int) width, (int) height);
        } else if (renderMode == RenderMode.STROKE) {
            g.drawRect((int) x, (int) y, (int) width, (int) height);
        } else {
            g.fillRect((int) x, (int) y, (int) width, (int) height);
            g.drawRect((int) x, (int) y, (int) width, (int) height);
        }
    }

    @Override
    public Vector2d getPosition() {
        return position;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPosition(Vector2d position) {
        this.position = position;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public RenderMode getRenderMode() {
        return renderMode;
    }

    public void setRenderMode(RenderMode renderMode) {
        this.renderMode = renderMode;
    }
}
