package com.epam.rd.autotasks.figures;

class Point {
    private double x;
    private double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if(getClass()!=obj.getClass()) return false;
        Point newPoint = (Point) obj;
        return (newPoint.getX() == x) && (newPoint.getY() == y);
    }
}
