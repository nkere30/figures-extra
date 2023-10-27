package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure{
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    @Override
    public Point centroid() {
        return null;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        return false;
    }

    @Override
    public boolean isNotDegenerative() {
        return false;
    }

    @Override
    public double area() {
        return 0;
    }
}
