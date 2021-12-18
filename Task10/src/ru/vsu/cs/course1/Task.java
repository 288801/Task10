package ru.vsu.cs.course1;


import java.util.ArrayList;

public class Task {

    public static ArrayList<Circle> convertMatrixToList(int[][] matrix){
        ArrayList<Circle> circles = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            Circle c = new Circle(matrix[i][0], matrix[i][1], matrix[i][2]);
            circles.add(c);
        }
        return circles;
    }

    public static int[][] convertListToMatrix(ArrayList<Circle> circles){
        int[][] matrix = new int[circles.size()][3];
        for(int i = 0; i < circles.size(); i++){
            matrix[i][0] = circles.get(i).getX0();
            matrix[i][1] = circles.get(i).getY0();
            matrix[i][2] = circles.get(i).getR();
        }
        return matrix;
    }

    public static ArrayList<Circle> solution(ArrayList<Circle> circles){
        // в матрице в каждой строке 3 числа: x координата, y координата и радиус одний окружности.
        int[] intersectionCounter = new int[circles.size()];

        for(int i = 0; i < circles.size()-1; i++){
            for(int k = 0; k < circles.size(); k++){
                double x1 = circles.get(i).getX0();
                double x2 = circles.get(k).getX0();
                double y1 = circles.get(i).getY0();
                double y2 = circles.get(k).getY0();
                double r1 = circles.get(i).getR();
                double r2 = circles.get(k).getR();
                double distanceBetweenCenters = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
                if(distanceBetweenCenters <= r1+r2){
                    intersectionCounter[i]++;
                    intersectionCounter[k]++;
                }
            }
        }

        ArrayList<Circle> trueCircles = new ArrayList<>();
        for(int n = 0; n < intersectionCounter.length; n++){          // заполняем возвращаемый двумерный массив параметрами непересекающихся ни с чем окружностей.
            if(intersectionCounter[n] == 0){
                trueCircles.add(circles.get(n));
            }
        }
        return trueCircles;
    }
}
