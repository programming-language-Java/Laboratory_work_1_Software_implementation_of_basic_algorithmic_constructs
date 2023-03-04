import java.util.Scanner;

public class MatrixWork {
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        matrix.create();
        matrix.print();
        matrix.addMaxAndMinElement();
        matrix.printMaxAndMinElement();
        matrix.swapMaxAndMinElement();
        System.out.println("Поменяли местами максимальный и минимальный элемент");
        matrix.print();
    }
}

class Matrix {
    int[][] matrix;
    int height;
    int width;
    int maxElement;
    int maxRowIndex;
    int maxColumnIndex;
    int minElement;
    int minRowIndex;
    int minColumnIndex;
    int min = -100;
    int max = 100;

    public Matrix() {
        set();
        matrix = new int[height][width];
    }

    public void set() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Введите высоту прямоугольной матрицы: ");
            height = sc.nextInt();
            System.out.print("Введите ширину прямоугольной матрицы: ");
            width = sc.nextInt();
            if (height == width || height == 0 || width == 0)
                System.out.println("Вы ввели размеры не прямоугольной матрицы. Попробуйте ещё раз");
        } while (height == width || height == 0 || width == 0);
    }

    public void create() {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                matrix[i][j] = getRandomNumberInRange(min, max);
    }

    public int getRandomNumberInRange(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public void print() {
        System.out.println("Матрица:");
        for (int[] row : matrix)
            printRow(row);
    }

    public void printRow(int[] row) {
        for (int i : row)
            printElement(i);
        System.out.println();
    }

    public void printElement(int element) {
        int length = (int) (Math.log10(Math.abs(element)) + 1);
        String tabbedNumber = element + "\t";
        if (length == 3 && element < 0)
            System.out.print(element);
        else if (length == 3 || element < 0)
            System.out.print(tabbedNumber);
        else
            System.out.print(" " + tabbedNumber);
    }

    public void addMaxAndMinElement() {
        maxElement = matrix[0][0];
        minElement = matrix[0][0];
        for (int row = 0; row < matrix.length; row++)
            for (int column = 0; column < matrix[row].length; column++) {
                addMaxElement(row, column);
                addMinElement(row, column);
            }
    }

    public void addMaxElement(int row, int column) {
        if (matrix[row][column] > maxElement) {
            maxElement = matrix[row][column];
            maxRowIndex = row;
            maxColumnIndex = column;
        }
    }

    public void addMinElement(int row, int column) {
        if (matrix[row][column] < minElement) {
            minElement = matrix[row][column];
            minRowIndex = row;
            minColumnIndex = column;
        }
    }

    public void swapMaxAndMinElement() {
        matrix[maxRowIndex][maxColumnIndex] = minElement;
        matrix[minRowIndex][minColumnIndex] = maxElement;
    }

    public void printMaxAndMinElement() {
        printMaxElement();
        printMinElement();
    }

    public void printMaxElement() {
        System.out.println("Максимальный элемент матрицы:");
        System.out.println("\tСтрока: " + (maxRowIndex + 1));
        System.out.println("\tСтолбец: " + (maxColumnIndex + 1));
        System.out.println("\tЭлемент: " + maxElement);
    }

    public void printMinElement() {
        System.out.println("Минимальный элемент матрицы:");
        System.out.println("\tСтрока: " + (minRowIndex + 1));
        System.out.println("\tСтолбец: " + (minColumnIndex + 1));
        System.out.println("\tЭлемент: " + minElement);
    }
}
