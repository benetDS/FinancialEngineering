package frequencyofcompounding.continuouscompounding;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.function.Function;

public class ContinuousCompounding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Enter principal
        System.out.print("Principal: ");
        BigDecimal presentValue = new BigDecimal(sc.nextDouble());

        // Enter quoted interest rate
        System.out.print("Quoted interest rate: ");
        double quotedInterestRate = sc.nextDouble();

        // Enter number of periods
        System.out.print("Number of periods: ");
        int periods = sc.nextInt();

        // Using lambda expressions to calculate future value with continuous compounding
        Function<Integer, BigDecimal> futureValue = N-> {
            return presentValue.multiply(BigDecimal.valueOf(
                    Math.pow(Math.E, (quotedInterestRate/100)*N)
            ));
        };

        System.out.printf("You received after %d year(s) continuous compounding with " +
                          "quoted interest rate of %.2f%%: %.4f",
                          periods,
                          quotedInterestRate,
                          futureValue.apply(periods));
    }
}
