package it.angelobdev.engine.object.defaults;

import it.angelobdev.engine.object.GameObject;

import java.awt.*;

public class Triangle extends GameObject {

    private Shape trian;

    public Triangle(double x, double y, double base, double height) throws NoSuchMethodException {
        throw new NoSuchMethodException("Not yet implemented!");
//        this.position = new Vector2d(x, y);
//        this.dimension = new Dimension(base, height);
    }
//
//    @Override
//    public void render(Graphics g) {
//        super.render(g);
//
//        int x = (int) position.getX();
//        int y = (int) position.getY();
//        int base = (int) dimension.getWidth();
//        int height = (int) dimension.getHeight();
//
//        switch (renderMode) {
//            case STROKE:
//                g.draw(x, y, SMA, sma);
//                break;
//            case FILL:
//                g.fillRect(x, y, SMA, sma);
//                break;
//            case FULL:
//                g.drawOval(x, y, SMA, sma);
//                g.fillRect(x, y, SMA, sma);
//                break;
//        }
//    }
}
