public class Main {
    public static int fibonacci(int n) {
        if (n < 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int currentNumber = 0;
        int result = 0;
        int n = 0;

        while (currentNumber <= 4_000_000) {
            currentNumber = fibonacci(n);
            if (currentNumber % 2 == 0) {
                result += currentNumber;
            }
            n++;
        }

        System.out.println(result);
    }
}