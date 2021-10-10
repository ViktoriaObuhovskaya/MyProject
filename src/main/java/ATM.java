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
        if (withdrawalMoney < 20 || withdrawalMoney % 10 != 0 || withdrawalMoney == 30
                || withdrawalMoney == balance - 30 || withdrawalMoney == balance - 10 || withdrawalMoney > balance) {
            System.out.println(false);
            return;
        } else {
            System.out.println(true);
            System.out.println("The amount that is in the ATM after the withdrawal of money " + (balance - withdrawalMoney));
        }

        System.out.println("In denominations of what denomination the amount is issued upon withdrawal: ");
        for (int i = 1; i < withdrawalMoney; i++) {
            if (withdrawalMoney % 100 == 0 || withdrawalMoney % 50 == 0 || withdrawalMoney % 20 == 0 || withdrawalMoney % 100 == 10 || withdrawalMoney % 100 == 30
                    || withdrawalMoney % 100 == 70 || withdrawalMoney % 100 == 90) {
                i = withdrawalMoney / 100;
                if (i <= getNumberOfBanknotes100()&& (withdrawalMoney % 100 == 10 || withdrawalMoney % 100 == 30)) {
                    i--;
                    if (i > 0) {
                        System.out.println("number of denominations of 100: " + i);
                        withdrawalMoney -= i * 100;
                    }
                } else if (i <= getNumberOfBanknotes100() && i > 0) {
                    System.out.println("number of denominations of 100: " + i);
                    withdrawalMoney -= i * 100;
                } else if (i > getNumberOfBanknotes100()) {
                    i = getNumberOfBanknotes100();
                    System.out.println("number of denominations of 100: " + i);
                    withdrawalMoney -= getNumberOfBanknotes100() * 100;
                }

                i = withdrawalMoney / 50;
                if (i > 1 && (withdrawalMoney % 100 == 60 || withdrawalMoney % 100 == 80)) {
                    if (i <= getNumberOfBanknotes50()) {
                        i--;
                        System.out.println("number of denominations of 50: " + i);
                        withdrawalMoney -= i * 50;
                    } else {
                        i = getNumberOfBanknotes50() - 1;
                        System.out.println("number of denominations of 50: " + i);
                        withdrawalMoney -= i * 50;
                    }
                } else if (i <= getNumberOfBanknotes50() && i > 0 && (withdrawalMoney % 100 == 10 || withdrawalMoney % 100 == 30)) {
                    i--;
                    System.out.println("number of denominations of 50: " + i);
                    withdrawalMoney -= i * 50;
                } else if (i <= getNumberOfBanknotes50() && i > 0 && withdrawalMoney % 100 != 60 && withdrawalMoney % 100 != 80) {
                    System.out.println("number of denominations of 50: " + i);
                    withdrawalMoney -= i * 50;
                } else if (i > getNumberOfBanknotes50() && (withdrawalMoney % 100 == 0 || withdrawalMoney % 100 == 20 || withdrawalMoney % 100 == 40)) {
                    i = getNumberOfBanknotes50() - 1;
                    System.out.println("number of denominations of 50: " + i);
                    withdrawalMoney -= i * 50;
                } else if (i > getNumberOfBanknotes50()) {
                    i = getNumberOfBanknotes50();
                    System.out.println("number of denominations of 50: " + i);
                    withdrawalMoney -= i * 50;
                }

                i = withdrawalMoney / 20;
                if (i <= getNumberOfBanknotes20() && i > 0) {
                    System.out.println("number of denominations of 20: " + i);
                }
                return;
            }
        }
    }
}

