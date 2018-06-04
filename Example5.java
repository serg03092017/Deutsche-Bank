package Deutsche;
/*
Узнать что делает данный метод. Это возведение в степень неотрицательного числа
*/
public class Example5 {
    public static int method1(int a, int n) {
        int p = 0;
        if (n == 0) {
            p = 1;
        } else if (n % 2 == 0) { //'%' in Java - modulus operator
            p = method1(a, n / 2) * method1(a, n / 2);
        } else {
            p = method1(a, n - 1) * a;
        }
        return p;
    }

    public static void main(String args[]) {
        System.out.println(method1(3, 0));
        System.out.println(method1(3, 4));
        System.out.println(method1(-3, 5));
    }
}

//Это возведение в степень числа с основанием a и степенью n.
// Смысл в т.е. произведение сомножителей
// Если число нечётное, то сначала выполняется p = method1(a, n - 1) * a;
// Если чётное, то предыдущий шаг в начале пропускается.
// Потом произведение сомножителей p = method1(a, n / 2) * method1(a, n / 2);
// При достижении n = 1 выполняется p = method1(a, n - 1) * a, где n -1 == 0,
// т.е.  при (n == 0) {p = 1} и эта 1 умножается на число a.

// Итого: при p > 0 мы всегда доходим до  p = method1(a, n - 1) * a, за исключением первоначального p = 0.


