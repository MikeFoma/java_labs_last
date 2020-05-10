package com.company.Figures;

import com.company.Interface.Shape;

public class Circle implements Shape {
    @Override
    public double getPerimeter() {
        double perimeter;

        perimeter = 2 * Math.PI * radius;

        return perimeter;
    }

    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }
}
