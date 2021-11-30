package com.cm2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Double[][]> data = new ArrayList<>();
        data.add(new Double[][] {
                {2.0, 1.0, -1.0, 1.0, 2.7},
                {0.4, 0.5, 4.0, -8.5, 21.9},
                {0.3, -1.0, 1.0, 5.2, -3.9},
                {1.0, 0.2, 2.5, -1.0, 9.9}
        });
        data.add(new Double[][] {
                {2.34, -4.21, -11.61, 14.41},
                {8.04, 5.22, 0.27, -6.44},
                {3.92, -7.99, 8.37, 55.56}
        });
        data.add(new Double[][] {
                {1.0, 10.0, -5.0, 1.0},
                {1.01, 9.99, -5.01, 2.0},
                {0.99, 1.01, -4.99, 3.0}
        });

        for (int i = 0; i < data.size(); i++) {
            gauss(data.get(i),1);
        }

    }

    public static Double[] gauss(Double[][] matrix, int modificator) {
        int n = matrix.length;

        Double[][] matrixClone = new Double[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                matrixClone[i][j] = matrix[i][j];
            }
        }
        //прямой ход
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n+1; i++) {
                matrixClone[k][i] = matrixClone[k][i]/matrix[k][k];
            }
            for (int i = k+1; i < n; i++) {
                Double K = matrixClone[i][k]/matrixClone[k][k];
                for (int j = 0; j < n+1; j++) {
                    matrixClone[i][j] = matrixClone[i][j]-matrixClone[k][j]*K;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n+1; j++) {
                    matrix[i][j] = matrixClone[i][j];
                }
            }
        }
        //boolean r = true;
        //обратный ход
        for (int k = n-1; k > -1; k--) {
            for (int i = n; i > -1; i--) {
                matrixClone[k][i] = matrixClone[k][i]/matrix[k][k];
            }
            for (int i = k-1; i > -1; i--) {
                Double K = matrixClone[i][k] / matrixClone[k][k];
                for (int j = n; j > -1; j--) {
                    matrixClone[i][j] = matrixClone[i][j] - matrixClone[k][j] * K;
                }
            }
        }

        Double[] ans = new Double[n];
        for (int i = 0; i < n; i++) {
            ans[i]=matrixClone[i][n];
        }
        return ans;
    }
}
