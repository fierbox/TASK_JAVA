package task2;import java.util.Objects;

public class Point {
    float x;
    float y;

    @Override
    public boolean equals(Object o) {
        final float threshold = 0.0001f;
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return (Math.abs(point.getX()-getX()) < threshold) & (Math.abs(point.getY()-getY()) < threshold);
        //Float.compare(point.getX(), getX()) == 0 && Float.compare(point.getY(), getY()) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(getX(), getY());
    }

    public Point(float x, float y) {

        this.x = x;
        this.y = y;
    }

    public void setX(float x) {

        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {

        return x;
    }

    public float getY() {
        return y;
    }
}