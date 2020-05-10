package com.company;

import com.company.Figures.Circle;
import com.company.Figures.Rectangle;
import com.company.Figures.Triangle;

import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {


    public static void main(String[] args) {
	// write your code here
        HashMap<Double, String> figure_perimeters = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            int random_figure = (int)(Math.random() * 3);

            switch (random_figure) {
                case 0:
                    Circle circle = new Circle((double)(Math.random() * 10 + 5));
                    figure_perimeters.put(circle.getPerimeter(), "Circle");
                    break;
                case 1:
                    Triangle triangle = new Triangle( (double)(Math.random() * 10 + 5),
                            (double)(Math.random() * 10 + 5), (double)(Math.random() * 10 + 5) );
                    figure_perimeters.put(triangle.getPerimeter(), "Triangle");
                    break;
                case 2:
                    Rectangle rectangle = new Rectangle( (double)(Math.random() * 10 + 5), (double)(Math.random() * 10 + 5) );
                    figure_perimeters.put(rectangle.getPerimeter(), "Rectangle");
                    break;
                default:
                    System.out.println("Error.");
                    break;
            }
        }
        
        System.out.println("Print figures:");
        figure_perimeters.forEach((perimeter,figure) -> System.out.println("Figure: " + figure +
                " Perimeter:" + perimeter));

        SortedSet<Double> sort_rectangle = new TreeSet<>(figure_perimeters.keySet());
        
        System.out.println();
        System.out.println();

        System.out.println( "Max perimeter: " + sort_rectangle.last() +
                " and it is: " +  figure_perimeters.get(sort_rectangle.last()) );
        System.out.println( "Min perimeter: " + sort_rectangle.first() +
                " and it is: " +  figure_perimeters.get(sort_rectangle.first()) );

    }
}
