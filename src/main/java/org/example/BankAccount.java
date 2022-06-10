package org.example;


public class BankAccount {
        private String lastName;
        private String firstName;
        private double balance;

        public static final int CHECKING = 1;
        public static final int  SAVINGS = 2;

        private int accountType;

        public BankAccount(String lastName, String firstName, double balance, int typeOfAccount) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.balance = balance;
            this.accountType = typeOfAccount;
        }
        public double deposit(double amount, boolean branch){
            balance += amount;
            return balance;
        }

        public double withdraw(double amount, boolean branch){
            if(amount > 500.00 && !branch){
                throw new IllegalArgumentException();
            }
            balance -= amount;
            return balance;
        }

        public double getBalance() {
            return balance;
        }
        public boolean isChecking(){
            return accountType == CHECKING;


        }
}
