"# Deutsche-Bank" 
1.	There is a binary search tree. It is required to develop a method getMaxDepth(BinaryNode root) which returns the maximum depth of the tree. 
2.	Develop a program which reverses the one-way linked list. 
3.	Develop a program which solves the following task: Find one of the numbers which exists in each of three nondecreasing arrays x[p], y[q], z[r]. Algorithm complexity should be O(p+q+r). 
4.	Develop a program which solves the following task: In the office each visitor’s arrival and departure times are registered. So at the end of the day for N visitors there are N pairs of values: the first value in pair is arrival time and the second – departure time. Need to find time interval during the day when there are maximum visitors in the office. 
5.	What does method1 do? How could you improve it? 
public static int method1 (int a, int n){
int p = 0; 
if (n==0) { 
p=1; 
} else if (n % 2 == 0) { //'%' in Java - modulus operator 
p = method1(a, n/2)*method1(a, n/2); 
} else { p = method1(a, n-1)*a; } 
return p; 
} 
6.	It is required to swap values of two integer variables without using any additional memory. 
7.	Логическая задача (так и будет на русском языке). В стакане находятся бактерии. Через секунду каждая из бактерий делится пополам, затем каждая из получившихся бактерий через секунду делится пополам и так далее. Через минуту стакан полон. Через какое время стакан был заполнен наполовину.

1.	Существует двоичное дерево поиска. Требуется разработать метод getMaxDepth (корень BinaryNode), который возвращает максимальную глубину дерева.
2.	Разработать программу, которая реверсирует односторонний связанный список.
3.	Разработайте программу, которая решает следующую задачу: Найдите одно из чисел, которое существует в каждом из трех неубывающих массивов x [p], y [q], z [r]. Сложность алгоритма должна быть O (p + q + r).
4.	В офисе регистрируется время прибытия и отправления каждого посетителя. Так в конце дня
N посетителей есть N пар значений: первое значение в паре-время прибытия и второе –
время вылета. Нужно найти интервал времени в течение дня, когда максимальное количество посетителей в офисе.

5.	//Это возведение в степень числа с основанием a и степенью n.
// Смысл в т.е. произведение сомножителей
// Если число нечётное, то сначала выполняется p = method1(a, n - 1) * a;
// Если чётное, то предыдущий шаг в начале пропускается.
// Потом произведение сомножителей p = method1(a, n / 2) * method1(a, n / 2);
// При достижении n = 1 выполняется p = method1(a, n - 1) * a, где n -1 == 0,
// т.е.  при (n == 0) {p = 1} и эта 1 умножается на число a.

// Итого: при p > 0 мы всегда доходим до  p = method1(a, n - 1) * a, за исключением первоначального p = 0.
6.	Требуется поменять местами значения двух целочисленных переменных без использования дополнительной памяти.

7.	Т.к. через 1 секунду 1 бактерия делится пополам, то N , бактерий тоже поделятся пополам и их станет 2N, т.е. если стакан заполнился за 1 минуту полностью, то за 1 мин – 1 сек. = 59 сек. Наполовину. 


