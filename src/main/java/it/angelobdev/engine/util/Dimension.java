package it.angelobdev.engine.util;

public class Dimension {

    private double width, height;

    public Dimension(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Dimension(Dimension dim) {
        this.width = dim.width;
        this.height = dim.height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dimension)) return false;

        Dimension dimension = (Dimension) o;

        if (Double.compare(dimension.getWidth(), getWidth()) != 0) return false;
        return Double.compare(dimension.getHeight(), getHeight()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getWidth());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getHeight());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Dimension: (" + width + ", " + height + ");";
    }
}
