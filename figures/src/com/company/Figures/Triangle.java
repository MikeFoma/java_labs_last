package com.company.Figures;

import com.company.Interface.Shape;

public class Triangle implements Shape {
    @Override
    public double getPerimeter() {
        double perimeter;

        perimeter = top_a + top_b + top_c;

        return perimeter;
    }

    private double top_a, top_b, top_c;

    public double getTop_a() {
        return top_a;
    }

    public void setTop_a(double top_a) {
        this.top_a = top_a;
    }

    public double getTop_b() {
        return top_b;
    }

    public void setTop_b(double top_b) {
        this.top_b = top_b;
    }

    public double getTop_c() {
        return top_c;
    }

    public void setTop_c(double top_c) {
        this.top_c = top_c;
    }

    public Triangle(double top_a, double top_b, double top_c) {
        this.top_a = top_a;
        this.top_b = top_b;
        this.top_c = top_c;
    }
}
