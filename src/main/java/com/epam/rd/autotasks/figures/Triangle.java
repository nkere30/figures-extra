package com.epam.rd.autotasks.figures;

import java.util.Objects;

class Triangle extends Figure{
    private Point a;
    private Point b;
    private Point c;
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        if(!isNotDegenerative()) throw new IllegalArgumentException();
    }

    @Override
    public Point centroid() {
        return new Point( 1.0 /3 * (a.getX() + b.getX() + c.getX()),  1.0 /3 *(a.getY() + b.getY() + c.getY()));
    }

    @Override
    public boolean isTheSame(Figure figure) {
        return false;
    }

    /*
    Calculates area of the figure.
     */
    @Override
    public double area() {
        double halfPerimeter = (side(a, b) + side(b, c) + side(a, c))/2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - side(a, b)) * (halfPerimeter - side(b, c)) * (halfPerimeter - side(a, c)));
    }

    /*
    Checks if triangle with given sides can exist or not.
     */
    @Override
    public boolean isNotDegenerative() {
        return (!Objects.isNull(a) && !Objects.isNull(b) && !Objects.isNull(c)) &&
                ((side(a, b) > 0) && (side(b, c) > 0) && (side(a, c) > 0))
                && ((side(a, b) + side(b, c)) > side(a, c))
                && ((side(a, b) + side(a, c)) > side(b, c))
                && ((side(a, c) + side(b, c)) > side(a, b))
                && !(slope(a, b)==slope(b, c) && slope(b, c)==slope(a,c));
    }

    /*
    Returns length of the side, takes start and end points as parameters
     */
    public double side(Point start, Point end) {
        return Math.sqrt(Math.pow(end.getX() - start.getX(), 2) + Math.pow(end.getY() - start.getY(), 2));
    }

    /*
    Calculates the slope the line segment, with given start and end points.
     */
    public double slope(Point start, Point end) {
        return (end.getY() - start.getY())/(end.getX() - start.getX());
    }
}
