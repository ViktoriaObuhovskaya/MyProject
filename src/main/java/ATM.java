package main.java;

import java.util.Scanner;

class ATM {
    private int balance;
    private int numberOfBanknotes20;
    private int numberOfBanknotes50;
    private int numberOfBanknotes100;

    ATM(int numberOfBanknotes20, int numberOfBanknotes50, int numberOfBanknotes100) {
        this.numberOfBanknotes20 = numberOfBanknotes20;
        this.numberOfBanknotes50 = numberOfBanknotes50;
        this.numberOfBanknotes100 = numberOfBanknotes100;
    }

    private int getNumberOfBanknotes20() {
        return numberOfBanknotes20;
    }

    private int getNumberOfBanknotes50() {
        return numberOfBanknotes50;
    }

    private int getNumberOfBanknotes100() {
        return numberOfBanknotes100;
    }

    private Scanner in = new Scanner(System.in);

    void operation() {
        System.out.println("Enter the number of the operation to be performed \n1-add money, 2-withdraw money ");
        int number = in.nextInt();
        System.out.print("The amount of money in the ATM ");
        balance = getNumberOfBanknotes20() * 20 + getNumberOfBanknotes50() * 50 + getNumberOfBanknotes100() * 100;
        System.out.println(balance);
        if (number == 1) {
            addMoney();
        } else if (number == 2) {
            withdrawalMoney();
        }
    }

    private void addMoney() {
        System.out.println("Enter the amount you want to add ");
        int addMoney = in.nextInt();
        if (addMoney % 5 != 0) {
            System.out.println(false);
        } else {
            System.out.println(true);
            balance += addMoney;
            System.out.print("The amount that is in the ATM after add of money " + balance);
        }
    }

    private void withdrawalMoney() {
        System.out.println("Enter the amount you want to withdraw ");
        int withdrawalMoney = in.nextInt();
        if (withdrawalMoney < 20 || withdrawalMoney % 10 != 0 || withdrawalMoney == 30 || withdrawalMoney == balance - 30 || withdrawalMoney == balance - 10 || withdrawalMoney > balance) {
            System.out.println(false);
            return;
        } else {
            System.out.println(true);
            System.out.println("The amount that is in the ATM after the withdrawal of money " + (balance - withdrawalMoney));
        }

        System.out.println("In denominations of what denomination the amount is issued upon withdrawal: ");
        int numberOfBanknotes;
        numberOfBanknotes = withdrawalMoney / 100;
        if (numberOfBanknotes <= getNumberOfBanknotes100()) {
            if (withdrawalMoney % 100 != 10 && withdrawalMoney % 100 != 30) {
                System.out.println("number of denominations of 100: " + numberOfBanknotes);
            } else {
                numberOfBanknotes--;
                System.out.println("number of denominations of 100: " + numberOfBanknotes);
            }
        }
        if (numberOfBanknotes > getNumberOfBanknotes100()) {
            numberOfBanknotes = getNumberOfBanknotes100();
            System.out.println("number of denominations of 100: " + numberOfBanknotes);
        }
        withdrawalMoney -= numberOfBanknotes * 100;

        numberOfBanknotes = withdrawalMoney / 50;
        if (numberOfBanknotes <= getNumberOfBanknotes50()) {
            if (withdrawalMoney % 100 == 10 || withdrawalMoney % 100 == 30 || withdrawalMoney % 100 == 60 || withdrawalMoney % 100 == 80) {
                numberOfBanknotes--;
                System.out.println("number of denominations of 50: " + numberOfBanknotes);
            } else {
                System.out.println("number of denominations of 50: " + numberOfBanknotes);
            }
        }
        if (numberOfBanknotes > getNumberOfBanknotes50()) {
            if (withdrawalMoney % 100 != 10 && withdrawalMoney % 100 != 30 && withdrawalMoney % 100 != 50 && withdrawalMoney % 100 != 70 && withdrawalMoney % 100 != 90) {
                numberOfBanknotes = getNumberOfBanknotes50() - 1;
                System.out.println("number of denominations of 50: " + numberOfBanknotes);
            } else {
                numberOfBanknotes = getNumberOfBanknotes50();
                System.out.println("number of denominations of 50: " + numberOfBanknotes);
            }
        }
        withdrawalMoney -= numberOfBanknotes * 50;

        numberOfBanknotes = withdrawalMoney / 20;
        if (numberOfBanknotes <= getNumberOfBanknotes20()) {
            System.out.println("number of denominations of 20: " + numberOfBanknotes);
        }
    }
}









