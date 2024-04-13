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
            System.out.println("Monthly mortgage is $" + monthlyMortgage + " and totaled interest is $" + totaledInterest);
//        }
//        else if(userIn == 2) {
//
//        }
        }

        }
    //Creating mortgage calculator, Calculating monthly mortgage
    public static double mortgageCalc(double loan, double rate, int term) {
        double decimalIntRate = rate / 100;
        double mortgage = (double) loan * (decimalIntRate / 12) * (Math.pow(1 + (decimalIntRate / 12), 12 * term) / (Math.pow(1 + (decimalIntRate / 12), 12 * term) - 1));
        return mortgage;
    }
}