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
            double principle = scanner.nextDouble();
            System.out.println("Enter interest rate: ");
            double intRate = scanner.nextDouble();
            System.out.println("Enter loan length(In Years):");
            int loanTerm = scanner.nextInt();
            double monthlyMortgage = mortgageCalc(principle, intRate, loanTerm);
            double totaledInterest = ((loanTerm * 12 * monthlyMortgage) - principle);
            System.out.println("A $" + principle + "loan at " + intRate + "% interest for " + loanTerm + " years would have a $" + monthlyMortgage + "/mo payment with total interest of $" + totaledInterest);
        }
        else if(userIn == 2) {
            System.out.println("Enter deposit amount: ");
            double deposit = scanner.nextDouble();
            System.out.println("Enter interest rate: ");
            double intRate = scanner.nextDouble();
            System.out.println("Enter number of years: ");
            int years = scanner.nextInt();
            double endingBal = cdCalc(deposit, intRate, years);
            double balanceDifference = endingBal - deposit;
            System.out.println("If you deposit $" + deposit + " in a CD that earns " + intRate + "% interest rate and matures in " + years
                    + " years, your CD's ending balance will be $" + endingBal + " and you would have earned $" + balanceDifference + "in interest");

        }
    }
    //Creating mortgage calculator, Calculating monthly mortgage
    public static double mortgageCalc(double loan, double rate, int term) {
        double decimalIntRate = rate / 100;
        double mortgage = (double) loan * (decimalIntRate / 12) * (Math.pow(1 + (decimalIntRate / 12), 12 * term) / (Math.pow(1 + (decimalIntRate / 12), 12 * term) - 1));
        return mortgage;
        }

    //Creating CD Calculator
    public static double cdCalc(double deposit, double rate, int years) {
        double rateDecimal = rate / 100;
        double endingBal = deposit * Math.pow(1 + rateDecimal / 365, 365 * years);
        return endingBal;
    }
}