package ru.vsu.cs.course1;


import java.util.ArrayList;

public class Task {

    public static int[][] solution(int[][] matrix){
        // в матрице в каждой строке 3 числа: x координата, y координата и радиус одний окружности.
        ArrayList<Circle> circles = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            Circle c = new Circle(matrix[i][0], matrix[i][1], matrix[i][2]);
            circles.add(c);
        }
        int[] intersectionCounter = new int[matrix.length];

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
        for(int i = 0; i < matrix.length - 1; i++){
            for(int k = i + 1; k < matrix.length; k++){
                double distanceBetweenCenters = Math.sqrt((matrix[i][0]-matrix[k][0])*(matrix[i][0]-matrix[k][0]) + (matrix[i][1]-matrix[k][1])*(matrix[i][1]-matrix[k][1]));
                if(distanceBetweenCenters <= matrix[i][2]+matrix[k][2]){
                    intersectionCounter[i]++;
                    intersectionCounter[k]++;
                }
            }
        }
        int counterOfTrueCircles = 0;
        for(int n = 0; n < intersectionCounter.length; n++){          // считаем количество подходящих окружностей, чтобы после создать матрицу с таким же количеством строк.
            if(intersectionCounter[n] == 0){
                counterOfTrueCircles++;
            }
        }
        int[][] trueCircles = new int[counterOfTrueCircles][3];
        int index = 0;
        for(int n = 0; n < intersectionCounter.length; n++){          // заполняем возвращаемый двумерный массив параметрами непересекающихся ни с чем окружностей.
            if(intersectionCounter[n] == 0){
                trueCircles[index] = matrix[n];
                index++;
            }
        }
        return trueCircles;
    }
}
