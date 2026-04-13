package Task4;

public class Main {

  public static long power(long a, long x) {
    long res = 1;

    while (x > 0) {
      if (x % 2 == 1) {
        res *= a;
      }
      a *= a;
      x /= 2;
    }

    return res;
  }

  public static void main(String[] args) {
    System.out.println(power(2, 13)); // 8192
  }
}