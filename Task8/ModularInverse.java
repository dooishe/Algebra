package Task8;

public class ModularInverse {

    static class Result {
        long g, x, y;

        Result(long g, long x, long y) {
            this.g = g;
            this.x = x;
            this.y = y;
        }
    }

    static Result extendedGCD(long a, long b) {
        if (b == 0) {
            return new Result(Math.abs(a), a > 0 ? 1 : -1, 0);
        }

        Result r = extendedGCD(b, a % b);

        long x = r.y;
        long y = r.x - (a / b) * r.y;

        return new Result(r.g, x, y);
    }

    static long modInverse(long a, long n) {
        Result r = extendedGCD(a, n);

        if (r.g != 1) {
            throw new RuntimeException("Inverse does not exist: gcd(a, n) != 1");
        }

        return (r.x % n + n) % n;
    }

    static long modPow(long a, long e, long m) {
        long result = 1;
        long base = a % m;

        while (e > 0) {
            if ((e & 1) == 1) {
                result = (result * base) % m;
            }
            base = (base * base) % m;
            e >>= 1;
        }

        return result;
    }

    static boolean isPrime(long n) {
        if (n < 2)
            return false;
        if (n % 2 == 0)
            return n == 2;

        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    static long modInverseFermat(long a, long n) {
        if (!isPrime(n)) {
            throw new RuntimeException("Fermat method requires prime modulus");
        }

        if (a % n == 0) {
            throw new RuntimeException("Inverse does not exist");
        }

        return modPow(a, n - 2, n);
    }

    public static void main(String[] args) {

        System.out.println("=== Multiplicative Inverse ===");

        long a = 3, n = 11;

        long inv = modInverse(a, n);

        System.out.println(a + "^-1 mod " + n + " = " + inv);
        System.out.println("verification: (" + a + " * " + inv + ") mod " + n + " = " + (a * inv) % n);

        if (isPrime(n)) {
            long invF = modInverseFermat(a, n);
            System.out.println("Fermat method result: " + invF);
        }
    }
}