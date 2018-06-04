package Deutsche;
/*
Develop a program which solves the following task:
Find one of the numbers which exists in each of three nondecreasing arrays x[p], y[q], z[r].
Algorithm complexity should be O(p+q+r).

Разработайте программу, которая решает следующую задачу:
Найдите одно из чисел, которое существует в каждом из трех неубывающих массивов x [p], y [q], z [r].
Сложность алгоритма должна быть O (p + q + r).
*/

public class Example3 {
    public static void main(String args[]) {

        int[] x = new int[]{2, 7, 12, 17, 18, 19, 22, 27, 31, 36, 41};
        int[] y = new int[]{3, 8, 11, 17, 22, 25, 31, 36, 39};
        int[] z = new int[]{5, 9, 13, 16, 19, 22, 24, 26, 28, 30, 31, 33};

        int p1 = 0;
        int q1 = 0;
        int r1 = 0;
        while (!((x[p1] == y[q1]) & (y[q1] == z[r1]))) {

            if (x[p1] < y[q1]) {
                p1 = p1 + 1;
            } else {
                if (y[q1] < z[r1]) {
                    q1 = q1 + 1;
                } else {
                    if (z[r1] < x[p1]) {
                        r1 = r1 + 1;
                    }
                }
            }
            if ((x[p1] == y[q1]) & (y[q1] == z[r1])) {
                System.out.println(x[p1]);
            }

        }

    }
}
