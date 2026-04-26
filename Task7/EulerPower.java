package Task7;

public class EulerPower {

    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return Math.abs(a);
    }

    static long modPow(long a, long n, long m) {
        if (m == 1)
            return 0;

        long result = 1;
        long base = a % m;

        while (n > 0) {
            if ((n & 1) == 1) {
                result = (result * base) % m;
            }
            base = (base * base) % m;
            n >>= 1;
        }

        return result;
    }

    static long eulerPhi(long n) {
        long result = n;
        long temp = n;

        if (temp % 2 == 0) {
            result -= result / 2;
            while (temp % 2 == 0)
                temp /= 2;
        }

        for (long p = 3; p * p <= temp; p += 2) {
            if (temp % p == 0) {
                result -= result / p;
                while (temp % p == 0)
                    temp /= p;
            }
        }

        if (temp > 1) {
            result -= result / temp;
        }

        return result;
    }

    static long modPowEuler(long a, long n, long m) {
        if (m == 1)
            return 0;

        long g = gcd(a, m);

        if (g == 1) {
            long phi = eulerPhi(m);

            long reducedN = n % phi;
            if (reducedN == 0)
                reducedN = phi;

            return modPow(a, reducedN, m);
        } else {
            return modPow(a, n, m);
        }
    }

    public static void main(String[] args) {

        System.out.println("=== \r\n" + //
                "Euler's theorem ===");

        System.out.println("2^1000000 mod 7 = " +
                modPowEuler(2, 1000000, 7));

        System.out.println("3^1000000000 mod 11 = " +
                modPowEuler(3, 1000000000L, 11));
    }
}