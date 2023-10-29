package com.epam.rd.autotasks.figures;

import java.util.Objects;

class Quadrilateral extends Figure{
    private Point a;
    private Point b;
    private Point c;
    private Point d;
    Point[] points;
    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        points = new Point[]{a, b, c, d};
        if (isDegenerative() || !isConvex()) throw new IllegalArgumentException();
    }
    @Override
    public Point centroid() {
        Point firstLineStart = triangleCentroid(b, c, d);
        Point secondLineStart = triangleCentroid(a, c, d);
        Point firstLineEnd = triangleCentroid(a, b, d);
        Point secondLineEnd = triangleCentroid(a, b, c);
        return intersectionPoint(firstLineStart, secondLineStart, firstLineEnd, secondLineEnd);
    }

    /*
    Returns point of intersection of two line segments.
     */
    private Point intersectionPoint(Point firstLineStart, Point secondLineStart,  Point firstLineEnd, Point secondLineEnd) {
        double x1 = firstLineStart.getX();
        double x2 = firstLineEnd.getX();
        double x3 = secondLineStart.getX();
        double x4 = secondLineEnd.getX();

        double y1 = firstLineStart.getY();
        double y2 = firstLineEnd.getY();
        double y3 = secondLineStart.getY();
        double y4 = secondLineEnd.getY();

        double t = ((x1 - x3) * (y3 - y4) - (y1 - y2) * (x3 - x4))/((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
        double intersectionX = x1 + t * (x2 - x1);
        double intersectionY = y1 + t * (y2 - y1);
        return new Point(intersectionX, intersectionY);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        return Objects.equals(getClass(),figure.getClass()) &&
                (Math.abs(figure.centroid().getX() - centroid().getX()) < DELTA) &&
                (Math.abs(figure.centroid().getY() - centroid().getY()) < DELTA) &&
                (Math.abs(figure.area() - area()) < DELTA);
    }

    @Override
    public double area() {
        return (new Triangle(a, b, d).area() + new Triangle(b, c, d).area());
    }

    /*
    Checks if quadrilateral is degenerative and returns true if it is.
     */
    public boolean isDegenerative() {
        return (isDegenerativeTriangle(a, b, c)
                || isDegenerativeTriangle(b, c, d)
                || isDegenerativeTriangle(c, d, a)
                || isDegenerativeTriangle(d, a, b));
    }

    /*
    Checks if quadrilateral is convex and returns true if it is.
     */
    public boolean isConvex() {
        boolean isNegative = false;
        boolean isPositive = false;
        int nOfPoints = points.length;
        int B, C;
        for (int A = 0; A < nOfPoints; A++) {
            B = (A + 1) % nOfPoints;
            C = (B + 1) % nOfPoints;

            double product =
                    prodLength(
                            points[A].getX(), points[A].getY(),
                            points[B].getX(), points[B].getY(),
                            points[C].getX(), points[C].getY());
            if (product < 0) {
                isNegative = true;
            } else if (product > 0) {
                isPositive = true;
            }
            if (isNegative && isPositive) return false;
        }
        return true;
    }
    /*
    Returns length of a product of points
     */
    public double prodLength(double aX, double aY, double bX, double bY, double cX, double cY) {
        double baX = aX - bX;
        double baY = aY - bY;
        double bcX = cX - bX;
        double bcY = cY - bY;

        return (baX * bcY - baY * bcX);
    }
}
