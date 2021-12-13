package it.angelobdev.engine.object;

import it.angelobdev.engine.util.Dimension;
import it.angelobdev.engine.util.Vector2d;

import java.awt.image.BufferedImage;

public abstract class TexturedObject implements IGameObject {

    protected Vector2d position;
    protected Dimension dimension;
    protected BufferedImage texture;

    public TexturedObject(Vector2d position, Dimension dimension, BufferedImage texture) {
        this.position = position;
        this.dimension = dimension;
        this.texture = texture;
    }

    @Override
    public Vector2d getPosition() {
        return position;
    }

    @Override
    public Dimension getDimension() {
        return dimension;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TexturedObject)) return false;

        TexturedObject that = (TexturedObject) o;

        if (getPosition() != null ? !getPosition().equals(that.getPosition()) : that.getPosition() != null)
            return false;
        if (getDimension() != null ? !getDimension().equals(that.getDimension()) : that.getDimension() != null)
            return false;
        return getTexture() != null ? getTexture().equals(that.getTexture()) : that.getTexture() == null;
    }

    @Override
    public int hashCode() {
        int result = getPosition() != null ? getPosition().hashCode() : 0;
        result = 31 * result + (getDimension() != null ? getDimension().hashCode() : 0);
        result = 31 * result + (getTexture() != null ? getTexture().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TexturedObject:\nPosition: " + position + "\nDimension: " + dimension;
    }
}
