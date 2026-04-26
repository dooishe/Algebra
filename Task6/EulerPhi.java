package Task6;

public class EulerPhi {

    public static int eulerPhi(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int result = n;
        int temp = n;

        if (temp % 2 == 0) {
            result -= result / 2;
            while (temp % 2 == 0) {
                temp /= 2;
            }
        }

        int p = 3;
        while (p * p <= temp) {
            if (temp % p == 0) {
                result -= result / p;
                while (temp % p == 0) {
                    temp /= p;
                }
            }
            p += 2;
        }

        if (temp > 1) {
            result -= result / temp;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Euler function ===");
        int[] testValues = { 1, 10, 36, 100, 17 };

        for (int n : testValues) {
            System.out.println("φ(" + n + ") = " + eulerPhi(n));
        }
    }
}