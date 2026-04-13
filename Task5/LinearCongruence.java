package Task5;

import java.util.*;

public class LinearCongruence {

    static class GCDResult {
        long d, x, y;

        GCDResult(long d, long x, long y) {
            this.d = d;
            this.x = x;
            this.y = y;
        }
    }

    static GCDResult euclidean(long a, long b) {
        if (b == 0) {
            return new GCDResult(a, 1, 0);
        }
        GCDResult res = euclidean(b, a % b);
        long d = res.d;
        long x = res.y;
        long y = res.x - (a / b) * res.y;
        return new GCDResult(d, x, y);
    }

    // решение A*x ≡ B (mod n)
    static List<Long> linear(long A, long B, long n) {
        GCDResult g = euclidean(A, n);

        long d = g.d;
        long x = g.x;

        if (B % d != 0) {
            return null;
        }

        long nDiv = n / d;

        long xBase = (x * (B / d)) % nDiv;
        if (xBase < 0)
            xBase += nDiv;

        List<Long> res = new ArrayList<>();

        for (int k = 0; k < d; k++) {
            long xk = (xBase + k * nDiv) % n;
            res.add(xk);
        }

        return res;
    }
}