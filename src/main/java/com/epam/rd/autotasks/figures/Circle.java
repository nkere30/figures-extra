package com.epam.rd.autotasks.figures;

import java.util.Objects;

class Circle extends Figure{
    private Point center;
    private double radius;
    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
        if(radius <= 0 || center == null) throw new IllegalArgumentException();
    }

    @Override
    public Point centroid() {
        return center;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        return Objects.equals(getClass(),figure.getClass()) &&
                (Math.abs(figure.centroid().getX() - center.getX()) < DELTA) &&
                (Math.abs(figure.centroid().getY() - center.getY()) < DELTA) &&
                (Math.abs(figure.area() - area()) < DELTA);
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
}
