import java.util.HashMap;
import java.util.Scanner;

//class Matrix{
//    int height;
//    int width;
//
//}

public class MatrixWork {
    public static void main(String[] args) {
        int[][] matrix = getMatrix();
        System.out.println("Исходная матрица:");
        print(matrix);
        swapMaxAndMinElement(matrix);
        System.out.println("Изменённая матрица:");
        print(matrix);
    }

    public static int[][] getMatrix() {
        HashMap<String, Integer> heightAndWidth = queryUserForHeightAndWidth();
        int height = heightAndWidth.get("height"), width = heightAndWidth.get("width");
        int[][] matrix = new int[height][width];
        fillInMatrix(matrix);
        return matrix;
    }

    public static HashMap<String, Integer> queryUserForHeightAndWidth() {
        Scanner sc = new Scanner(System.in);
        int height, width;
        do {
            System.out.print("Введите высоту прямоугольной матрицы: ");
            height = sc.nextInt();
            System.out.print("Введите ширину прямоугольной матрицы: ");
            width = sc.nextInt();
            if (height == width)
                System.out.println("Вы ввели размеры не прямоугольной матрицы. Попробуйте ещё раз");
        } while (height == width);

        HashMap<String, Integer> heightAndWidth = new HashMap<String, Integer>();
        heightAndWidth.put("height", height);
        heightAndWidth.put("width", width);
        return heightAndWidth;
    }

    public static void fillInMatrix(int[][] matrix) {
        int min = -100, max = 100;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = getRandomNumberInRange(min, max);
            }
        }
    }

    public static int getRandomNumberInRange(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static void print(int[][] matrix) {
        for (int[] row : matrix)
            printRow(row);
    }

    public static void printRow(int[] row) {
        for (int i : row) {
            int length = (int) (Math.log10(Math.abs(i)) + 1);
            String tabbedNumber = i + "\t";
            if (length == 3 && i < 0)
                System.out.print(i);
            else if (length == 3 || i < 0)
                System.out.print(tabbedNumber);
            else
                System.out.print(" " + tabbedNumber);
        }
        System.out.println();
    }


    public static HashMap<String, Integer> getMaxElementData(int[][] matrix) {
        int maxElement = 0, maxRowIndex = 0, maxColumnIndex = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] > matrix[maxRowIndex][maxColumnIndex]) {
                    maxElement = matrix[row][column];
                    maxRowIndex = row;
                    maxColumnIndex = column;
                }
            }
        }
        HashMap<String, Integer> maxElementData = new HashMap<String, Integer>();
        maxElementData.put("element", maxElement);
        maxElementData.put("row", maxRowIndex);
        maxElementData.put("column", maxColumnIndex);
        return maxElementData;
    }

    public static HashMap<String, Integer> getMinElementData(int[][] matrix) {
        int minElement = 0, minRowIndex = 0, minColumnIndex = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] < matrix[minRowIndex][minColumnIndex]) {
                    minElement = matrix[row][column];
                    minRowIndex = row;
                    minColumnIndex = column;
                }
            }
        }
        HashMap<String, Integer> minElementData = new HashMap<String, Integer>();
        minElementData.put("element", minElement);
        minElementData.put("row", minRowIndex);
        minElementData.put("column", minColumnIndex);
        return minElementData;
    }

    public static void swapMaxAndMinElement(int[][] matrix) {
        HashMap<String, Integer> maxElementData = getMaxElementData(matrix);
        HashMap<String, Integer> minElementData = getMinElementData(matrix);
        int maxElement = maxElementData.get("element");
        int maxRowIndex = maxElementData.get("row");
        int maxColumnIndex = maxElementData.get("column");
        int minElement = minElementData.get("element");
        int minRowIndex = minElementData.get("row");
        int minColumnIndex = minElementData.get("column");
        matrix[maxRowIndex][maxColumnIndex] = minElement;
        matrix[minRowIndex][minColumnIndex] = maxElement;
    }
}
