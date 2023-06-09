package singlecashflow;

import java.util.Scanner;
import java.util.function.Function;

public class FutureValueLambda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Enter principal
        System.out.print("Principal: ");
        double presentValue = sc.nextDouble();

        // Enter interest rate
        System.out.print("Interest rate: ");
        double interestRate = sc.nextDouble();

        //Enter number of periods
        System.out.print("Number of periods: ");
        int periods = sc.nextInt();

        // Future value formula by lambda expression
        Function<Integer, Double> futureValue = n -> {
            return presentValue * Math.pow(1 + interestRate/100, n);
        };
        System.out.printf("You received after %d year(s) with %.2f: %.4f",
                          periods, interestRate, futureValue.apply(periods));
    }
}
