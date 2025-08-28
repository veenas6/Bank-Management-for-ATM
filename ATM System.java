package atm;

import java.util.Scanner;

public class simpleATM {
    private int acc_no;
    private int pin;
    private double balance;
    static int acc_cnt = 0;

    int getAccountNo() {
        return acc_no;
    }

    void checkBalance() {
        System.out.println("Balance is " + balance);
    }

    simpleATM(int pin, double balance) {
        this.acc_no = ++acc_cnt;   // auto-generate account no
        this.pin = pin;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount should be positive");
        }
        balance += amount;
        System.out.println("Deposit successful. New balance = " + balance);
    }

    void withdraw(int pin, double amount) {
        if (this.pin != pin) {
            System.out.println("Invalid PIN!");
            return;
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Amount should be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
        System.out.println("Withdrawal successful. New balance = " + balance);
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        simpleATM account[] = new simpleATM[3];

        // Create 3 accounts
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter pin code and initial balance:");
            int pin = s.nextInt();
            double balance = s.nextDouble();
            account[i] = new simpleATM(pin, balance);
            System.out.println("Account created with Account No: " + account[i].getAccountNo());
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account No: ");
                    int accNo1 = s.nextInt();
                    System.out.print("Enter amount to deposit: ");
                    double dep = s.nextDouble();
                    account[accNo1 - 1].deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter Account No: ");
                    int accNo2 = s.nextInt();
                    System.out.print("Enter PIN: ");
                    int wpin = s.nextInt();
                    System.out.print("Enter amount to withdraw: ");
                    double amt = s.nextDouble();
                    account[accNo2 - 1].withdraw(wpin, amt);
                    break;

                case 3:
                    System.out.print("Enter Account No: ");
                    int accNo3 = s.nextInt();
                    account[accNo3 - 1].checkBalance();
                    break;

                case 4:
                    exit = true;
                    System.out.println("Exiting ATM...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        s.close();
    }
}