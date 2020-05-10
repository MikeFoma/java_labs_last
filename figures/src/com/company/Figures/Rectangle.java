package com.company.Figures;

import com.company.Interface.Shape;

public class Rectangle implements Shape {
    @Override
    public double getPerimeter() {
        double perimeter;

        perimeter = 2 * ( side_a + side_b );

        return perimeter;
    }

    private double side_a, side_b;

    public double getSide_a() {
        return side_a;
    }

    public void setSide_a(double side_a) {
        this.side_a = side_a;
    }

    public double getSide_b() {
        return side_b;
    }

    public void setSide_b(double side_b) {
        this.side_b = side_b;
    }

    public Rectangle(double side_a, double side_b) {
        this.side_a = side_a;
        this.side_b = side_b;
    }

}
