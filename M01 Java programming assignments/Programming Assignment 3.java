import java.util.Scanner;

public class IdenticalArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter list1: ");
        int[][] list1 = new int[3][3];
        for (int i = 0; i < list1.length; i++)
            for (int j = 0; j < list1[i].length; j++)
                list1[i][j] = input.nextInt();

        System.out.print("Enter list2: ");
        int[][] list2 = new int[3][3];
        for (int i = 0; i < list2.length; i++)
            for (int j = 0; j < list2[i].length; j++)
                list2[i][j] = input.nextInt();

        System.out.println("The two arrays are " + (equals(list1, list2) ? "identical" : "not identical"));
    }

    public static boolean equals(int[][] m1, int[][] m2) {
        if (m1.length != m2.length) return false;

        for (int i = 0; i < m1.length; i++) {
            if (m1[i].length != m2[i].length) return false;

            for (int j = 0; j < m1[i].length; j++) {
                if (m1[i][j] != m2[i][j]) return false;
            }
        }

        return true;
    }
}
