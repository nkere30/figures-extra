package com.epam.rd.autotasks.figures;

import java.util.Objects;

abstract class Figure{
    public static final double DELTA = 1e-10;
    public abstract Point centroid();
    public abstract boolean isTheSame(Figure figure);

    public abstract double area();
    public boolean isDegenerativeTriangle(Point a, Point b, Point c) {
        return (Objects.isNull(a) || Objects.isNull(b) || Objects.isNull(c)) ||
                ((distance(a, b) <= 0) || (distance(b, c) <= 0) || (distance(a, c) <= 0))
                || ((distance(a, b) + distance(b, c)) <= distance(a, c))
                || ((distance(a, b) + distance(a, c)) <= distance(b, c))
                || ((distance(a, c) + distance(b, c)) <= distance(a, b))
                || (slope(a, b)==slope(b, c) && slope(b, c)==slope(a,c));
    }
    /*
    Returns length of the distance, takes start and end points as parameters
     */
    public double distance(Point start, Point end) {
        return Math.sqrt(Math.pow(end.getX() - start.getX(), 2) + Math.pow(end.getY() - start.getY(), 2));
    }
    /*
    Calculates the slope the line segment, with given start and end points.
     */
    public double slope(Point start, Point end) {
        return (end.getY() - start.getY())/(end.getX() - start.getX());
    }
    public Point triangleCentroid(Point a, Point b, Point c) {
        return new Point( 1.0 /3.0 * (a.getX() + b.getX() + c.getX()),  1.0 /3.0 *(a.getY() + b.getY() + c.getY()));
    }
}
