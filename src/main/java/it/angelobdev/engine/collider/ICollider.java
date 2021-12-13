package it.angelobdev.engine.collider;

import it.angelobdev.engine.object.IGameObject;
import it.angelobdev.engine.util.Dimension;
import it.angelobdev.engine.util.Vector2d;

public interface ICollider {

    default IGameObject getShape() throws NoSuchMethodException {
        if (this instanceof IGameObject)
            return (IGameObject) this;
        else
            throw new NoSuchMethodException("The 'getShape' method of interface ICollider has to be implemented!");
    }

    default boolean isColliding(ICollider collider) throws NoSuchMethodException {

        IGameObject thisGO = this.getShape();
        IGameObject collGO = collider.getShape();

        Vector2d thisPOS = thisGO.getPosition();
        Vector2d collPOS = collGO.getPosition();

        Dimension thisDIM = thisGO.getDimension();
        Dimension collDIM = collGO.getDimension();

        return thisPOS.getX() < collPOS.getX() + collDIM.getWidth() &&
                thisPOS.getX() + thisDIM.getWidth() > collPOS.getX() &&
                thisPOS.getY() < collPOS.getY() + collDIM.getHeight() &&
                thisDIM.getHeight() + thisPOS.getY() > collPOS.getY();

    }

}
