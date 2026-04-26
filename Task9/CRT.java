package Task9;

public class CRT {

  static long gcd(long a, long b) {
    while (b != 0) {
      long t = a % b;
      a = b;
      b = t;
    }
    return Math.abs(a);
  }

  static long[] extendedGCD(long a, long b) {
    if (b == 0) {
      return new long[] { Math.abs(a), a > 0 ? 1 : -1, 0 };
    }

    long[] res = extendedGCD(b, a % b);

    long g = res[0];
    long x1 = res[1];
    long y1 = res[2];

    long x = y1;
    long y = x1 - (a / b) * y1;

    return new long[] { g, x, y };
  }

  static long modInverse(long a, long m) {
    long[] res = extendedGCD(a, m);

    if (res[0] != 1) {
      throw new RuntimeException("Inverse does not exist");
    }

    return (res[1] % m + m) % m;
  }

  static long chineseRemainder(long[] r, long[] m) {

    int n = m.length;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (gcd(m[i], m[j]) != 1) {
          throw new RuntimeException("Moduli are not coprime");
        }
      }
    }

    long M = 1;
    for (long mi : m)
      M *= mi;

    long result = 0;

    for (int i = 0; i < n; i++) {
      long Mi = M / m[i];
      long inv = modInverse(Mi, m[i]);

      result += r[i] * Mi * inv;
    }

    return result % M;
  }

  public static void main(String[] args) {

    System.out.println("=== Chinese Remainder Theorem ===");

    long[] r = { 2, 3, 2 };
    long[] m = { 3, 5, 7 };

    long x = chineseRemainder(r, m);

    System.out.println("Solution found: x = " + x);

    for (int i = 0; i < m.length; i++) {
      System.out.println("x mod " + m[i] + " = " + (x % m[i]));
    }
  }
}