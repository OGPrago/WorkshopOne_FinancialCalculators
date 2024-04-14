package com.ps;

import java.util.Scanner;

public class FinanceCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Asking user which calculator they want to use
        System.out.println("Which calculator would you like to use? (1)Mortgage, (2)Future Value");
        byte userIn = scanner.nextByte();

        //Creating if statements for each calculator
        if (userIn == 1) {
            System.out.println("Enter the principle: ");
            float principle = scanner.nextFloat();
            System.out.println("Enter interest rate: ");
            float intRate = scanner.nextFloat();
            System.out.println("Enter loan length(In Years):");
            int loanTerm = scanner.nextInt();
            float monthlyMortgage = mortgageCalc(principle, intRate, loanTerm);
            float totaledInterest = ((loanTerm * 12 * monthlyMortgage) - principle);
            System.out.println("A $" + principle + "loan at " + intRate + "% interest for " + loanTerm + " years would have a $" + monthlyMortgage + "/mo payment with total interest of $" + totaledInterest);
        }
        else if(userIn == 2) {
            System.out.println("Enter deposit amount: ");
            float deposit = scanner.nextFloat();
            System.out.println("Enter interest rate: ");
            float intRate = scanner.nextFloat();
            System.out.println("Enter number of years: ");
            int years = scanner.nextInt();
            float endingBal = cdCalc(deposit, intRate, years);
            float balanceDifference = endingBal - deposit;
            System.out.println("If you deposit $" + deposit + " in a CD that earns " + intRate + "% interest rate and matures in " + years
                    + " years, your CD's ending balance will be $" + endingBal + " and you would have earned $" + balanceDifference + "in interest");

        }
    }
    //Creating mortgage calculator, Calculating monthly mortgage
    public static float mortgageCalc(float loan, float rate, int term) {
        float decimalIntRate = rate / 100;
        float mortgage = (float) (loan * (decimalIntRate / 12) * (Math.pow(1 + (decimalIntRate / 12), 12 * term) / (Math.pow(1 + (decimalIntRate / 12), 12 * term) - 1)));
        return mortgage;
    }

    //Creating CD Calculator
    public static float cdCalc(float deposit, float rate, int years) {
        float rateDecimal = rate / 100;
        float endingBal = (float) (deposit * Math.pow(1 + rateDecimal / 365, 365 * years));
        return endingBal;
    }
}