package ru.vsu.cs.course1;


public class Task {

    public static int[][] solution(int[][] matrix){
        // в матрице в каждой строке 3 числа: x координата, y координата и радиус одний окружности.
        int[] intersectionCounter = new int[matrix.length];
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
