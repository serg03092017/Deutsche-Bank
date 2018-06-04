package Deutsche;

import java.io.IOException;
import java.util.Scanner;

/*
It is required to swap values of two integer variables without using any additional memory

Требуется поменять местами значения двух целочисленных переменных без использования дополнительной памяти.*/
public class Example6 {
    public static void main(String args[]) throws IOException {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите a: ");
        int a = in.nextInt();
        System.out.print("Введите b: ");
        int b = in.nextInt();


        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("new a =" + a + ", new b=" + b);
    }
}
