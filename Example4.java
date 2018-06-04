package Deutsche;

import java.util.*;
/*
In the office each visitor’s arrival and departure times are registered. So at the end of the day for
N visitors there are N pairs of values: the first value in pair is arrival time and the second –
departure time. Need to find time interval during the day when there are maximum visitors in
the office.
В офисе регистрируется время прибытия и отправления каждого посетителя. Так в конце дня
N посетителей есть N пар значений: первое значение в паре-время прибытия и второе –
время вылета. Нужно найти интервал времени в течение дня, когда максимальное количество посетителей в
офисе.
*/
// Для каждого человека дана пара значений: время прихода и время ухода.
// Найти в какие интервалы времени количество человек максимально
public class Example4 {

    String b[][];
    List<String> in = new LinkedList<>();
    List<String> out = new LinkedList<>();

    List<Integer> density = new <Integer>LinkedList();
    List<String> intervalArray = new LinkedList<>();

    Example4(String a[][]) {
        b = a;
        selectValidateValues(b);// выбираем нормальные значения времени начала и конца рабочего дня
        findDensity(in, out);   //находим плотность распределения людей по времени (шаг =1 минута)

        System.out.println();
        for (String m : in) {
            System.out.println(m + " in");
        }
        System.out.println();
        for (String m : out) {
            System.out.println(m + " out");
        }
        System.out.println();
        findMaxInterval(density);   //находим интервалы времени

        int count = 0; // счётчик для прохода по элементам коллекции
        System.out.println("Intervals max visitors:");
        for (String f : intervalArray) {
            if (count % 2 == 0) {
                System.out.print(f + "-");
            }
            if (count % 2 == 1) {
                System.out.print(f);
                System.out.println();
            }
            count++;
        }
    }

    private void selectValidateValues(String b[][]) {
        int k;
        char[] values = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ':'};

        for (int bi = 0; bi < b.length; bi++) {
            for (int bj = 0; bj < b[0].length; bj++) {
                k = bj;

                String s = b[bi][bj];
                //чтобы выйти надо хотя бы войти, если не вошли переходим к следующей паре значений
                if ((s == null) & (k % 2 == 0)) {
                    break;
                }
                //если вошли, но не вышли, то просто записываем в выход null
                if ((s == null) & (k % 2 == 1)) {
                    out.add(s);
                    break;
                }

                s = s.trim();
                boolean flag = true;//условие на наличие всех допустимых символов строки из значений values
                boolean flagChar;//условие на совпадение символа в строке из значений values
                for (int i = 0; i < s.length(); i++) {
                    flagChar = false;
                    for (int j = 0; j < values.length; j++) {
                        if (s.charAt(i) == values[j]) {
                            flagChar = true;
                            break;
                        }
                    }
                    if (flagChar == false) {
                        flag = false;
                        break;
                    }
                }
                //если добавили первый элемент, но второй элемент не прошёл проверку символов(при этом null как второй элемент проходит)
                if ((!flag) & (in.size() > out.size())) {
                    in.remove(in.size() - 1);
                    break;
                }
                //проверка по формату времени
                if (flag) {
                    try {
                        String[] f = s.split(":");
                        if (f[1].length() == 1)
                            throw new Exception(); //здесь допустимо формат как ЧЧ:ММ, так и Ч:ММ, а вот с минутами так нельзя
                        if ((f.length == 2) &
                                (f[0].length() < 3) & (f[0].length() > 0) &
                                (f[1].length() < 3) & (f[1].length() > 1)) {
                            byte hour = Byte.parseByte(f[0]);
                            if ((hour < 0) | (hour > 23)) {
                                throw new Exception();
                            }
                            byte min = Byte.parseByte(f[1]);
                            if ((min < 0) | (min > 59)) {
                                throw new Exception();
                            }
                            //здесь допустимо формат как ЧЧ:ММ, так и Ч:ММ, а вот с минутами так нельзя
                            if ((hour < 10) & (f[0].length() < 2)) {
                                f[0] = "0" + f[0];
                            }

                            if (k % 2 == 0) {
                                in.add(f[0] + ":" + f[1]);
                            }
                            if (k % 2 == 1) {
                                out.add(f[0] + ":" + f[1]);
                            }
                        }
                    } catch (Exception NFE) {
                        System.err.println("invalid time");
                        //если первый элемент не прошёл проверку по формату, то ничего не добавляем
                        if (k % 2 == 0) {
                            break;
                        }
                    }
                }
            }

            //если прошли проверку по символам, первый элемент добавился, но второй нет (потому что не подошёл по формату)
            if ((in.size() > out.size())) {
                in.remove(in.size() - 1);
                continue;//переходим к новой итерации
            }

            //удалим значения если дата ухода раньше даты прихода
            if (out.isEmpty()) {
            } else {
                if ((out.get(out.size() - 1) != null)) {
                    byte hourLocal1 = Byte.parseByte(in.get(in.size() - 1).substring(0, 2));
                    byte minLocal1 = Byte.parseByte(in.get(in.size() - 1).substring(3, 5));
                    byte hourLocal2 = Byte.parseByte(out.get(out.size() - 1).substring(0, 2));
                    byte minLocal2 = Byte.parseByte(out.get(out.size() - 1).substring(3, 5));

                    if ((minLocal1 + hourLocal1 * 60) > (minLocal2 + hourLocal2 * 60)) {
                        in.remove(in.size() - 1);
                        out.remove(out.size() - 1);
                    }
                }
            }
        }

    }

    private void findDensity(List<String> inTimeA, List<String> outTimeB) {
        List<String> inTime = inTimeA;
        List<String> outTime = outTimeB;

        for (int fillvalue = 0; fillvalue < (23 * 60 + 59); fillvalue++) {
            density.add(0);
        }//у нас 23 часа 59 минут максимальное значение
        //сначала заполнили нулями, затем просто найдём плотность

        int countinTime = 0;
        for (String s1 : inTime) {
            if (s1 != null) {
                byte hourLocal1 = Byte.parseByte(inTime.get(countinTime).substring(0, 2));
                byte minLocal1 = Byte.parseByte(inTime.get(countinTime).substring(3, 5));
                int startValueFill = hourLocal1 * 60 + minLocal1;

                for (int k = startValueFill; k < (60 * 23 + 59); k++) {
                    density.set(k, density.get(k) + 1);
                }
            }
            countinTime++;
        }

        countinTime = 0;
        for (String s2 : outTime) {

            if (s2 != null) {
                byte hourLocal2 = Byte.parseByte(outTime.get(countinTime).substring(0, 2));
                byte minLocal2 = Byte.parseByte(outTime.get(countinTime).substring(3, 5));
                int lastValueFill = hourLocal2 * 60 + minLocal2;

                for (int k = 60 * 23 + 59 - 1; k > lastValueFill; k--) {
                    density.set(k, density.get(k) - 1);
                }
            }

            countinTime++;
        }

    }

    public List<String> findMaxInterval(List<Integer> density) {
        this.density = density;
        int max = 0;

        int count = 0;
        for (Integer s1 : density) {
            if (density.get(count) > max) {
                max = density.get(count);
            }
            count++;
        }


        count = 0;
        int start = 0;
        int finish = 0;
        for (Integer s1 : density) {
            if (density.get(count) == max) {

                if ((count - 1) == -1) {
                    start = count;
                }

                if (count - 1 > 0) {
                    if (density.get(count - 1) < max) {
                        start = count;
                    }
                }
            }

            if (count == 0) {
            } else {
                if ((density.get(count) < max) & (density.get(count - 1) == max)) {
                    finish = count - 1;
                    int hour = (start / 60);
                    String HourStringStart;
                    if (hour < 10) {
                        HourStringStart = "0" + Integer.toString(hour);
                    } else {
                        HourStringStart = Integer.toString(hour);
                    }
                    int min = (start % 60);
                    String HourMinStart;
                    if (min < 10) {
                        HourMinStart = "0" + Integer.toString(min);
                    } else {
                        HourMinStart = Integer.toString(min);
                    }
                    intervalArray.add(HourStringStart + ":" + HourMinStart);

                    hour = (finish / 60);
                    String HourStringFinish;
                    if (hour < 10) {
                        HourStringFinish = "0" + Integer.toString(hour);
                    } else {
                        HourStringFinish = Integer.toString(hour);
                    }
                    min = (finish % 60);
                    String HourMinFinish;
                    if (min < 10) {
                        HourMinFinish = "0" + Integer.toString(min);
                    } else {
                        HourMinFinish = Integer.toString(min);
                    }

                    intervalArray.add(HourStringFinish + ":" + HourMinFinish);
                    start = 0;
                    finish = 0;
                }
            }
            count++;
        }
        return intervalArray;
    }

    public static void main(String args[]) {

        String a[][] = {{" 08:10", "17:1"},
                {" 08:1", "17:01"},
                {" 08:10", "17:01"},
                {"9:00", "18:00"},
                {"9:00", "18:00"},
                {"9:00", "19:00"},
                {"10:00", "19:00"},
                {"11:00", "20:00"},
                {null, "20:00"},
                {"08:00", "9:02"},
                {null, null},
                {"11:03", null},
                {"", ""},
                {"25:78", "-1:00"},
                {"14:00", "-1:00"},
                {"-1:00", "-1:00"},
                {"13:00", "9:00"},
                {"00:00", "00:01"},
                {"00:00", "00:02"},
                {"00:00", "00:03"},
                {"17:03", "18:03"},
                {"7:3", "18:03"}

        };

        Example4 p = new Example4(a);
    }

}
