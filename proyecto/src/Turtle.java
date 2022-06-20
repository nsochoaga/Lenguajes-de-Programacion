import java.awt.*;

public class Turtle {

    private double x, y;
    private double angle;

    public Turtle(double x0, double y0, double a0) {
        x = x0;
        y = y0;
        angle = a0;
    }

    public void turnLeft(double delta) {
        angle += delta;
    }

    public void  goForward(double step) {
        double oldx = x;
        double oldy = y;
        x += step * Math.cos(Math.toRadians(angle));
        y += step * Math.sin(Math.toRadians(angle));
        StdDraw.line(oldx, oldy, x, y);

    }

    public void show() {
        StdDraw.show();
    }

    public void pause(int t) {
        StdDraw.pause(t);
    }

    public void setPenColor(Color color) {
        StdDraw.setPenColor(color);
    }

    public void setPenRadius(double radius) {
        StdDraw.setPenRadius(radius);
    }

    public void setCanvasSize(int width, int height) {
        StdDraw.setCanvasSize(width, height);
    }

    public void setXscale(double min, double max) {
        StdDraw.setXscale(min, max);
    }

    public void setYscale(double min, double max) {
        StdDraw.setYscale(min, max);
    }

    public void circle(double x, double y, double radius) {
        StdDraw.circle(x, y, radius);
    }

    public void filledCircle(double x, double y, double radius) {
        StdDraw.filledCircle(x, y, radius);
    }

    public void  text(double x, double y, String text, Color color) {
        StdDraw.text(x, y, text, color);
    }


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

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
}
