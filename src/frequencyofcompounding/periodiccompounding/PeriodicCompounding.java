package frequencyofcompounding.periodiccompounding;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Function;

public class PeriodicCompounding {
    enum Frequency {
        MONTHLY(12, "monthly"),
        QUARTERLY(4, "quarterly"),
        SEMIANNUALLY(2, "semiannually"),
        ANNUALLY(1, "annually");

        private int numberOfCompoundingPeriods;
        private String timeFrequency;

        Frequency(int numberOfCompoundingPeriods, String timeFrequency) {
            this.numberOfCompoundingPeriods = numberOfCompoundingPeriods;
            this.timeFrequency = timeFrequency;
        }

        public int getNumberOfCompoundingPeriods() {
            return numberOfCompoundingPeriods;
        }

        public String getTimeFrequency() {
            return timeFrequency;
        }
    }

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

        // Enter frequency of compounding
        System.out.println("Enter frequency of compounding by pressing one of the following numbers: \n" +
                           "\t1. MONTHLY\n" +
                           "\t2. QUARTERLY\n" +
                           "\t3. SEMIANNUALLY\n" +
                           "\t4. ANNUALLY");
        System.out.print("Your number: ");
        int frequency = sc.nextInt();

        // Use hashmap to translate frequency input with the enum of number of compounding periods
        HashMap<Integer, Integer> correspondingFrequency= new HashMap<Integer, Integer>();
        correspondingFrequency.put(1, Frequency.MONTHLY.getNumberOfCompoundingPeriods());
        correspondingFrequency.put(2, Frequency.QUARTERLY.getNumberOfCompoundingPeriods());
        correspondingFrequency.put(3, Frequency.SEMIANNUALLY.getNumberOfCompoundingPeriods());
        correspondingFrequency.put(4, Frequency.ANNUALLY.getNumberOfCompoundingPeriods());

        // Use hashmap to translate frequency input with the enum of time frequency
        HashMap<Integer, String> correspondingTimeScale= new HashMap<Integer, String>();
        correspondingTimeScale.put(1, Frequency.MONTHLY.getTimeFrequency());
        correspondingTimeScale.put(2, Frequency.QUARTERLY.getTimeFrequency());
        correspondingTimeScale.put(3, Frequency.SEMIANNUALLY.getTimeFrequency());
        correspondingTimeScale.put(4, Frequency.ANNUALLY.getTimeFrequency());

        // Using lambda expressions to calculate future value with period compounding
        Function<Integer, BigDecimal> futureValue = N -> {
            return presentValue.multiply(BigDecimal.valueOf(
                Math.pow(
                        1+(quotedInterestRate/100)/correspondingFrequency.get(frequency),
                        correspondingFrequency.get(frequency)*N
                )
            ));
        };

        // Print the result
        System.out.printf("You received after %d year(s) %s compounding with quoted interest rate of %.2f%%: %.4f",
                          periods,
                          correspondingTimeScale.get(frequency),
                          quotedInterestRate,
                          futureValue.apply(periods));
    }
}