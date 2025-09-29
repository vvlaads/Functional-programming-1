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
        int current_number = 0;
        int result = 0;
        int n = 0;

        while (current_number <= 4_000_000) {
            current_number = fibonacci(n);
            if (current_number % 2 == 0) {
                result += current_number;
            }
            n++;
        }

        System.out.println(result);
    }
}