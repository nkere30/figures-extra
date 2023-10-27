package com.epam.rd.autotasks.figures;

import java.util.Objects;

class Circle extends Figure{
    private Point center;
    private double radius;
    private static final double DELTA = 1e-10;
    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
        if(!isNotDegenerative()) throw new IllegalArgumentException();
    }

    @Override
    public Point centroid() {
        return center;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        return Objects.equals(getClass(),figure.getClass()) && (Objects.equals(centroid(), center)) && (Math.abs((Math.sqrt(figure.area()/Math.PI) - radius)) < DELTA);
    }

    @Override
    public boolean isNotDegenerative() {
        return radius > 0 && center != null;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
}
