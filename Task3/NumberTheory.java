package Task3;

public final class NumberTheory {

    private NumberTheory() {
    }

    public static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static long lcm(long a, long b) {
        if (a == 0 || b == 0)
            return 0;
        long g = gcd(a, b);
        return Math.abs(a / g * b);
    }

    public static class ExtendedGSD {
        public final long d, x, y;

        public ExtendedGSD(long d, long x, long y) {
            this.d = d;
            this.x = x;
            this.y = y;
        }
    }

    public static ExtendedGSD extendedGcd(long a, long b) {
        boolean negA = a < 0;
        boolean negB = b < 0;
        a = Math.abs(a);
        b = Math.abs(b);

        if (b == 0) {
            return new ExtendedGSD(a, negA ? -1 : 1, 0);
        }

        ExtendedGSD r = extendedGcd(b, a % b);
        long d = r.d;
        long x1 = r.x, y1 = r.y;
        long x = y1;
        long y = x1 - (a / b) * y1;

        return new ExtendedGSD(d, negA ? -x : x, negB ? -y : y);
    }

    public static void main(String[] args) {
        long a = 48, b = 36;

        System.out.println("GCD(" + a + ", " + b + ") = " + gcd(a, b));
        System.out.println("LCM(" + a + ", " + b + ") = " + lcm(a, b));

        ExtendedGSD eg = extendedGcd(a, b);
        System.out.println("extendedGCD: d = " + eg.d + ", x = " + eg.x + ", y = " + eg.y);
        System.out.printf("%d * %d + %d * %d = %d%n", a, eg.x, b, eg.y, a * eg.x + b * eg.y);
    }
}