package shapes;
//import shapes;

//package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        final String fileIn = "shapes/shapes.txt";
        int lineN = 0;
        Shape[] shapes;

        System.out.println("------->JAC 444 Assignment 7<------");

        //Running the tasks...
        System.out.printf("------->Task 1 ... <-------%n");//=================================
        try {
            Path path = Paths.get(fileIn);
            lineN = (int)Files.lines(path).count();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        shapes = new Shape[(int) lineN];
        String text;
        int shapesN = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileIn))){
            while((text = br.readLine()) != null) {
                String[] tokens = text.split(",");
                try {
                    Shape shape  = getShape(tokens);
                    if(shape != null ) {
                        shapes[shapesN] = shape;
                        shapesN++;
                    }
                }catch(Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.printf("%n%s shapes were created: %n", shapesN);
        displayResult(shapes);

        System.out.printf("------->Task 2 ... <-------%n");//=================================
        delMinPerimTriangleData(shapes);
        delMaxPerimTriangleData(shapes);
        displayResult(shapes);

        System.out.printf("------->Task 3 ... <-------%n");//=================================
        double pTotal = getTotParall(shapes);
        double tTotal = getTotTrian(shapes);
        displayTotal(pTotal, tTotal);

    }

    //======================================================================================
    //======================================================================================


    //======================================================================================
    //======================================================================================
    //==================================TASK 2 FUNCTIONS====================================
    private static void delMinPerimTriangleData(Shape[] shapes) {
        double minPeri = 100.0;
        for(Shape triangle: shapes) {
            if(triangle instanceof Triangle) {
                if( minPeri > triangle.getPerimeter()) {
                    minPeri = triangle.getPerimeter();
                }
            }
        }
        for(int i = 0; i < shapes.length; i++) {
            if(shapes[i] instanceof Triangle) {
                if( shapes[i].getPerimeter() == minPeri) {
                    shapes[i] = null;
                }
            }
        }
    }

    private static void delMaxPerimTriangleData(Shape[] shapes) {
        double maxPeri = 0.0;
        for(Shape circle: shapes) {
            if(circle instanceof Circle) {
                if( circle.getPerimeter() > maxPeri) {
                    maxPeri = circle.getPerimeter();
                }
            }
        }
        for(int i =0; i < shapes.length; i++) {
            if(shapes[i] instanceof Circle) {
                if( shapes[i].getPerimeter() == maxPeri) {
                    shapes[i] = null;
                }
            }
        }
    }

    private static void displayResult(Shape[] shapes) {
        for(Shape shape: shapes) {
            if(shape != null) {
                System.out.printf("%s perimeter = %g %n%n", shape.toString(), shape.getPerimeter());
            }
        }
    }
    //======================================================================================
    //======================================================================================

    //======================================================================================
    //======================================================================================
    //==================================TASK 3 FUNCTIONS====================================

    private static double getTotParall(Shape[] shapes) {
        double total = 0.0;
        for(Shape p: shapes) {
            if(p instanceof Parallelogram && !(p instanceof Square) && !(p instanceof Rectangle)) {
                total += p.getPerimeter();
            }
        } return total;
    }

    private static double getTotTrian(Shape[] shapes) {
        double total = 0.0;
        for(Shape t: shapes) {
            if(t != null && t instanceof Triangle) {
                total += t.getPerimeter();
            }
        } return total;
    }

    private static void displayTotal(double pTotal, double tTotal) {
        System.out.printf("Total perimeter of Parallelogram is:%s %n%n", pTotal);
        System.out.printf("Total perimeter of Triangle is:%.3g %n%n", tTotal);
    }

    //======================================================================================
    //======================================================================================

    //======================================================================================
    //======================================================================================
    //==================================SHAPES SELECTION====================================

    private static Shape getShape(String[] tokens)
            throws CircleException, //Throwing the exception classes in case of error.
            SquareException,
            ParallelogramException,
            TriangleException {
        Shape shape = null;
        switch(tokens[0]) {
            case "Circle":
                if(tokens.length == 2) {
                    shape = new Circle(parseDouble(tokens[1]));
                }
                break;
            case "Square":
                if(tokens.length == 2) {
                    shape= new Square(parseDouble(tokens[1]));
                }
                break;
            case "Parallelogram":
                if(tokens.length == 3) {
                    shape = new Parallelogram(parseDouble(tokens[1]),parseDouble(tokens[2]));
                }
                break;
            case "Rectangle":
                if(tokens.length == 3) {
                    shape = new Rectangle(parseDouble(tokens[1]),parseDouble(tokens[2]));
                }
                break;
            case "Triangle":
                if(tokens.length == 4) {
                    shape = new Triangle(parseDouble(tokens[1]),parseDouble(tokens[2]), parseDouble(tokens[3]));
                }
                break;
            default:
                break;
        } return shape;
    }

    private static double parseDouble(String s) {
        return Double.parseDouble(s);
    }

    //======================================================================================
    //======================================================================================
}


