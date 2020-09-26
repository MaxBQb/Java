package pr_5;

public class Main {
    public static void main(String[] args) {
        System.out.println("3. От A до B");
        printRange(1, 5);
        printRange(5, 1);

        System.out.println("4. Заданная сумма цифр");
        System.out.println(countDSumEquivalents(3, 14));
        System.out.println(countDSumEquivalents(3, 27));
        System.out.println(countDSumEquivalents(3, 28));

        System.out.println("5. Сумма цифр числа (это вообще подзадача 4)");
        System.out.println(digitSum(328));
        System.out.println(digitSum(10000));
        System.out.println(digitSum(10900));
        System.out.println(digitSum(1111111111));

        // Просили минимум 3 задачки...
        // Мне лень решать задачку на решето Эратосфена
        // Поэтому.. вот — ровно 3 задачки))))
    }

    public static void printRange(int a, int b) {
        System.out.println(a);
        if (a < b)
            printRange(a+1, b);
        else if (a > b)
            printRange(a-1, b);
    }

    public static int digitSum(int value) {
        if (value == 0)
            return 0;
        return value%10 + digitSum(value/10);
        /*
        * В этой задаче можно использовать цикл для перебора всех цифр,
        * стоящих на какой-либо позиции, — а можно и не использовать :)
        * */
    }

    public static int countDSumEquivalents(int digits_count, int sum_needed) {
        return _countDSumEquivalents(sum_needed, (int)Math.pow(10, digits_count-1), (int)Math.pow(10, digits_count));
    }

    private static int _countDSumEquivalents(int sum_needed, int digit, int max_digit) {
        if (digit >= max_digit)
            return 0;
        return (digitSum(digit) == sum_needed ? 1 : 0) + _countDSumEquivalents(sum_needed, digit+1, max_digit);
    }

}

