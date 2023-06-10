package singlecashflow;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.function.Function;

public class FutureValueLambda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Enter principal
        System.out.print("Principal: ");
        BigDecimal presentValue = new BigDecimal(sc.nextDouble());

        // Enter interest rate
        System.out.print("Interest rate: ");
        double interestRate = sc.nextDouble();

        // Enter number of periods
        System.out.print("Number of periods: ");
        int periods = sc.nextInt();

        // Using lambda expressions to calculate future value
        Function<Integer, BigDecimal> futureValue = n-> {
            return presentValue.multiply(BigDecimal.valueOf(Math.pow(1+interestRate/100, n)));
        };

        // Print the result
        System.out.printf("You received after %d year(s) with annual interest rate of %.2f%%: %.4f",
                          periods, interestRate, futureValue.apply(periods));
    }
}