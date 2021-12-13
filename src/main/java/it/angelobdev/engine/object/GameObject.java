package it.angelobdev.engine.object;

import it.angelobdev.engine.collider.ICollider;
import it.angelobdev.engine.controller.Controllable;
import it.angelobdev.engine.util.Dimension;
import it.angelobdev.engine.util.Vector2d;

import java.awt.*;

public abstract class GameObject implements IGameObject, Controllable, ICollider {

    public enum RenderMode {
        FILL, STROKE, FULL
    }

    protected Vector2d position;
    protected Dimension dimension;
    protected RenderMode renderMode = RenderMode.FILL;
    protected Color color = Color.white;

    public GameObject() {
        position = new Vector2d(0, 0);
        dimension = new Dimension(10, 10);
    }

    public GameObject(Vector2d position, Dimension dimension) {
        this.position = position;
        this.dimension = dimension;
    }

    public GameObject(GameObject go) {
        this.position = new Vector2d(go.position);
        this.dimension = new Dimension(go.dimension);
        this.color = new Color(go.color.getRGB());
        this.renderMode = go.renderMode;
    }

    @Override
    public Vector2d getPosition() {
        return position;
    }

    public GameObject setPosition(Vector2d position) {
        this.position = position;
        return this;
    }

    @Override
    public Dimension getDimension() {
        return dimension;
    }

    public GameObject setDimension(Dimension dimension) {
        this.dimension = dimension;
        return this;
    }

    public RenderMode getRenderMode() {
        return renderMode;
    }

    public GameObject setRenderMode(RenderMode renderMode) {
        this.renderMode = renderMode;
        return this;
    }

    @Override
    public Color getColor() {
        return color;
    }

    public GameObject setColor(Color color) {
        this.color = color;
        return this;
    }
}
