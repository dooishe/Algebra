package Task2;

import java.util.Scanner;

public class PrimeFactorization {

  public static void factorize(long n) {
    System.out.print("prime factors: ");

    while (n % 2 == 0) {
      System.out.print(2 + " ");
      n /= 2;
    }

    for (long i = 3; i * i <= n; i += 2) {
      while (n % i == 0) {
        System.out.print(i + " ");
        n /= i;
      }
    }

    if (n > 1) {
      System.out.print(n);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter number: ");
    long number = scanner.nextLong();

    factorize(number);
    scanner.close();
  }
}