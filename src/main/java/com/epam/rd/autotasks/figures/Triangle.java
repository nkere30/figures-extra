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
        if(isDegenerativeTriangle(a, b, c)) throw new IllegalArgumentException();
    }

    @Override
    public Point centroid() {
        return triangleCentroid(a, b, c);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        return Objects.equals(getClass(),figure.getClass()) &&
                (Math.abs(figure.centroid().getX() - centroid().getX()) < DELTA) &&
                (Math.abs(figure.centroid().getY() - centroid().getY()) < DELTA) &&
                (Math.abs(figure.area() - area()) < DELTA);
    }

    /*
    Calculates area of the figure.
     */
    @Override
    public double area() {
        double halfPerimeter = (distance(a, b) + distance(b, c) + distance(a, c))/2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - distance(a, b)) * (halfPerimeter - distance(b, c)) * (halfPerimeter - distance(a, c)));
    }

}
